package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class IfTaxBillInfoSetter implements ItemPreparedStatementSetter<TbTaxBillInfoEncVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TbTaxBillInfoEncVO vo, PreparedStatement pstmt) throws SQLException {
        int idx = 1;

        pstmt.setString(idx++, vo.getIssueDay());
        pstmt.setString(idx++, vo.getBillTypeCode());
        pstmt.setString(
            idx++,
            vo.getEseroIssueId().substring(0, 8) + vo.getEseroIssueId().substring(8, 16) + vo.getEseroIssueId().substring(16, 24)
        );
        pstmt.setString(idx++, vo.getIoCode());
        pstmt.setString(idx++, vo.getIssueDay());
        pstmt.setString(idx++, vo.getBizManageId());
    }
}
