package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class EtsTaxMainInfoTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        //int idx = 1;
        //int result = 0;

        StringBuffer sb = new StringBuffer();

        //20170525 수정 유종일
        //sb.append("\n MERGE INTO ETS_TAX_MAIN_INFO_TB");
        //sb.append("\n USING ( SELECT COUNT(*) CNT");
        //sb.append("\n           FROM ETS_TAX_MAIN_INFO_TB");
        //sb.append("\n          WHERE UUID = ?) T");
        //sb.append("\n    ON (T.CNT > 0)");

        sb.append("\n MERGE INTO EXEDI.ETS_TAX_MAIN_INFO_TB BAT");
        sb.append("\n USING ( SELECT  ? UUID FROM DUAL) T");
        sb.append("\n     ON (BAT.UUID = T.UUID)");

        sb.append("\n  WHEN MATCHED THEN");
        sb.append("\n        UPDATE SET");
        sb.append("\n               MANAGEMENT_ID = TRIM(?)");
        sb.append("\n             , DOC_DATE = TRIM(?)");
        sb.append("\n             , BLANK_NUM = TRIM(?)");
        sb.append("\n             , DOC_TYPE_CODE = TRIM(?)");
        sb.append("\n             , DEMAND_TYPE = TRIM(?)");
        sb.append("\n             , VOLUM_ID = TRIM(?)");
        sb.append("\n             , ISSUE_ID = TRIM(?)");
        sb.append("\n             , SEQ_ID = TRIM(?)");
        sb.append("\n             , REF_PUR_ORD_ID = TRIM(?)");
        sb.append("\n             , REF_PUR_ORD_DATE = TRIM(?)");
        sb.append("\n             , REF_INV_DOC_ID = TRIM(?)");
        sb.append("\n             , REF_INV_DOC_DATE = TRIM(?)");
        sb.append("\n             , REF_OTHER_DOC_ID = TRIM(?)");
        sb.append("\n             , DOC_DESC = TRIM(?)");
        sb.append("\n             , IMPORT_REG_ID = TRIM(?)");
        sb.append("\n             , BATCH_ISSUE_SDATE = TRIM(?)");
        sb.append("\n             , BATCH_ISSUE_EDATE = TRIM(?)");
        sb.append("\n             , TOT_IMPROT_CNT = TRIM(?)");
        sb.append("\n             , SUPPLIER_BIZ_ID = TRIM(?)");
        sb.append("\n             , SUPPLIER_ID = TRIM(?)");
        sb.append("\n             , SUPPLIER_NAME = TRIM(?)");
        sb.append("\n             , SUPPLIER_PRESIDENT_NAME = TRIM(?)");
        sb.append("\n             , SUPPLIER_ADDR = TRIM(?)");
        sb.append("\n             , SUPPLIER_BIZ_TYPE = TRIM(?)");
        sb.append("\n             , SUPPLIER_BIZ_CLASS = TRIM(?)");
        sb.append("\n             , SUPPLIER_CONTACTOR_DEPT = TRIM(?)");
        sb.append("\n             , SUPPLIER_CONTACTOR_NAME = TRIM(?)");
        sb.append("\n             , SUPPLIER_CONTACTOR_TEL = TRIM(?)");
        sb.append("\n             , SUPPLIER_CONTACTOR_EMAIL = TRIM(?)");
        sb.append("\n             , BUYER_BIZ_ID = TRIM(?)");
        sb.append("\n             , BUYER_ID = TRIM(?)");
        sb.append("\n             , BUYER_NAME = TRIM(?)");
        sb.append("\n             , BUYER_PRESIDENT_NAME = TRIM(?)");
        sb.append("\n             , BUYER_ADDR = TRIM(?)");
        sb.append("\n             , BUYER_BIZ_TYPE = TRIM(?)");
        sb.append("\n             , BUYER_BIZ_CLASS = TRIM(?)");
        sb.append("\n             , BUYER_CONTACTOR_DEPT = TRIM(?)");
        sb.append("\n             , BUYER_CONTACTOR_NAME = TRIM(?)");
        sb.append("\n             , BUYER_CONTACTOR_TEL = TRIM(?)");
        sb.append("\n             , BUYER_CONTACTOR_EMAIL = TRIM(?)");
        sb.append("\n             , CHARGE_AMT = TRIM(?)");
        sb.append("\n             , TOT_TAX_AMT = TRIM(?)");
        sb.append("\n             , TOT_FORE_AMT = TRIM(?)");
        sb.append("\n             , TOT_QUANTITY = TRIM(?)");
        sb.append("\n             , TOT_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CASH_DC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CASH_FC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CHECK_DC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CHECK_FC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_BILL_DC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_BILL_FC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CREDIT_DC_AMT = TRIM(?)");
        sb.append("\n             , PAYMENT_CREDIT_FC_AMT = TRIM(?)");
        sb.append("\n             , BUSINESS_TYPE_CODE = TRIM(?)");
        sb.append("\n             , NTS_ISSUE_ID = TRIM(?)");
        sb.append("\n             , BEF_NTS_ISSUE_ID = TRIM(?)");
        sb.append("\n             , MODIFY_CODE = TRIM(?)");
        sb.append("\n             , SUPPLIER_BIZ_CD = TRIM(?)");
        sb.append("\n             , BUYER_BIZ_CD = TRIM(?)");
        sb.append("\n             , DOC_TYPE_DETAIL = TRIM(?)");
        sb.append("\n             , ASP_ISSUE_ID = TRIM(?)");
        sb.append("\n             , PURPOSE_CODE = TRIM(?)");
        sb.append("\n             , TAX_TYPE_CODE = TRIM(?)");
        //20170525 수정 유종일
        //sb.append("\n         WHERE UUID = ?");
        sb.append("\n  WHEN NOT MATCHED THEN");
        sb.append("\n        INSERT(UUID, MANAGEMENT_ID, DOC_DATE, BLANK_NUM, DOC_TYPE_CODE");
        sb.append("\n             , DEMAND_TYPE, VOLUM_ID, ISSUE_ID, SEQ_ID, REF_PUR_ORD_ID");
        sb.append("\n             , REF_PUR_ORD_DATE, REF_INV_DOC_ID, REF_INV_DOC_DATE, REF_OTHER_DOC_ID, DOC_DESC");
        sb.append("\n             , IMPORT_REG_ID, BATCH_ISSUE_SDATE, BATCH_ISSUE_EDATE, TOT_IMPROT_CNT, SUPPLIER_BIZ_ID");
        sb.append("\n             , SUPPLIER_ID, SUPPLIER_NAME, SUPPLIER_PRESIDENT_NAME, SUPPLIER_ADDR, SUPPLIER_BIZ_TYPE");
        sb.append(
            "\n             , SUPPLIER_BIZ_CLASS, SUPPLIER_CONTACTOR_DEPT, SUPPLIER_CONTACTOR_NAME, SUPPLIER_CONTACTOR_TEL, SUPPLIER_CONTACTOR_EMAIL"
        );
        sb.append("\n             , BUYER_BIZ_ID, BUYER_ID, BUYER_NAME, BUYER_PRESIDENT_NAME, BUYER_ADDR");
        sb.append("\n             , BUYER_BIZ_TYPE, BUYER_BIZ_CLASS, BUYER_CONTACTOR_DEPT, BUYER_CONTACTOR_NAME, BUYER_CONTACTOR_TEL");
        sb.append("\n             , BUYER_CONTACTOR_EMAIL, CHARGE_AMT, TOT_TAX_AMT, TOT_FORE_AMT, TOT_QUANTITY");
        sb.append("\n             , TOT_AMT, PAYMENT_CASH_DC_AMT, PAYMENT_CASH_FC_AMT, PAYMENT_CHECK_DC_AMT, PAYMENT_CHECK_FC_AMT");
        sb.append(
            "\n             , PAYMENT_BILL_DC_AMT, PAYMENT_BILL_FC_AMT, PAYMENT_CREDIT_DC_AMT, PAYMENT_CREDIT_FC_AMT, BUSINESS_TYPE_CODE"
        );
        sb.append("\n             , NTS_ISSUE_ID, BEF_NTS_ISSUE_ID, MODIFY_CODE, SUPPLIER_BIZ_CD, BUYER_BIZ_CD");
        sb.append("\n             , DOC_TYPE_DETAIL, ASP_ISSUE_ID, PURPOSE_CODE, TAX_TYPE_CODE)");
        sb.append("\n       VALUES(TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?))");

        return sb.toString();
    }
}
