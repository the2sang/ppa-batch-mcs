package com.kepco.ppa.web.batch.domain;

import java.sql.Date;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbTaxBillInfoEncVO {

    private String ioCode;
    private String issueDay;
    private String bizManageId;
    private String svcManageId;
    private String issueDt;
    private String signature;
    private String issueId;
    private String billTypeCode;
    private String purposeCode;
    private String amendmentCode; //10
    private String description;
    private String importDocId;
    private String importPeriodStartDay;
    private String importPeriodEndDay;
    private int importItemQuantity;
    private String invoicerPartyId;
    private String invoicerTaxRegistId;
    private String invoicerPartyName;
    private String invoicerCeoName;
    private String invoicerAddr; //20
    private String invoicerType;
    private String invoicerClass;
    private String invoicerContactDepart;
    private String invoicerContactName;
    private String invoicerContactPhone;
    private String invoicerContactEmail;
    private String invoiceeBusinessTypeCode;
    private String invoiceePartyId;
    private String invoiceeTaxRegistId;
    private String invoiceePartyName;
    private String invoiceeCeoName;
    private String invoiceeAddr;
    private String invoiceeType;
    private String invoiceeClass;
    private String invoiceeContactDepart1;
    private String invoiceeContactName1;
    private String invoiceeContactPhone1;
    private String invoiceeContactEmail1;
    private String invoiceeContactDepart2;
    private String invoiceeContactName2;
    private String invoiceeContactPhone2;
    private String invoiceeContactEmail2;
    private String brokerPartyId;
    private String brokerTaxRegistId;
    private String brokerPartyName;
    private String brokerCeoName;
    private String brokerAddr;
    private String brokerType;
    private String brokerClass;
    private String brokerContactDepart;
    private String brokerContactName;
    private String brokerContactPhone;
    private String brokerContactEmail;
    private String paymentTypeCode1;
    private long payAmount1;
    private String paymentTypeCode2;
    private long payAmount2;
    private String paymentTypeCode3;
    private long payAmount3;
    private String paymentTypeCode4; //60
    private long payAmount4;
    private long chargeTotalAmount;
    private long taxTotalAmount;
    private long grandTotalAmount;
    private String statusCode;
    private String electronicReportYn;
    private String onlineGubCode;
    private String addTaxYn;
    private String invoiceeGubCode;
    private String relSystemId; //70
    private String jobGubCode;
    private Date registDt;
    private Date modifyDt;
    private String registId;
    private String modifyId;
    private String upperManageId;
    private String erpSndYn;
    private String eseroRtnCode;
    private String erpAccYear;
    private String erpSlipNo; //80
    private String taxTypeCode;
    private String taxCancelData;
    private String erpSendCode;
    private String vatGubCode;
    private String receiptGubCode;
    private String uuid;
    private String eseroIssueId;
    private String Tax2ndSign;
    private String issueDt2;
    private String brokerPartyIdEnc;
    private String brokerPartyNameEnc;
    private String invoicerPartyIdEnc;
    private String invoicerPartyNameEnc;
    private String invoiceePartyIdEnc;
    private String invoiceePartyNameENc;
    private String chargeTotalAmountEnc;
    private String taxTotalAmountEnc;
    private String grandTotalAmountEnc;
    private Date eseroCreateTs;
    private Date eseroFinishTs;
}
