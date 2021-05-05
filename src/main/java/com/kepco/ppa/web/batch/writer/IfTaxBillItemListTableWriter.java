package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class IfTaxBillItemListTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n INSERT INTO KEY_POWEREDI.IF_TAX_BILL_ITEM_LIST");
        sb.append("\n (");
        sb.append("\n        REL_SYSTEM_ID, JOB_GUB_CODE, MANAGE_ID, SEQ_NO, PURCHASE_DAY");
        sb.append("\n      , ITEM_NAME, ITEM_INFO, ITEM_DESC, UNIT_QUANTITY, UNIT_AMOUNT");
        sb.append("\n      , INVOICE_AMOUNT, TAX_AMOUNT, BILL_ISSUE_YYYYMM");
        sb.append("\n  )");
        sb.append("\n SELECT T2.REL_SYSTEM_ID");
        sb.append("\n      , T2.JOB_GUB_CODE");
        sb.append("\n      , T2.SVC_MANAGE_ID");
        sb.append("\n      , T1.SEQ_NO");
        sb.append("\n      , T1.PURCHASE_DAY");
        sb.append("\n      , T1.ITEM_NAME");
        sb.append("\n      , T1.ITEM_INFO");
        sb.append("\n      , T1.ITEM_DESC");
        sb.append("\n      , T1.UNIT_QUANTITY");
        sb.append("\n      , T1.UNIT_AMOUNT");
        sb.append("\n      , T1.INVOICE_AMOUNT");
        sb.append("\n      , NVL(T1.TAX_AMOUNT, 0)");
        sb.append("\n      , '' BILL_ISSUE_YYYYMM");
        sb.append("\n   FROM EXEDI.TB_TRADE_ITEM_LIST T1");
        sb.append("\n  INNER JOIN EXEDI.TB_TAX_BILL_INFO T2");
        sb.append("\n     ON T1.IO_CODE = T2.IO_CODE");
        sb.append("\n    AND T1.ISSUE_DAY = T2.ISSUE_DAY");
        sb.append("\n    AND T1.BIZ_MANAGE_ID = T2.BIZ_MANAGE_ID");
        sb.append("\n  WHERE T1.IO_CODE = ?");
        sb.append("\n    AND T1.ISSUE_DAY = ?");
        sb.append("\n    AND T1.BIZ_MANAGE_ID = ?");
        sb.append("\n    AND T1.SEQ_NO = ?");

        return sb.toString();
    }
}
