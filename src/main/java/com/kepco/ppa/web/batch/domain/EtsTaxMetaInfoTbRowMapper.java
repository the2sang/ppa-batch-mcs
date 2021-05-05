package com.kepco.ppa.web.batch.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EtsTaxMetaInfoTbRowMapper implements RowMapper<EtsTaxMetaInfoTbVO> {

    @Override
    public EtsTaxMetaInfoTbVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EtsTaxMetaInfoTbVO(
            rs.getString("UUID"),
            rs.getDate("CREATE_TIME"),
            rs.getDate("COMPLETE_TIME"),
            rs.getString("SERVICE_ID"),
            rs.getString("SIGNATURE"),
            rs.getString("USER_DN"),
            rs.getString("SIGNCERT"),
            rs.getString("DOC_STATE"),
            rs.getString("SENDER_ID"),
            rs.getString("RECEIVER_ID"),
            rs.getString("SENDER_COMP_ID"),
            rs.getString("RECEIVER_COMP_ID"),
            rs.getDate("EXT_DOC_INS_DATE"),
            rs.getString("EXT_DOC_RESULT_STATUS"),
            rs.getString("EXT_DOC_RESULT_MSG"),
            rs.getString("EXT_SYSTEM_TYPE"),
            rs.getString("EXT_VOUCHER_TYPE"),
            rs.getString("EXT_PURCHASE_TYPE"),
            rs.getString("EXT_DECUCTION_STATUS"),
            rs.getString("EXT_DECUCTION_DETAIL"),
            rs.getString("EXT_BUYER_SABUN"),
            rs.getString("EXT_VALID_SDATE"),
            rs.getString("EXT_VALID_EDATE"),
            rs.getString("WRITER_ID"),
            rs.getString("CONFIRM_SIGNCERT"),
            rs.getString("WRITE_TYPE"),
            rs.getString("VOUCHER_BUSEO"),
            rs.getString("VOUCHER_YEARMONTH"),
            rs.getString("VOUCHER_SEQ"),
            rs.getString("STATUS_CODE"),
            rs.getString("UPDATE_TRRIGER_STATE"),
            rs.getString("CONTRACTOR_ID"),
            rs.getString("CONTRACT_NO"),
            rs.getString("CONSTRUCT_NO"),
            rs.getString("KISUNG_CHG_NO"),
            rs.getString("REPORT_TYPE"),
            rs.getString("INSPECTOR_ID"),
            rs.getString("DOC_PROCESS_STATUS"),
            rs.getString("EXT_DOC_REISSUE_MSG"),
            rs.getString("COMP_CODE"),
            rs.getString("REL_SYSTEM_ID"),
            rs.getString("JOB_GUB_CODE"),
            rs.getString("VAT_GUB_CODE"),
            rs.getString("RECEIPT_GUB_CODE"),
            rs.getString("INVOICEE_BUSINESS_TYPE_CODE"),
            rs.getString("SVC_MANAGE_ID"),
            rs.getString("ERP_ACC_YEAR"),
            rs.getString("ERP_SLIP_NO"),
            rs.getString("BILL_USE_CODE"),
            rs.getString("DELAY_PENALTY"),
            rs.getString("DELAY_DAYS"),
            rs.getString("DELAY_COSTCENTERCODE")
        );
    }
}
