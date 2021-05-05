package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class EtsTaxMetaInfoTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        //20170525 수정 유종일
        //sb.append("\n MERGE INTO ETS_TAX_META_INFO_TB");
        //sb.append("\n USING ( SELECT COUNT(*) CNT");
        //sb.append("\n           FROM ETS_TAX_META_INFO_TB");
        //sb.append("\n          WHERE UUID = ?) T");
        //sb.append("\n    ON (T.CNT > 0)");

        sb.append("\n MERGE INTO EXEDI.ETS_TAX_META_INFO_TB BAT ");
        sb.append("\n USING ( SELECT ? UUID FROM DUAL) T");
        sb.append("\n    ON (BAT.UUID = T.UUID) ");

        sb.append("\n  WHEN MATCHED THEN");
        sb.append("\n        UPDATE SET");
        sb.append("\n               COMPLETE_TIME = SYSDATE");
        sb.append("\n             , SERVICE_ID = TRIM(?)");
        sb.append("\n             , SIGNATURE = TRIM(?)");
        sb.append("\n             , USER_DN = TRIM(?)");
        sb.append("\n             , SIGNCERT = TRIM(?)");
        sb.append("\n             , DOC_STATE = TRIM(?)");
        sb.append("\n             , SENDER_ID = TRIM(?)");
        sb.append("\n             , RECEIVER_ID = TRIM(?)");
        sb.append("\n             , SENDER_COMP_ID = TRIM(?)");
        sb.append("\n             , RECEIVER_COMP_ID = TRIM(?)");
        sb.append("\n             , EXT_DOC_INS_DATE = TRIM(?)");
        sb.append("\n             , EXT_DOC_RESULT_STATUS = TRIM(?)");
        sb.append("\n             , EXT_DOC_RESULT_MSG = TRIM(?)");
        sb.append("\n             , EXT_SYSTEM_TYPE = TRIM(?)");
        sb.append("\n             , EXT_VOUCHER_TYPE = TRIM(?)");
        sb.append("\n             , EXT_PURCHASE_TYPE = TRIM(?)");
        sb.append("\n             , EXT_DECUCTION_STATUS = TRIM(?)");
        sb.append("\n             , EXT_DECUCTION_DETAIL = TRIM(?)");
        sb.append("\n             , EXT_BUYER_SABUN = TRIM(?)");
        sb.append("\n             , EXT_VALID_SDATE = TRIM(?)");
        sb.append("\n             , EXT_VALID_EDATE = TRIM(?)");
        sb.append("\n             , WRITER_ID = TRIM(?)");
        sb.append("\n             , CONFIRM_SIGNCERT = TRIM(?)");
        sb.append("\n             , WRITE_TYPE = TRIM(?)");
        sb.append("\n             , VOUCHER_BUSEO = TRIM(?)");
        sb.append("\n             , VOUCHER_YEARMONTH = TRIM(?)");
        sb.append("\n             , VOUCHER_SEQ = TRIM(?)");
        sb.append("\n             , STATUS_CODE = TRIM(?)");
        sb.append("\n             , UPDATE_TRRIGER_STATE = TRIM(?)");
        sb.append("\n             , CONTRACTOR_ID = TRIM(?)");
        sb.append("\n             , CONTRACT_NO = TRIM(?)");
        sb.append("\n             , CONSTRUCT_NO = TRIM(?)");
        sb.append("\n             , KISUNG_CHG_NO = TRIM(?)");
        sb.append("\n             , REPORT_TYPE = TRIM(?)");
        sb.append("\n             , INSPECTOR_ID = TRIM(?)");
        sb.append("\n             , DOC_PROCESS_STATUS = TRIM(?)");
        sb.append("\n             , EXT_DOC_REISSUE_MSG = TRIM(?)");
        sb.append("\n             , COMP_CODE = TRIM(?)");
        sb.append("\n             , REL_SYSTEM_ID = TRIM(?)");
        sb.append("\n             , JOB_GUB_CODE = TRIM(?)");
        sb.append("\n             , VAT_GUB_CODE = TRIM(?)");
        sb.append("\n             , RECEIPT_GUB_CODE = TRIM(?)");
        sb.append("\n             , INVOICEE_BUSINESS_TYPE_CODE = TRIM(?)");
        sb.append("\n             , SVC_MANAGE_ID = TRIM(?)");
        //20170525 수정 유종일
        //sb.append("\n         WHERE UUID = ?");
        sb.append("\n  WHEN NOT MATCHED THEN");
        sb.append("\n        INSERT(UUID, CREATE_TIME, COMPLETE_TIME, SERVICE_ID, SIGNATURE");
        sb.append("\n             , USER_DN, SIGNCERT, DOC_STATE, SENDER_ID, RECEIVER_ID");
        sb.append("\n             , SENDER_COMP_ID, RECEIVER_COMP_ID, EXT_DOC_INS_DATE, EXT_DOC_RESULT_STATUS, EXT_DOC_RESULT_MSG");
        sb.append("\n             , EXT_SYSTEM_TYPE, EXT_VOUCHER_TYPE, EXT_PURCHASE_TYPE, EXT_DECUCTION_STATUS, EXT_DECUCTION_DETAIL");
        sb.append("\n             , EXT_BUYER_SABUN, EXT_VALID_SDATE, EXT_VALID_EDATE, WRITER_ID, CONFIRM_SIGNCERT");
        sb.append("\n             , WRITE_TYPE, VOUCHER_BUSEO, VOUCHER_YEARMONTH, VOUCHER_SEQ, STATUS_CODE");
        sb.append("\n             , UPDATE_TRRIGER_STATE, CONTRACTOR_ID, CONTRACT_NO, CONSTRUCT_NO, KISUNG_CHG_NO");
        sb.append("\n             , REPORT_TYPE, INSPECTOR_ID, DOC_PROCESS_STATUS, EXT_DOC_REISSUE_MSG, COMP_CODE");
        sb.append("\n             , REL_SYSTEM_ID, JOB_GUB_CODE, VAT_GUB_CODE, RECEIPT_GUB_CODE, INVOICEE_BUSINESS_TYPE_CODE");
        sb.append("\n             , SVC_MANAGE_ID)");
        sb.append("\n        VALUES(TRIM(?), SYSDATE, SYSDATE, TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?))");

        return sb.toString();
    }
}
