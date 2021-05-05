package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TaxEmailItemIistRowMapper implements RowMapper<TaxEmailItemListVO> {

    @Override
    public TaxEmailItemListVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new TaxEmailItemListVO(
            resultSet.getString("ISSUE_ID"),
            resultSet.getString("ISSUE_DAY"),
            resultSet.getInt("SEQ_NO"),
            resultSet.getString("PURCHASE_DAY"),
            resultSet.getString("ITEM_NAME"),
            resultSet.getString("ITEM_INFO"),
            resultSet.getString("ITEM_DESC"),
            resultSet.getLong("UNIT_QUANTITY"),
            resultSet.getLong("UNIT_AMOUNT"),
            resultSet.getLong("INVOICE_AMOUNT"), //10
            resultSet.getLong("TAX_AMOUNT")
        );
    }
}
