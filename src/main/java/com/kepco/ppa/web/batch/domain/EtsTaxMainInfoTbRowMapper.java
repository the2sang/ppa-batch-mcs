package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EtsTaxMainInfoTbRowMapper implements RowMapper<EtsTaxMainInfoTbVO> {

    @Override
    public EtsTaxMainInfoTbVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new EtsTaxMainInfoTbVO(
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString(""),
            resultSet.getString("")
        );
    }
}
