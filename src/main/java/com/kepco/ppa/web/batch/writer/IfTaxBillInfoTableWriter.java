package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class IfTaxBillInfoTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n INSERT INTO KEY_POWEREDI.IF_TAX_BILL_INFO");
        sb.append("\n (");
        sb.append("\n        REL_SYSTEM_ID, JOB_GUB_CODE, MANAGE_ID, ADD_TAX_YN, ISSUE_ID");
        sb.append("\n      , ISSUE_DAY, BILL_TYPE_CODE, PURPOSE_CODE, AMENDMENT_CODE, UPPER_MANAGE_ID");
        sb.append("\n      , DESCRIPTION, INVOICER_PARTY_ID, INVOICER_TAX_REGIST_ID, INVOICER_PARTY_NAME, INVOICER_CEO_NAME");
        sb.append("\n      , INVOICER_ADDR, INVOICER_TYPE, INVOICER_CLASS, INVOICER_CONTACT_DEPART, INVOICER_CONTACT_NAME");
        sb.append(
            "\n      , INVOICER_CONTACT_PHONE, INVOICER_CONTACT_EMAIL, INVOICEE_BUSINESS_TYPE_CODE, INVOICEE_PARTY_ID, INVOICEE_TAX_REGIST_ID"
        );
        sb.append("\n      , INVOICEE_PARTY_NAME, INVOICEE_CEO_NAME, INVOICEE_ADDR, INVOICEE_TYPE, INVOICEE_CLASS");
        sb.append(
            "\n      , INVOICEE_CONTACT_DEPART1, INVOICEE_CONTACT_NAME1, INVOICEE_CONTACT_PHONE1, INVOICEE_CONTACT_EMAIL1, INVOICEE_CONTACT_DEPART2"
        );
        sb.append("\n      , INVOICEE_CONTACT_NAME2, INVOICEE_CONTACT_PHONE2, INVOICEE_CONTACT_EMAIL2, PAYMENT_TYPE_CODE1, PAY_AMOUNT1");
        sb.append("\n      , PAYMENT_TYPE_CODE2, PAY_AMOUNT2, PAYMENT_TYPE_CODE3, PAY_AMOUNT3, PAYMENT_TYPE_CODE4");
        sb.append("\n      , PAY_AMOUNT4, CHARGE_TOTAL_AMOUNT, TAX_TOTAL_AMOUNT, GRAND_TOTAL_AMOUNT, CUST_NO");
        sb.append("\n      , BILL_YYYYMM, BILL_ISSUE_YYYYMM, PAY_DEADLINE, ONLINE_GUB_CODE, FLG");
        sb.append("\n      , REGIST_DT, MODIFY_DT, CANCEL_DT, EAI_STAT, EAI_CDATE");
        sb.append("\n      , EAI_UDATE, ERP_EVIDENCE_CODE, VAT_GUB_CODE, RECEIPT_GUB_CODE, REGIST_ID");
        sb.append("\n      , BELNR, ASP_ISSUE_ID, TAX_TYPE_CODE , ATTACH_FILE ");
        sb.append("\n )");
        sb.append("\n SELECT REL_SYSTEM_ID");
        sb.append("\n      , JOB_GUB_CODE");
        sb.append("\n      , SVC_MANAGE_ID");
        sb.append("\n      , ADD_TAX_YN");
        sb.append("\n      , ISSUE_ID");
        sb.append("\n      , ?   ");
        sb.append("\n      , BILL_TYPE_CODE");
        sb.append("\n      , PURPOSE_CODE");
        sb.append("\n      , AMENDMENT_CODE");
        sb.append("\n      , UPPER_MANAGE_ID");
        sb.append("\n      , DESCRIPTION");
        sb.append("\n      , INVOICER_PARTY_ID");
        sb.append("\n      , INVOICER_TAX_REGIST_ID");
        sb.append("\n      , INVOICER_PARTY_NAME");
        sb.append("\n      , INVOICER_CEO_NAME");
        sb.append("\n      , INVOICER_ADDR");
        sb.append("\n      , INVOICER_TYPE");
        sb.append("\n      , INVOICER_CLASS");
        sb.append("\n      , INVOICER_CONTACT_DEPART");
        sb.append("\n      , INVOICER_CONTACT_NAME");
        sb.append("\n      , INVOICER_CONTACT_PHONE");
        sb.append("\n      , INVOICER_CONTACT_EMAIL");
        sb.append("\n      , INVOICEE_BUSINESS_TYPE_CODE");
        sb.append("\n      , INVOICEE_PARTY_ID");
        sb.append("\n      , INVOICEE_TAX_REGIST_ID");
        sb.append("\n      , INVOICEE_PARTY_NAME");
        sb.append("\n      , INVOICEE_CEO_NAME");
        sb.append("\n      , INVOICEE_ADDR");
        sb.append("\n      , INVOICEE_TYPE");
        sb.append("\n      , INVOICEE_CLASS");
        sb.append("\n      , INVOICEE_CONTACT_DEPART1");
        sb.append("\n      , INVOICEE_CONTACT_NAME1");
        sb.append("\n      , INVOICEE_CONTACT_PHONE1");
        sb.append("\n      , INVOICEE_CONTACT_EMAIL1");
        sb.append("\n      , INVOICEE_CONTACT_DEPART2");
        sb.append("\n      , INVOICEE_CONTACT_NAME2");
        sb.append("\n      , INVOICEE_CONTACT_PHONE2");
        sb.append("\n      , INVOICEE_CONTACT_EMAIL2");
        sb.append("\n      , '10'");
        sb.append("\n      , NVL(PAY_AMOUNT1, GRAND_TOTAL_AMOUNT) ");
        sb.append("\n      , PAYMENT_TYPE_CODE2");
        sb.append("\n      , PAY_AMOUNT2");
        sb.append("\n      , PAYMENT_TYPE_CODE3");
        sb.append("\n      , PAY_AMOUNT3");
        sb.append("\n      , PAYMENT_TYPE_CODE4");
        sb.append("\n      , PAY_AMOUNT4");
        sb.append("\n      , CHARGE_TOTAL_AMOUNT");
        sb.append("\n      , TAX_TOTAL_AMOUNT");
        sb.append("\n      , GRAND_TOTAL_AMOUNT");
        sb.append("\n      , '' CUST_NO");
        sb.append("\n      , '' BILL_YYYYMM");
        sb.append("\n      , '' BILL_ISSUE_YYYYMM");
        sb.append("\n      , '' PAY_DEADLINE");
        sb.append("\n      , ONLINE_GUB_CODE");
        sb.append("\n      , 'Y' FLG"); //2011.11.24:김도영 과장 Y로 요청
        sb.append("\n      , REGIST_DT");
        sb.append("\n      , MODIFY_DT");
        sb.append("\n      , '' CANCEL_DT");
        sb.append("\n      , ' ' EAI_STAT"); //20170209(유종일) ERP연계 속도로 인한 기존 null 에서 공백으로 수정
        sb.append("\n      , '' EAI_CDATE");
        sb.append("\n      , '' EAI_UDATE");
        sb.append(
            "\n      , (SELECT CODE FROM EXEDI.TB_CODE_INFO WHERE CODE_GRP_ID = 'ERP_EVIDENCE_CODE' AND REF1 = '2' AND REF2 ='1'  AND REF3 = ?) ERP_EVIDENCE_CODE"
        ); //생성
        sb.append("\n      , VAT_GUB_CODE");
        sb.append("\n      , RECEIPT_GUB_CODE");
        sb.append("\n      , REGIST_ID");
        sb.append("\n      , null BELNR");
        sb.append("\n  , ? ASP_ISSUE_ID");
        sb.append("\n  , TAX_TYPE_CODE TAX_TYPE_CODE , null");
        sb.append("\n   FROM EXEDI.TB_TAX_BILL_INFO");
        sb.append("\n   WHERE IO_CODE = ?");
        sb.append("\n    AND ISSUE_DAY = ?");
        sb.append("\n    AND BIZ_MANAGE_ID = ?");

        return sb.toString();
    }
}
