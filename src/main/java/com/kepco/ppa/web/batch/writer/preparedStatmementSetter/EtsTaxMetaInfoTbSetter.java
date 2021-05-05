package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.common.Env;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class EtsTaxMetaInfoTbSetter implements ItemPreparedStatementSetter<TbTaxBillInfoEncVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TbTaxBillInfoEncVO vo, PreparedStatement pstmt) throws SQLException {
        int idx = 1;

        pstmt.setString(idx++, vo.getUuid());

        for (int i = 1; i <= 2; i++) {
            if (i == 2) {
                pstmt.setString(idx++, vo.getUuid());
            }
            pstmt.setString(idx++, Env.KEPCO_BIZ_NO);
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "CFT");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, vo.getInvoicerPartyId());
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "N");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "ET1"); //일반 순발행/역발행
            pstmt.setString(idx++, "121");
            pstmt.setString(idx++, "213");
            pstmt.setString(idx++, "Y");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "29991231");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "K");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "1");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "1");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "00");
            pstmt.setString(idx++, vo.getRelSystemId());
            pstmt.setString(idx++, vo.getJobGubCode());
            pstmt.setString(idx++, vo.getVatGubCode());
            pstmt.setString(idx++, vo.getReceiptGubCode());
            pstmt.setString(idx++, vo.getInvoiceeBusinessTypeCode());
            pstmt.setString(idx++, vo.getSvcManageId());
            //20170525  수정 유종일
            //if (i==1) {
            //	pstmt.setString(idx++, mgrVo.getMeta().getUuid());
            //}
        }
    }
}
