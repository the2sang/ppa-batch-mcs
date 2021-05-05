package com.kepco.ppa.web.batch.writer;

import com.kepco.ppa.web.common.YAMLConfig;
import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
@Slf4j
public class TbTaxBillInfoEncTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    //private final String DB_ENC = "1";  //차 후 application.yml 에서 가져오도록 수정 필요..  1-암호화 0-비암호화

    @Autowired
    private YAMLConfig myConfig;

    public String getWriteSQL(String dbenc) {
        StringBuffer sb = new StringBuffer();

        if (dbenc.equals("1")) {
            sb.append("\n MERGE INTO EXEDI.TB_TAX_BILL_INFO_ENC DAT");
        } else {
            sb.append("\n MERGE INTO EXEDI.TB_TAX_BILL_INFO_ENC DAT"); // 무조건 암호 적용으로 의미없음
            //sb.append("\n MERGE INTO EXEDI.TB_TAX_BILL_INFO DAT");   //기존 소스에 TB_TAX_BILL_INFO로 되어 있음 테스트를 위해 임의로 변경 (실제 테스트시 변경)
        }
        //수정 유종일
        //sb.append("\n USING ( SELECT COUNT(*) CNT																														");
        //sb.append("\n           FROM TB_TAX_BILL_INFO																													");
        //sb.append("\n          WHERE IO_CODE = ?																														");
        //sb.append("\n            AND ISSUE_DAY = ?																														");
        //sb.append("\n            AND BIZ_MANAGE_ID = ?) T																												");

        sb.append("\n USING ( SELECT ? IO_CODE																														");
        sb.append("\n            , ? ISSUE_DAY																														");
        sb.append("\n            , ? BIZ_MANAGE_ID FROM DUAL) T 																											");
        //수정 유종일
        //sb.append("\n    ON (T.CNT > 0)																																	");
        sb.append("\n  ON (DAT.IO_CODE=T.IO_CODE 																														");
        sb.append("\n  AND DAT.ISSUE_DAY=T.ISSUE_DAY  																														");
        sb.append("\n  AND DAT.BIZ_MANAGE_ID=T.BIZ_MANAGE_ID) 																														");

        sb.append("\n  WHEN MATCHED THEN																																");
        sb.append("\n       UPDATE SET																																	");
        sb.append("\n              SVC_MANAGE_ID = TRIM(?)																												");
        sb.append("\n            , SIGNATURE = TRIM(?)																													");
        sb.append("\n            , ISSUE_ID = TRIM(?)																													");
        sb.append("\n            , BILL_TYPE_CODE = TRIM(?)																												");
        sb.append("\n            , PURPOSE_CODE = TRIM(?)																												");
        sb.append("\n            , AMENDMENT_CODE = TRIM(?)																												");
        sb.append("\n            , DESCRIPTION = TRIM(?)																												");
        sb.append("\n            , IMPORT_DOC_ID = TRIM(?)																												");
        sb.append("\n            , IMPORT_PERIOD_START_DAY = TRIM(?)																									");
        sb.append("\n            , IMPORT_PERIOD_END_DAY = TRIM(?)																										");
        sb.append("\n            , IMPORT_ITEM_QUANTITY = TRIM(?)																										");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , INVOICER_PARTY_ID_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICER_PARTY_ID', TRIM(?), 'update')					"
            );
        } else {
            sb.append("\n            , INVOICER_PARTY_ID = 	TRIM(?) 																										");
        }
        sb.append("\n            , INVOICER_TAX_REGIST_ID = TRIM(?)																										");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , INVOICER_PARTY_NAME_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICER_PARTY_NAME', TRIM(?), 'update')				"
            );
        } else {
            sb.append("\n            , INVOICER_PARTY_NAME = TRIM(?)																										");
        }
        sb.append("\n            , INVOICER_CEO_NAME = TRIM(?)																											");
        sb.append("\n            , INVOICER_ADDR = ?																												");
        sb.append("\n            , INVOICER_TYPE = TRIM(?)																												");
        sb.append("\n            , INVOICER_CLASS = TRIM(?)																												");
        sb.append("\n            , INVOICER_CONTACT_DEPART = TRIM(?)																									");
        sb.append("\n            , INVOICER_CONTACT_NAME = TRIM(?)																										");
        sb.append("\n            , INVOICER_CONTACT_PHONE = TRIM(?)																										");
        sb.append("\n            , INVOICER_CONTACT_EMAIL = TRIM(?)																										");
        sb.append("\n            , INVOICEE_BUSINESS_TYPE_CODE = TRIM(?)																								");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , INVOICEE_PARTY_ID_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICEE_PARTY_ID', TRIM(?), 'update')					"
            );
        } else {
            sb.append("\n            , INVOICEE_PARTY_ID = TRIM(?)																											");
        }
        sb.append("\n            , INVOICEE_TAX_REGIST_ID = TRIM(?)																										");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , INVOICEE_PARTY_NAME_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICEE_PARTY_NAME', TRIM(?), 'update')				"
            );
        } else {
            sb.append("\n            , INVOICEE_PARTY_NAME = TRIM(?)																										");
        }
        sb.append("\n            , INVOICEE_CEO_NAME = TRIM(?)																											");
        sb.append("\n            , INVOICEE_ADDR = ?																												");
        sb.append("\n            , INVOICEE_TYPE = TRIM(?)																												");
        sb.append("\n            , INVOICEE_CLASS = TRIM(?)																												");
        sb.append("\n            , INVOICEE_CONTACT_DEPART1 = TRIM(?)																									");
        sb.append("\n            , INVOICEE_CONTACT_NAME1 = TRIM(?)																										");
        sb.append("\n            , INVOICEE_CONTACT_PHONE1 = TRIM(?)																									");
        sb.append("\n            , INVOICEE_CONTACT_EMAIL1 = TRIM(?)																									");
        sb.append("\n            , INVOICEE_CONTACT_DEPART2 = TRIM(?)																									");
        sb.append("\n            , INVOICEE_CONTACT_NAME2 = TRIM(?)																										");
        sb.append("\n            , INVOICEE_CONTACT_PHONE2 = TRIM(?)																									");
        sb.append("\n            , INVOICEE_CONTACT_EMAIL2 = TRIM(?)																									");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , BROKER_PARTY_ID_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'BROKER_PARTY_ID', TRIM(?), 'update')						"
            );
        } else {
            sb.append("\n            , BROKER_PARTY_ID = TRIM(?)																											");
        }
        sb.append("\n            , BROKER_TAX_REGIST_ID = TRIM(?)																										");
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , BROKER_PARTY_NAME_ENC = inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'BROKER_PARTY_NAME', TRIM(?), 'update')					"
            );
        } else {
            sb.append("\n            , BROKER_PARTY_NAME = TRIM(?)																											");
        }
        sb.append("\n            , BROKER_CEO_NAME = TRIM(?)																											");
        sb.append("\n            , BROKER_ADDR = TRIM(?)																												");
        sb.append("\n            , BROKER_TYPE = TRIM(?)																												");
        sb.append("\n            , BROKER_CLASS = TRIM(?)																												");
        sb.append("\n            , BROKER_CONTACT_DEPART = TRIM(?)																										");
        sb.append("\n            , BROKER_CONTACT_NAME = TRIM(?)																										");
        sb.append("\n            , BROKER_CONTACT_PHONE = TRIM(?)																										");
        sb.append("\n            , BROKER_CONTACT_EMAIL = TRIM(?)																										");
        sb.append("\n            , PAYMENT_TYPE_CODE1 = TRIM(?)																											");
        sb.append("\n            , PAY_AMOUNT1 = TRIM(?)																												");
        sb.append("\n            , PAYMENT_TYPE_CODE2 = TRIM(?)																											");
        sb.append("\n            , PAY_AMOUNT2 = TRIM(?)																												");
        sb.append("\n            , PAYMENT_TYPE_CODE3 = TRIM(?)																											");
        sb.append("\n            , PAY_AMOUNT3 = TRIM(?)																												");
        sb.append("\n            , PAYMENT_TYPE_CODE4 = TRIM(?)																											");
        sb.append("\n            , PAY_AMOUNT4 = TRIM(?)																												");
        sb.append("\n            , CHARGE_TOTAL_AMOUNT = TRIM(?)																										");
        sb.append("\n            , TAX_TOTAL_AMOUNT = TRIM(?)																											");
        sb.append("\n            , GRAND_TOTAL_AMOUNT = TRIM(?)																											");
        sb.append("\n            , STATUS_CODE = TRIM(?)																												");
        sb.append("\n            , ELECTRONIC_REPORT_YN = TRIM(?)																										");
        sb.append("\n            , ONLINE_GUB_CODE = TRIM(?)																											");
        sb.append("\n            , ADD_TAX_YN = TRIM(?)																													");
        sb.append("\n            , INVOICEE_GUB_CODE = TRIM(?)																											");
        sb.append("\n            , REL_SYSTEM_ID = TRIM(?)																												");
        sb.append("\n            , JOB_GUB_CODE = TRIM(?)																												");
        sb.append("\n            , REGIST_DT = SYSDATE																													");
        sb.append("\n            , MODIFY_DT = SYSDATE																													");
        sb.append("\n            , REGIST_ID = TRIM(?)																													");
        sb.append("\n            , MODIFY_ID = TRIM(?)																													");
        sb.append("\n            , UPPER_MANAGE_ID = TRIM(?)																											");
        sb.append("\n            , ERP_SND_YN = TRIM(?)																													");
        sb.append("\n            , ESERO_RTN_CODE = TRIM(?)																												");
        sb.append("\n            , ERP_ACC_YEAR = TRIM(?)																												");
        sb.append("\n            , ERP_SLIP_NO = TRIM(?)																												");
        sb.append("\n            , TAX_TYPE_CODE = TRIM(?)																												");
        sb.append("\n            , TAX_CANCEL_DATA = TRIM(?)																											");
        sb.append("\n            , ERP_SEND_CODE = TRIM(?)																												");
        sb.append("\n            , VAT_GUB_CODE = TRIM(?)																												");
        sb.append("\n            , RECEIPT_GUB_CODE = TRIM(?)																											");
        sb.append("\n            , UUID = TRIM(?)																														");
        sb.append("\n            , ESERO_ISSUE_ID = TRIM(?)																												"); // 2012.05.29추가
        //20170525  수정 유종일
        //  sb.append("\n        WHERE IO_CODE = ?																															");
        //  sb.append("\n          AND ISSUE_DAY = ?																														");
        //  sb.append("\n          AND BIZ_MANAGE_ID = ?																													");
        sb.append("\n  WHEN NOT MATCHED THEN																															");
        sb.append("\n       INSERT(DAT.IO_CODE, DAT.ISSUE_DAY, DAT.BIZ_MANAGE_ID, DAT.SVC_MANAGE_ID, DAT.ISSUE_DT																			");
        sb.append("\n            , DAT.SIGNATURE, DAT.ISSUE_ID, DAT.BILL_TYPE_CODE, DAT.PURPOSE_CODE, DAT.AMENDMENT_CODE																	");
        sb.append(
            "\n            , DAT.DESCRIPTION, DAT.IMPORT_DOC_ID, DAT.IMPORT_PERIOD_START_DAY, DAT.IMPORT_PERIOD_END_DAY, DAT.IMPORT_ITEM_QUANTITY										"
        );
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , DAT.INVOICER_PARTY_ID_ENC, DAT.INVOICER_TAX_REGIST_ID, DAT.INVOICER_PARTY_NAME_ENC, DAT.INVOICER_CEO_NAME, DAT.INVOICER_ADDR								"
            );
        } else {
            sb.append(
                "\n            , DAT.INVOICER_PARTY_ID, DAT.INVOICER_TAX_REGIST_ID, DAT.INVOICER_PARTY_NAME, DAT.INVOICER_CEO_NAME, DAT.INVOICER_ADDR										"
            );
        }
        sb.append(
            "\n            , DAT.INVOICER_TYPE, DAT.INVOICER_CLASS, DAT.INVOICER_CONTACT_DEPART, DAT.INVOICER_CONTACT_NAME, DAT.INVOICER_CONTACT_PHONE								"
        );
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , DAT.INVOICER_CONTACT_EMAIL, DAT.INVOICEE_BUSINESS_TYPE_CODE, DAT.INVOICEE_PARTY_ID_ENC, DAT.INVOICEE_TAX_REGIST_ID, DAT.INVOICEE_PARTY_NAME_ENC			"
            );
        } else {
            sb.append(
                "\n            , DAT.INVOICER_CONTACT_EMAIL, DAT.INVOICEE_BUSINESS_TYPE_CODE, DAT.INVOICEE_PARTY_ID, DAT.INVOICEE_TAX_REGIST_ID, DAT.INVOICEE_PARTY_NAME					"
            );
        }
        sb.append(
            "\n            , DAT.INVOICEE_CEO_NAME, DAT.INVOICEE_ADDR, DAT.INVOICEE_TYPE, DAT.INVOICEE_CLASS, DAT.INVOICEE_CONTACT_DEPART1											"
        );
        sb.append(
            "\n            , DAT.INVOICEE_CONTACT_NAME1, DAT.INVOICEE_CONTACT_PHONE1, DAT.INVOICEE_CONTACT_EMAIL1, DAT.INVOICEE_CONTACT_DEPART2, DAT.INVOICEE_CONTACT_NAME2			"
        );
        if (dbenc.equals("1")) {
            sb.append(
                "\n            , DAT.INVOICEE_CONTACT_PHONE2, DAT.INVOICEE_CONTACT_EMAIL2, DAT.BROKER_PARTY_ID_ENC, DAT.BROKER_TAX_REGIST_ID, DAT.BROKER_PARTY_NAME_ENC					"
            );
        } else {
            sb.append(
                "\n            , DAT.INVOICEE_CONTACT_PHONE2, DAT.INVOICEE_CONTACT_EMAIL2, DAT.BROKER_PARTY_ID, DAT.BROKER_TAX_REGIST_ID, DAT.BROKER_PARTY_NAME					"
            );
        }
        sb.append("\n            , DAT.BROKER_CEO_NAME, DAT.BROKER_ADDR, DAT.BROKER_TYPE, DAT.BROKER_CLASS, DAT.BROKER_CONTACT_DEPART														");
        sb.append(
            "\n            , DAT.BROKER_CONTACT_NAME, DAT.BROKER_CONTACT_PHONE, DAT.BROKER_CONTACT_EMAIL, DAT.PAYMENT_TYPE_CODE1, DAT.PAY_AMOUNT1										"
        );
        sb.append(
            "\n            , DAT.PAYMENT_TYPE_CODE2, DAT.PAY_AMOUNT2, DAT.PAYMENT_TYPE_CODE3, DAT.PAY_AMOUNT3, DAT.PAYMENT_TYPE_CODE4													"
        );
        sb.append(
            "\n            , DAT.PAY_AMOUNT4, DAT.CHARGE_TOTAL_AMOUNT, DAT.TAX_TOTAL_AMOUNT, DAT.GRAND_TOTAL_AMOUNT, DAT.STATUS_CODE													"
        );
        sb.append(
            "\n            , DAT.ELECTRONIC_REPORT_YN, DAT.ONLINE_GUB_CODE, DAT.ADD_TAX_YN, DAT.INVOICEE_GUB_CODE, DAT.REL_SYSTEM_ID					"
        );
        sb.append("\n            , DAT.JOB_GUB_CODE, DAT.REGIST_DT, DAT.MODIFY_DT, DAT.REGIST_ID, DAT.MODIFY_ID												");
        sb.append("\n            , DAT.UPPER_MANAGE_ID, DAT.ERP_SND_YN, DAT.ESERO_RTN_CODE, DAT.ERP_ACC_YEAR, DAT.ERP_SLIP_NO								");
        sb.append("\n            , DAT.TAX_TYPE_CODE, DAT.TAX_CANCEL_DATA, DAT.ERP_SEND_CODE, DAT.VAT_GUB_CODE, DAT.RECEIPT_GUB_CODE						");
        sb.append("\n            , DAT.UUID , DAT.ESERO_ISSUE_ID																				"); // 2012.05.29 추가
        if (dbenc.equals("1")) {
            sb.append("\n            , DAT.INVOICER_PARTY_ID, DAT.INVOICEE_PARTY_ID, DAT.BROKER_PARTY_ID												"); //암호화 되지 않은 컬럼 추가 20130227 장지호
            sb.append("\n            , DAT.INVOICER_PARTY_NAME, DAT.INVOICEE_PARTY_NAME, DAT.BROKER_PARTY_NAME											"); //암호화 되지 않은 컬럼 추가 20130227 장지호
        }
        sb.append("\n			)																										");
        sb.append("\n       VALUES(TRIM(?), TRIM(?), TRIM(?), TRIM(?), TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')								");
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)															"); //10
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)															"); //15
        if (dbenc.equals("1")) {
            sb.append("\n            , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICER_PARTY_ID', TRIM(?), 'insert')									"); //16
        } else {
            sb.append("\n			 , TRIM(?)");
        }
        sb.append("\n			 , TRIM(?)");
        if (dbenc.equals("1")) {
            sb.append("\n 		   	 , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICER_PARTY_NAME', TRIM(?), 'insert')								"); //18
        } else {
            sb.append("\n			 , TRIM(?)");
        }
        sb.append("\n 		   	 , TRIM(?), ?																							"); //20
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)															"); //25
        sb.append("\n            , TRIM(?), TRIM(?)																						");
        if (dbenc.equals("1")) {
            sb.append("\n			 , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICEE_PARTY_ID', TRIM(?), 'insert')			"); //28
        } else {
            sb.append("\n			 , TRIM(?)");
        }
        sb.append("\n			 , TRIM(?)");
        if (dbenc.equals("1")) {
            sb.append("\n			 , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'INVOICEE_PARTY_NAME', TRIM(?), 'insert')		"); //30
        } else {
            sb.append("\n			 , TRIM(?)");
        }
        sb.append("\n            , TRIM(?), ?, TRIM(?), TRIM(?), TRIM(?)																"); //35
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)															"); //40
        sb.append("\n            , TRIM(?), TRIM(?)");
        if (dbenc.equals("1")) {
            sb.append("\n 			 , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'BROKER_PARTY_ID', TRIM(?), 'insert')			"); //43
        } else {
            sb.append("\n 			 , TRIM(?)");
        }
        sb.append("\n 			 , TRIM(?)");
        if (dbenc.equals("1")) {
            sb.append("\n 			 , inisafedb.encrypt_varchar2('EXEDI.TB_TAX_BILL_INFO', 'BROKER_PARTY_NAME', TRIM(?), 'insert')			"); //45
        } else {
            sb.append("\n 			 , TRIM(?)");
        }
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //50
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //55
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //60
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //65
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //70
        sb.append("\n            , TRIM(?), SYSDATE, SYSDATE, TRIM(?), TRIM(?)"); //75
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //80
        sb.append("\n            , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)"); //85
        sb.append("\n            , TRIM(?), TRIM(?)"); // 2012.05.29 추가
        if (dbenc.equals("1")) {
            sb.append("\n            , '0','0','0', '0','0','0'																				"); //암호화 되지 않은 컬럼 기본값 추가 20130227 장지호
        }
        sb.append("\n )																													");

        return sb.toString();
    }
}
