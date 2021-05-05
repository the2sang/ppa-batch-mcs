package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EtsTaxLineInfoTbRowMapper implements RowMapper<EtsTaxLineInfoTbVO> {

    @Override
    public EtsTaxLineInfoTbVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EtsTaxLineInfoTbVO(
            rs.getString("UUID"),
            rs.getString("LINE_NUM"),
            rs.getString("TRANS_DATE"),
            rs.getString("ID"),
            rs.getString("CLASS_ID"),
            rs.getString("NAME"),
            rs.getString("DEFINE_TXT"),
            rs.getString("LINE_DESC"),
            rs.getString("QUANTITY"),
            rs.getString("SUB_TOT_QUANTITY"),
            rs.getString("BASIS_AMT"),
            rs.getString("CURRENCY_CODE"),
            rs.getString("AMT"),
            rs.getString("SUB_TOT_AMT"),
            rs.getString("TAX_AMT"),
            rs.getString("TAX_SUB_TOT_AMT"),
            rs.getString("FORN_CHARGE_AMT"),
            rs.getString("FORN_CHARGE_SUB_TOT_AMT"),
            rs.getString("EXCHANGE_CURRENCY_RATE")
        );
    }
}
