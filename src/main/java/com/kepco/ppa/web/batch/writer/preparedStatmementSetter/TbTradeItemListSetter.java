package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TaxEmailItemListVO;
import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.batch.service.TbTaxBillInfoEncService;
import com.kepco.ppa.web.common.CommonUtility;
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
public class TbTradeItemListSetter implements ItemPreparedStatementSetter<TaxEmailItemListVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TaxEmailItemListVO vo, PreparedStatement pstmt) throws SQLException {
        TbTaxBillInfoEncService service = new TbTaxBillInfoEncService(dataSource);
        ArrayList<TbTaxBillInfoEncVO> enclist = service.getSelectENC(vo.getIssueId());

        String invoiceAmount = CommonUtility.TrimNull(Long.toString(vo.getInvoiceAmount()));

        log.info("TEST-PPA ITEM :" + vo.toString());

        for (TbTaxBillInfoEncVO encvo : enclist) {
            // 2012.03.30 공급일자는 체크하지 않고, 공급가액이 있는지만 체크
            if (!"".equals(invoiceAmount)) {
                int idx = 1;

                pstmt.setString(idx++, encvo.getIoCode());
                pstmt.setString(idx++, vo.getIssueDay());
                pstmt.setString(idx++, encvo.getBizManageId());
                pstmt.setInt(idx++, vo.getSeqNo());
                //update
                pstmt.setString(idx++, vo.getPurchaseDay());
                pstmt.setString(idx++, vo.getItemName());
                pstmt.setString(idx++, vo.getItemInfo());
                pstmt.setString(idx++, vo.getItemDesc());
                pstmt.setLong(idx++, vo.getUnitQuantity());
                pstmt.setLong(idx++, vo.getUnitAmount());
                pstmt.setLong(idx++, Long.parseLong(invoiceAmount));
                pstmt.setLong(idx++, vo.getTaxAmount());
                //20170525 수정 유종일
                //pstmt.setString(idx++, itemVo.getIoCode());
                //pstmt.setString(idx++, itemVo.getIssueDay());
                //pstmt.setString(idx++, itemVo.getBizManageId());
                //pstmt.setString(idx++, itemVo.getSeqNo());
                //insert
                pstmt.setString(idx++, encvo.getIoCode());
                pstmt.setString(idx++, vo.getIssueDay());
                pstmt.setString(idx++, encvo.getBizManageId());
                pstmt.setInt(idx++, vo.getSeqNo());
                pstmt.setString(idx++, vo.getPurchaseDay());
                pstmt.setString(idx++, vo.getItemName());
                pstmt.setString(idx++, vo.getItemInfo());
                pstmt.setString(idx++, vo.getItemDesc());
                pstmt.setLong(idx++, vo.getUnitQuantity());
                pstmt.setLong(idx++, vo.getUnitAmount());
                pstmt.setLong(idx++, Long.parseLong(invoiceAmount));
                pstmt.setLong(idx++, vo.getTaxAmount());
            }
        }
    }
}
