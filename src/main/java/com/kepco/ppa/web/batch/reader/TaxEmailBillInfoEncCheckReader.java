package com.kepco.ppa.web.batch.reader;

import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoRowMapper;
import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoVO;
import com.kepco.ppa.web.batch.domain.TaxEmailItemIistRowMapper;
import com.kepco.ppa.web.batch.domain.TaxEmailItemListVO;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.OraclePagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class TaxEmailBillInfoEncCheckReader {

    @Autowired
    @Setter
    private DataSource dataSource;

    public final int READER_FETCH_SIZE = 100;

    @Setter
    @Getter
    public String batchIds;

    public TaxEmailBillInfoEncCheckReader(String batchIds) {
        this.batchIds = batchIds;
    }

    public JdbcPagingItemReader<TaxEmailBillInfoVO> getPagingReader() {
        JdbcPagingItemReader<TaxEmailBillInfoVO> reader = new JdbcPagingItemReader<>();

        reader.setDataSource(this.dataSource);
        reader.setPageSize(READER_FETCH_SIZE);
        reader.setRowMapper(new TaxEmailBillInfoRowMapper());

        reader.setQueryProvider(createQuery());

        return reader;
    }

    private OraclePagingQueryProvider createQuery() {
        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("B_ESERO_ISSUE_ID", Order.ASCENDING);
        sortKeys.put("A_ISSUE_ID", Order.ASCENDING);

        OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();
        queryProvider.setSelectClause("A.*, B.ESERO_ISSUE_ID AS B_ESERO_ISSUE_ID, A.ISSUE_ID AS A_ISSUE_ID");
        queryProvider.setFromClause("FROM TAX_EMAIL_BILL_INFO A INNER JOIN EXEDI.TB_TAX_BILL_INFO_ENC B ON A.ISSUE_ID = B.ESERO_ISSUE_ID ");
        queryProvider.setWhereClause(getWhereClause());
        queryProvider.setSortKeys(sortKeys);

        return queryProvider;
    }

    private String getWhereClause() {
        StringBuilder sb = new StringBuilder();
        sb.append("A.MAIL_GUB_CODE = '2'"); // 개별메일인 경우 (1-대표메일)
        sb.append("   AND A.MAIL_STATUS_CODE IS NULL"); //메일진행상태(null:DEFAULT,'01':작성중및회계처리중,'02'회계처리완료,'98':공급받는자반려
        sb.append("   AND (A.INVOICEE_TAX_REGIST_ID != null OR A.INVOICEE_TAX_REGIST_ID != '0') ");
        sb.append("   AND (A.INVOICEE_CONTACT_EMAIL1 LIKE '%ppa%' OR A.INVOICEE_CONTACT_EMAIL2 LIKE '%ppa%') "); // 공급자 이메일이 ppa로 시작
        sb.append("  AND A.ISSUE_DT >= TO_CHAR(sysdate - 31, 'YYYYMMDDhh24miss')"); // 61일전 데이터까지 조회
        return sb.toString();
    }
}
