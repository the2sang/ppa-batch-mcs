package com.kepco.ppa.web.batch.reader;

import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoRowMapper;
import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoVO;
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

public class TaxEmailBillInfoDataReader {

    @Autowired
    @Setter
    private DataSource dataSource;

    public final int READER_FETCH_SIZE = 100;

    @Setter
    @Getter
    public String batchIds;

    public TaxEmailBillInfoDataReader(String batchIds) {
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
        Map<String, Order> sortKeys = new HashMap<>(1);
        sortKeys.put("ISSUE_DT", Order.DESCENDING);

        OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();
        queryProvider.setSelectClause("*");
        queryProvider.setFromClause("from TAX_EMAIL_BILL_INFO");
        queryProvider.setWhereClause(getWhereClause());
        queryProvider.setSortKeys(sortKeys);
        return queryProvider;
    }

    private String getWhereClause() {
        StringBuilder sb = new StringBuilder();

        sb.append("MAIL_GUB_CODE = '2'"); // 개별메일인 경우 (1-대표메일)
        sb.append("   AND MAIL_STATUS_CODE IS NULL"); //메일진행상태(null:DEFAULT,'01':작성중및회계처리중,'02'회계처리완료,'98':공급받는자반려, '88' : 중복처리
        sb.append("   AND (INVOICEE_CONTACT_EMAIL1 LIKE '%ppa%' OR INVOICEE_CONTACT_EMAIL2 LIKE '%ppa%') "); // 공급자 이메일이 ppa로 시작
        sb.append("   AND (INVOICEE_TAX_REGIST_ID != null OR INVOICEE_TAX_REGIST_ID != '0') "); // 종사업장코드가 null이 아니거나 0이 아닌것
        sb.append("  AND ISSUE_DT >= TO_CHAR(sysdate - 31, 'YYYYMMDDhh24miss')"); //31일 전 데이터까지 조회

        // 배치 ID별로 수집하여 실행
        if (batchIds != null) {
            sb.append(" AND ID IN (" + batchIds + ")");
        }

        return sb.toString();
    }
}
