package com.kepco.ppa.web.batch.writer.preparedStatmementSetter;

import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.common.CommonUtility;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class EtsTaxMainInfoTbSetter implements ItemPreparedStatementSetter<TbTaxBillInfoEncVO> {

    @Autowired
    @Setter
    private DataSource dataSource;

    @Override
    public void setValues(TbTaxBillInfoEncVO vo, PreparedStatement pstmt) throws SQLException {
        int idx = 1;

        String blankNum = "".equals(vo.getChargeTotalAmount())
            ? ""
            : Integer.toString(13 - Long.toString(vo.getChargeTotalAmount()).length());
        String setTotAmt = CommonUtility.TrimNull(Long.toString(vo.getGrandTotalAmount()).replaceAll(",", ""));
        String billTypeCode = CommonUtility.TrimNull(vo.getBillTypeCode());
        String aspIssueId =
            vo.getEseroIssueId().substring(0, 8) + vo.getEseroIssueId().substring(8, 16) + vo.getEseroIssueId().substring(16, 24);

        String setDocTypeCode = "";
        String businessTypeCode = "";
        String setModifyCode = "";

        if (Long.parseLong("".equals(setTotAmt) ? "0" : setTotAmt) < 0) { //총금액이 < 0 ? 2(마이너스) : 1(일반)
            businessTypeCode = "2";
        } else {
            businessTypeCode = "1";
        }

        if ("02,04".indexOf(billTypeCode.substring(0, 2)) > -1) {
            setModifyCode = CommonUtility.TrimNull(vo.getAmendmentCode());
        } else {
            setModifyCode = "";
        }

        if ("03,04".indexOf(billTypeCode.substring(0, 2)) > -1) { //01(세금계산서), 02(계산서)
            setDocTypeCode = "02";
        } else {
            setDocTypeCode = "01";
        }

        pstmt.setString(idx++, vo.getUuid());

        for (int i = 1; i <= 2; i++) {
            if (i == 2) {
                pstmt.setString(idx++, vo.getUuid());
            }
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getIssueDay()));
            pstmt.setString(idx++, blankNum);
            pstmt.setString(idx++, setDocTypeCode);
            pstmt.setString(idx++, "18");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getDescription()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerPartyId()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerPartyName()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerCeoName()));
            pstmt.setString(idx++, CommonUtility.cutStringByte(vo.getInvoicerAddr(), 148));
            pstmt.setString(idx++, CommonUtility.cutStringByte(vo.getInvoicerType(), 38));
            pstmt.setString(idx++, CommonUtility.cutStringByte(vo.getInvoicerClass(), 38));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerContactName()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerContactPhone()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceePartyId()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceePartyName()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeCeoName()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeAddr()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeType()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeClass()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeContactName1()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeContactPhone1()));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getChargeTotalAmount()).replaceAll(",", "")));
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getTaxTotalAmount()).replaceAll(",", "")));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, setTotAmt);
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getPayAmount1()).replaceAll(",", "")));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getPayAmount2()).replaceAll(",", "")));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getPayAmount3()).replaceAll(",", "")));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, CommonUtility.TrimNull(Long.toString(vo.getPayAmount4()).replaceAll(",", "")));
            pstmt.setString(idx++, "");
            pstmt.setString(idx++, businessTypeCode);
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getIssueId()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getUpperManageId()));
            pstmt.setString(idx++, setModifyCode);
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoicerTaxRegistId()));
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getInvoiceeTaxRegistId()));
            pstmt.setString(idx++, billTypeCode);
            pstmt.setString(idx++, aspIssueId);
            pstmt.setString(idx++, CommonUtility.TrimNull(vo.getPurposeCode()));
            pstmt.setString(idx++, "12");
            //20170525 수정 유종일
            //if (i==1) {
            //	pstmt.setString(idx++, vo.getUuid());
            //}
        }
    }
}
