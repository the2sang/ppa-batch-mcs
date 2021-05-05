package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class TaxEmailBillInfoOutputRowMapper implements RowMapper<TaxEmailBillInfoOutputVO> {

    @Override
    public TaxEmailBillInfoOutputVO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new TaxEmailBillInfoOutputVO(
            resultSet.getString("ISSUE_ID"),
            resultSet.getString("ISSUE_DAY"),
            resultSet.getString("ISSUE_DT"),
            resultSet.getString("BILL_TYPE_CODE"),
            resultSet.getString("PURPOSE_CODE"),
            resultSet.getString("AMENDMENT_CODE"),
            resultSet.getString("DESCRIPTION"),
            resultSet.getString("IMPORT_DOC_ID"),
            resultSet.getString("IMPORT_PERIOD_START_DAY"),
            resultSet.getString("IMPORT_PERIOD_END_DAY"), //10
            resultSet.getInt("IMPORT_ITEM_QUANTITY"),
            resultSet.getString("INVOICER_PARTY_ID"),
            resultSet.getString("INVOICER_TAX_REGIST_ID"),
            resultSet.getString("INVOICER_PARTY_NAME"),
            resultSet.getString("INVOICER_CEO_NAME"),
            resultSet.getString("INVOICER_ADDR"),
            resultSet.getString("INVOICER_TYPE"),
            resultSet.getString("INVOICER_CLASS"),
            resultSet.getString("INVOICER_CONTACT_DEPART"),
            resultSet.getString("INVOICER_CONTACT_NAME"), //20
            resultSet.getString("INVOICER_CONTACT_PHONE"),
            resultSet.getString("INVOICER_CONTACT_EMAIL"),
            resultSet.getString("INVOICEE_BUSINESS_TYPE_CODE"),
            resultSet.getString("INVOICEE_PARTY_ID"),
            resultSet.getString("INVOICEE_TAX_REGIST_ID"),
            resultSet.getString("INVOICEE_PARTY_NAME"),
            resultSet.getString("INVOICEE_CEO_NAME"),
            resultSet.getString("INVOICEE_ADDR"),
            resultSet.getString("INVOICEE_TYPE"),
            resultSet.getString("INVOICEE_CLASS"), //30
            resultSet.getString("INVOICEE_CONTACT_DEPART1"),
            resultSet.getString("INVOICEE_CONTACT_NAME1"),
            resultSet.getString("INVOICEE_CONTACT_PHONE1"),
            resultSet.getString("INVOICEE_CONTACT_EMAIL1"),
            resultSet.getString("INVOICEE_CONTACT_DEPART2"),
            resultSet.getString("INVOICEE_CONTACT_NAME2"),
            resultSet.getString("INVOICEE_CONTACT_PHONE2"),
            resultSet.getString("INVOICEE_CONTACT_EMAIL2"),
            resultSet.getString("BROKER_PARTY_ID"),
            resultSet.getString("BROKER_TAX_REGIST_ID"), //40
            resultSet.getString("BROKER_PARTY_NAME"),
            resultSet.getString("BROKER_CEO_NAME"),
            resultSet.getString("BROKER_ADDR"),
            resultSet.getString("BROKER_TYPE"),
            resultSet.getString("BROKER_CLASS"),
            resultSet.getString("BROKER_CONTACT_DEPART"),
            resultSet.getString("BROKER_CONTACT_NAME"),
            resultSet.getString("BROKER_CONTACT_PHONE"),
            resultSet.getString("BROKER_CONTACT_EMAIL"),
            resultSet.getString("PAYMENT_TYPE_CODE1"), //50
            resultSet.getLong("PAY_AMOUNT1"),
            resultSet.getString("PAYMENT_TYPE_CODE2"),
            resultSet.getLong("PAY_AMOUNT2"),
            resultSet.getString("PAYMENT_TYPE_CODE3"),
            resultSet.getLong("PAY_AMOUNT3"),
            resultSet.getString("PAYMENT_TYPE_CODE4"),
            resultSet.getLong("PAY_AMOUNT4"),
            resultSet.getLong("CHARGE_TOTAL_AMOUNT"),
            resultSet.getLong("TAX_TOTAL_AMOUNT"),
            resultSet.getLong("GRAND_TOTAL_AMOUNT"), //60
            resultSet.getDate("REGIST_DT"),
            resultSet.getDate("MODIFY_DT"),
            resultSet.getString("REGIST_ID"),
            resultSet.getString("MODIFY_ID"),
            resultSet.getString("MAIL_GUB_CODE"),
            resultSet.getString("MAIL_STATUS_CODE"),
            resultSet.getString("XML_INDIVIDUAL_KEY"),
            resultSet.getString("ORG_ISSUE_ID")
        );
    }
}
