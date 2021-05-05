package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TbTradeItemListRowMapper implements RowMapper<TbTradeItemListVO> {

    @Override
    public TbTradeItemListVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new TbTradeItemListVO(
            resultSet.getString("IO_CODE"),
            resultSet.getString("ISSUE_DAY"),
            resultSet.getString("BIZ_MANAGE_ID"),
            resultSet.getInt("SEQ_NO"),
            resultSet.getString("PURCHASE_DAY"),
            resultSet.getString("ITEM_NAME"),
            resultSet.getString("ITEM_INFO"),
            resultSet.getString("ITEM_DESC"),
            resultSet.getLong("UNIT_QUANTITY"),
            resultSet.getLong("UNIT_AMOUNT"),
            resultSet.getLong("INVOICE_AMOUNT"),
            resultSet.getLong("TAX_AMOUNT")
        );
    }
}
