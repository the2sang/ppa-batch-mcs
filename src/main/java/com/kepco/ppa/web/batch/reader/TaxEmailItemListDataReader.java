package com.kepco.ppa.web.batch.reader;

import com.kepco.ppa.web.batch.domain.TaxEmailItemIistRowMapper;
import com.kepco.ppa.web.batch.domain.TaxEmailItemListVO;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.Setter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.Order;
import org.springframework.batch.item.database.support.OraclePagingQueryProvider;
import org.springframework.beans.factory.annotation.Autowired;

public class TaxEmailItemListDataReader {

    @Autowired
    @Setter
    private DataSource dataSource;

    public final int READER_FETCH_SIZE = 50;

    public JdbcPagingItemReader<TaxEmailItemListVO> getPagingReader() {
        JdbcPagingItemReader<TaxEmailItemListVO> reader = new JdbcPagingItemReader<>();

        reader.setDataSource(this.dataSource);
        reader.setPageSize(READER_FETCH_SIZE);
        reader.setRowMapper(new TaxEmailItemIistRowMapper());

        reader.setQueryProvider(createQuery());

        return reader;
    }

    private OraclePagingQueryProvider createQuery() {
        Map<String, Order> sortKeys = new HashMap<>();
        sortKeys.put("B_ISSUE_ID", Order.ASCENDING);
        sortKeys.put("A_SEQ_NO", Order.ASCENDING);

        OraclePagingQueryProvider queryProvider = new OraclePagingQueryProvider();
        queryProvider.setSelectClause("A.*, B.ISSUE_ID AS B_ISSUE_ID, A.SEQ_NO AS A_SEQ_NO");
        queryProvider.setFromClause("FROM TAX_EMAIL_ITEM_LIST A INNER JOIN TAX_EMAIL_BILL_INFO B ON A.ISSUE_ID = B.ISSUE_ID ");
        queryProvider.setWhereClause(getWhereClause());
        queryProvider.setSortKeys(sortKeys);

        return queryProvider;
    }

    private String getWhereClause() {
        StringBuilder sb = new StringBuilder();
        sb.append("B.MAIL_GUB_CODE = '2'"); // 개별메일인 경우 (1-대표메일)
        sb.append("   AND B.MAIL_STATUS_CODE = '99' "); //메일진행상태(null:DEFAULT,'01':작성중및회계처리중,'02'회계처리완료,'98':공급받는자반려
        sb.append("   AND (B.INVOICEE_CONTACT_EMAIL1 LIKE '%ppa%' OR B.INVOICEE_CONTACT_EMAIL2 LIKE '%ppa%') "); // 공급자 이메일이 ppa로 시작
        //sb.append("  AND B.ISSUE_DT >= TO_CHAR(sysdate - 31, 'YYYYMMDDhh24miss')"); // 30일전 데이터까지 조회
        return sb.toString();
    }
}
