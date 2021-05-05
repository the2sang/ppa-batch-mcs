package com.kepco.ppa.web.batch.domain;

import java.sql.Date;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtsTaxMetaInfoTbVO {

    private String uuid;
    private Date createTime;
    private Date completeTime;
    private String serviceId;
    private String signature;
    private String userDn;
    private String signcert;
    private String docState;
    private String senderId;
    private String receiverId;
    private String senderCompId;
    private String receiverCompId;
    private Date extDocInsDate;
    private String extDocResultStatus;
    private String extDocResultMsg;
    private String extSystemType;
    private String extVoucherType;
    private String extPurchaseType;
    private String extDecuctionStatus;
    private String extDecuctionDetail;
    private String extBuyerSabun;
    private String extValidSdate;
    private String extValidEdate;
    private String writerId;
    private String confirmSigncert;
    private String writeType;
    private String voucherBuseo;
    private String voucherYearmonth;
    private String voucherSeq;
    private String statusCode;
    private String updateTrrigerState;
    private String contractorId;
    private String contractNo;
    private String constructNo;
    private String kisungChgNo;
    private String reportType;
    private String inspectorId;
    private String docProcessStatus;
    private String extDocReissueMsg;
    private String compCode;
    private String relSystemId;
    private String jobGubCode;
    private String vatGubCode;
    private String receiptGubCode;
    private String invoiceeBusinessTypeCode;
    private String svcManageId;
    private String erpAccYear;
    private String erpSlipNo;
    private String BillUseCode;
    private String delayPenalty;
    private String delayDays;
    private String delayCostcentercode;
}
