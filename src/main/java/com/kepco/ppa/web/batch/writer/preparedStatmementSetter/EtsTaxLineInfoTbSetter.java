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
public class EtsTaxLineInfoTbSetter implements ItemPreparedStatementSetter<TaxEmailItemListVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TaxEmailItemListVO vo, PreparedStatement pstmt) throws SQLException {
        TbTaxBillInfoEncService service = new TbTaxBillInfoEncService(dataSource);
        ArrayList<TbTaxBillInfoEncVO> enclist = service.getSelectENC(vo.getIssueId());

        //String purchaseDay = CommonUtility.TrimNull(vo.getPurchaseDay()); // 물품 공급일자 받아온대로 저장 (null도 저장)

        for (TbTaxBillInfoEncVO encvo : enclist) {
            //if(!"".equals(purchaseDay)) { //20140312 compile된 소스 비교 후 운영서버와 동일하게 변경.

            int idx = 1;
            pstmt.setString(idx++, encvo.getUuid());
            pstmt.setInt(idx++, vo.getSeqNo());
            //UPDATE
            pstmt.setString(idx++, vo.getPurchaseDay());
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, vo.getItemName());
            pstmt.setString(idx++, vo.getItemInfo());
            pstmt.setString(idx++, vo.getItemDesc());
            pstmt.setLong(idx++, vo.getUnitQuantity());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getUnitAmount());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getInvoiceAmount());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getTaxAmount());
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            //20170525 수정 유종일
            //pstmt.setString(idx++, lineVo.getUuid());
            //INSERT
            pstmt.setString(idx++, encvo.getUuid());
            pstmt.setInt(idx++, vo.getSeqNo());
            pstmt.setString(idx++, vo.getPurchaseDay());
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, vo.getItemName());
            pstmt.setString(idx++, vo.getItemInfo());
            pstmt.setString(idx++, vo.getItemDesc());
            pstmt.setLong(idx++, vo.getUnitQuantity());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getUnitAmount());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getInvoiceAmount());
            pstmt.setString(idx++, "");
            pstmt.setLong(idx++, vo.getTaxAmount());
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            //  }
        }
    }
}
