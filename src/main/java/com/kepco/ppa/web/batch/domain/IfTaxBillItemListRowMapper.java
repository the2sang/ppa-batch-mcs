package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class IfTaxBillItemListRowMapper implements RowMapper<IfTaxBillItemListVO> {

    @Override
    public IfTaxBillItemListVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new IfTaxBillItemListVO(
            resultSet.getString("REL_SYSTEM_ID"),
            resultSet.getString("JOB_GUB_CODE"),
            resultSet.getString("MANAGE_ID"),
            resultSet.getInt("SEQ_NO"),
            resultSet.getString("PURCHASE_DAY"),
            resultSet.getString("ITEM_NAME"),
            resultSet.getString("ITEM_INFO"),
            resultSet.getString("ITEM_DESC"),
            resultSet.getLong("UNIT_QUANTITY"),
            resultSet.getLong("UNIT_AMOUNT"),
            resultSet.getLong("INVOICE_AMOUNT"),
            resultSet.getLong("TAX_AMOUNT"),
            resultSet.getString("BILL_ISSUE_YYYYMM")
        );
    }
}
