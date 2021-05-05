package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@NoArgsConstructor
public class TbTradeItemListTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        //수정 20170525  유종일
        //sb.append("\n MERGE INTO TB_TRADE_ITEM_LIST");
        //sb.append("\n USING ( SELECT COUNT(*) CNT");
        //sb.append("\n           FROM TB_TRADE_ITEM_LIST");
        //sb.append("\n          WHERE IO_CODE = ?");
        //sb.append("\n            AND ISSUE_DAY = ?");
        //sb.append("\n            AND BIZ_MANAGE_ID = ?");
        //sb.append("\n            AND SEQ_NO = ?) T");
        //sb.append("\n    ON (T.CNT > 0)");
        sb.append("\n MERGE INTO EXEDI.TB_TRADE_ITEM_LIST DAT");
        sb.append("\n USING ( SELECT ? IO_CODE");
        sb.append("\n              , ? ISSUE_DAY");
        sb.append("\n              , ? BIZ_MANAGE_ID");
        sb.append("\n              , ? SEQ_NO FROM DUAL ) T ");
        sb.append("\n    ON (DAT.IO_CODE = T.IO_CODE ");
        sb.append("\n    AND DAT.ISSUE_DAY = T.ISSUE_DAY");
        sb.append("\n    AND DAT.BIZ_MANAGE_ID = T.BIZ_MANAGE_ID");
        sb.append("\n    AND DAT.SEQ_NO = T.SEQ_NO) ");
        sb.append("\n  WHEN MATCHED THEN");
        sb.append("\n       UPDATE SET");
        sb.append("\n              PURCHASE_DAY = TRIM(?)");
        sb.append("\n            , ITEM_NAME = TRIM(?)");
        sb.append("\n            , ITEM_INFO = TRIM(?)");
        sb.append("\n            , ITEM_DESC = TRIM(?)");
        sb.append("\n            , UNIT_QUANTITY = TRIM(?)");
        sb.append("\n            , UNIT_AMOUNT = TRIM(?)");
        sb.append("\n            , INVOICE_AMOUNT = TRIM(?)");
        sb.append("\n            , TAX_AMOUNT = TRIM(?)");
        //sb.append("\n        WHERE IO_CODE = ?");
        //sb.append("\n          AND ISSUE_DAY = ?");
        //sb.append("\n          AND BIZ_MANAGE_ID = ?");
        //sb.append("\n          AND SEQ_NO = ? ");
        sb.append("\n  WHEN NOT MATCHED THEN");
        sb.append("\n       INSERT(IO_CODE, ISSUE_DAY, BIZ_MANAGE_ID, SEQ_NO, PURCHASE_DAY");
        sb.append("\n            , ITEM_NAME, ITEM_INFO, ITEM_DESC, UNIT_QUANTITY, UNIT_AMOUNT");
        sb.append("\n            , INVOICE_AMOUNT, TAX_AMOUNT)");
        sb.append("\n       VALUES(TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n            , TRIM(?), TRIM(?))");

        return sb.toString();
    }
}
