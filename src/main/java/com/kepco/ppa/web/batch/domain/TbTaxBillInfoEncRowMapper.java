package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TbTaxBillInfoEncRowMapper implements RowMapper<TbTaxBillInfoEncVO> {

    @Override
    public TbTaxBillInfoEncVO mapRow(ResultSet resultSet, int i) throws SQLException {
        return new TbTaxBillInfoEncVO(
            resultSet.getString("IO_CODE"),
            resultSet.getString("ISSUE_DAY"),
            resultSet.getString("BIZ_MANAGE_ID"),
            resultSet.getString("SVC_MANAGE_ID"),
            resultSet.getString("ISSUE_DT"),
            resultSet.getString("SIGNATURE"),
            resultSet.getString("ISSUE_ID"),
            resultSet.getString("BILL_TYPE_CODE"),
            resultSet.getString("PURPOSE_CODE"),
            resultSet.getString("AMENDMENT_CODE"), //10
            resultSet.getString("DESCRIPTION"),
            resultSet.getString("IMPORT_DOC_ID"),
            resultSet.getString("IMPORT_PERIOD_START_DAY"),
            resultSet.getString("IMPORT_PERIOD_END_DAY"),
            resultSet.getInt("IMPORT_ITEM_QUANTITY"), //15
            resultSet.getString("INVOICER_PARTY_ID"),
            resultSet.getString("INVOICER_TAX_REGIST_ID"),
            resultSet.getString("INVOICER_PARTY_NAME"),
            resultSet.getString("INVOICER_CEO_NAME"),
            resultSet.getString("INVOICER_ADDR"), //20
            resultSet.getString("INVOICER_TYPE"),
            resultSet.getString("INVOICER_CLASS"),
            resultSet.getString("INVOICER_CONTACT_DEPART"),
            resultSet.getString("INVOICER_CONTACT_NAME"),
            resultSet.getString("INVOICER_CONTACT_PHONE"),
            resultSet.getString("INVOICER_CONTACT_EMAIL"),
            resultSet.getString("INVOICEE_BUSINESS_TYPE_CODE"),
            resultSet.getString("INVOICEE_PARTY_ID"),
            resultSet.getString("INVOICEE_TAX_REGIST_ID"),
            resultSet.getString("INVOICEE_PARTY_NAME"), //30
            resultSet.getString("INVOICEE_CEO_NAME"),
            resultSet.getString("INVOICEE_ADDR"),
            resultSet.getString("INVOICEE_TYPE"),
            resultSet.getString("INVOICEE_CLASS"),
            resultSet.getString("INVOICEE_CONTACT_DEPART1"),
            resultSet.getString("INVOICEE_CONTACT_NAME1"),
            resultSet.getString("INVOICEE_CONTACT_PHONE1"),
            resultSet.getString("INVOICEE_CONTACT_EMAIL1"),
            resultSet.getString("INVOICEE_CONTACT_DEPART2"),
            resultSet.getString("INVOICEE_CONTACT_NAME2"), //40
            resultSet.getString("INVOICEE_CONTACT_PHONE2"),
            resultSet.getString("INVOICEE_CONTACT_EMAIL2"),
            resultSet.getString("BROKER_PARTY_ID"),
            resultSet.getString("BROKER_TAX_REGIST_ID"),
            resultSet.getString("BROKER_PARTY_NAME"),
            resultSet.getString("BROKER_CEO_NAME"),
            resultSet.getString("BROKER_ADDR"),
            resultSet.getString("BROKER_TYPE"),
            resultSet.getString("BROKER_CLASS"),
            resultSet.getString("BROKER_CONTACT_DEPART"), //50
            resultSet.getString("BROKER_CONTACT_NAME"),
            resultSet.getString("BROKER_CONTACT_PHONE"),
            resultSet.getString("BROKER_CONTACT_EMAIL"),
            resultSet.getString("PAYMENT_TYPE_CODE1"),
            resultSet.getLong("PAY_AMOUNT1"),
            resultSet.getString("PAYMENT_TYPE_CODE2"),
            resultSet.getLong("PAY_AMOUNT2"),
            resultSet.getString("PAYMENT_TYPE_CODE3"),
            resultSet.getLong("PAY_AMOUNT3"),
            resultSet.getString("PAYMENT_TYPE_CODE4"), //60
            resultSet.getLong("PAY_AMOUNT4"),
            resultSet.getLong("CHARGE_TOTAL_AMOUNT"),
            resultSet.getLong("TAX_TOTAL_AMOUNT"),
            resultSet.getLong("GRAND_TOTAL_AMOUNT"),
            resultSet.getString("STATUS_CODE"),
            resultSet.getString("ELECTRONIC_REPORT_YN"),
            resultSet.getString("ONLINE_GUB_CODE"),
            resultSet.getString("ADD_TAX_YN"),
            resultSet.getString("INVOICEE_GUB_CODE"),
            resultSet.getString("REL_SYSTEM_ID"),
            resultSet.getString("JOB_GUB_CODE"),
            resultSet.getDate("REGIST_DT"),
            resultSet.getDate("MODIFY_DT"),
            resultSet.getString("REGIST_ID"),
            resultSet.getString("MODIFY_ID"),
            resultSet.getString("UPPER_MANAGE_ID"),
            resultSet.getString("ERP_SND_YN"),
            resultSet.getString("ESERO_RTN_CODE"),
            resultSet.getString("ERP_ACC_YEAR"),
            resultSet.getString("ERP_SLIP_NO"), //80
            resultSet.getString("TAX_TYPE_CODE"),
            resultSet.getString("TAX_CANCEL_DATA"),
            resultSet.getString("ERP_SEND_CODE"),
            resultSet.getString("VAT_GUB_CODE"),
            resultSet.getString("RECEIPT_GUB_CODE"),
            resultSet.getString("UUID"),
            resultSet.getString("ESERO_ISSUE_ID"),
            resultSet.getString("TAX_2ND_SIGN"),
            resultSet.getString("ISSUE_DT2"),
            resultSet.getString("BROKER_PARTY_ID_ENC"), //90
            resultSet.getString("BROKER_PARTY_NAME_ENC"),
            resultSet.getString("INVOICER_PARTY_ID_ENC"),
            resultSet.getString("INVOICER_PARTY_NAME_ENC"),
            resultSet.getString("INVOICEE_PARTY_ID_ENC"),
            resultSet.getString("INVOICEE_PARTY_NAME_ENC"),
            resultSet.getString("CHARGE_TOTAL_AMOUNT_ENC"),
            resultSet.getString("TAX_TOTAL_AMOUNT_ENC"),
            resultSet.getString("GRAND_TOTAL_AMOUNT_ENC"),
            resultSet.getDate("ESERO_CREATE_TS"),
            resultSet.getDate("ESERO_FINISH_TS") //100
        );
    }
}
