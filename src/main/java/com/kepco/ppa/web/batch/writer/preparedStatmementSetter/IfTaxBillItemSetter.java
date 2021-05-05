package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TaxEmailItemListVO;
import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.batch.service.TbTaxBillInfoEncService;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@AllArgsConstructor
public class IfTaxBillItemSetter implements ItemPreparedStatementSetter<TaxEmailItemListVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TaxEmailItemListVO vo, PreparedStatement pstmt) throws SQLException {
        TbTaxBillInfoEncService service = new TbTaxBillInfoEncService(this.dataSource);
        ArrayList<TbTaxBillInfoEncVO> enclist = service.getSelectENC(vo.getIssueId());

        for (TbTaxBillInfoEncVO encvo : enclist) {
            int idx = 1;

            pstmt.setString(idx++, encvo.getIoCode());
            pstmt.setString(idx++, vo.getIssueDay());
            pstmt.setString(idx++, encvo.getBizManageId());
            pstmt.setInt(idx++, vo.getSeqNo());
        }
    }
}
