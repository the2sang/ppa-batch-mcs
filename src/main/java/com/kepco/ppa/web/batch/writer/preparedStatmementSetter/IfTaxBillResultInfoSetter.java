package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
@Slf4j
public class IfTaxBillResultInfoSetter implements ItemPreparedStatementSetter<TbTaxBillInfoEncVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TbTaxBillInfoEncVO vo, PreparedStatement pstmt) throws SQLException {
        int idx = 1;
        int seqno = Integer.parseInt(getSeqNo(vo));

        if (seqno == 0) {
            pstmt.setString(idx++, vo.getIoCode());
            pstmt.setString(idx++, vo.getIssueDay());
            pstmt.setString(idx++, vo.getBizManageId());
        } else {
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
        }
    }

    private String getSeqNo(TbTaxBillInfoEncVO vo) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        StringBuffer sb = new StringBuffer();
        sb.append("\n SELECT NVL(MAX(SEQ_NO), 0) SEQ_NO");
        sb.append("\n   FROM TB_STATUS_HIST            ");
        sb.append("\n  WHERE IO_CODE = '" + vo.getIoCode() + "'");
        sb.append("\n    AND ISSUE_DAY = '" + vo.getIssueDay() + "'");
        sb.append("\n    AND BIZ_MANAGE_ID = '" + vo.getBizManageId() + "'");

        return jdbcTemplate.queryForObject(sb.toString(), String.class);
    }
}
