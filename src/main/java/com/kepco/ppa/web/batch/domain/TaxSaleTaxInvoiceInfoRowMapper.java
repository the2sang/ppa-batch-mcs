package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TaxSaleTaxInvoiceInfoRowMapper implements RowMapper<TbTaxBillInfoEncVO> {

    @Override
    public TbTaxBillInfoEncVO mapRow(ResultSet resultSet, int i) throws SQLException {
        return new TbTaxBillInfoEncVO(
            //                resultSet.getLong("IO_CODE"),
            //                resultSet.getString("ISSUE_DAY")
        );
    }
}
