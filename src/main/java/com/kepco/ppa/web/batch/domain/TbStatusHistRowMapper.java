package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TbStatusHistRowMapper implements RowMapper<TbStatusHistVO> {

    @Override
    public TbStatusHistVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new TbStatusHistVO(
            resultSet.getString("IO_CODE"),
            resultSet.getString("ISSUE_DAY"),
            resultSet.getString("BIZ_MANAGE_ID"),
            resultSet.getInt("SEQ_NO"),
            resultSet.getString("AVL_END_DT"),
            resultSet.getString("AVL_BEGIN_DT"),
            resultSet.getString("STATUS_CODE"),
            resultSet.getDate("REGIST_DT"),
            resultSet.getString("REGIST_ID"),
            resultSet.getString("STATUS_DESC")
        );
    }
}
