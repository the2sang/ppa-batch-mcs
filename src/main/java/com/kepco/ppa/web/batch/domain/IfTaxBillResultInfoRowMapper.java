package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class IfTaxBillResultInfoRowMapper implements RowMapper<IfTaxBillResultInfoVO> {

    @Override
    public IfTaxBillResultInfoVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new IfTaxBillResultInfoVO(
            resultSet.getString("REL_SYSTEM_ID"),
            resultSet.getString("JOB_GUB_CODE"),
            resultSet.getString("MANAGE_ID"),
            resultSet.getString("STATUS_CODE"),
            resultSet.getString("STATUS_DESC"),
            resultSet.getDate("REGIST_DT"),
            resultSet.getDate("MODIFY_DT"),
            resultSet.getString("ISSUE_ID"),
            resultSet.getString("EAI_STAT"),
            resultSet.getString("EAI_CDATE"),
            resultSet.getString("EAI_UDATE"),
            resultSet.getString("TAX_CANCEL_DATA"),
            resultSet.getString("ESERO_CREATE_TS"),
            resultSet.getString("ESERO_FINISH_TS")
        );
    }
}
