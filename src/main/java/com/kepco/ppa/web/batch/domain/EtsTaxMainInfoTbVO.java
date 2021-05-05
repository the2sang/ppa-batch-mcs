package com.kepco.ppa.web.batch.domain;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtsTaxMainInfoTbVO {

    private String uuid;
    private String managementId;
    private String docDate;
    private String blankNum;
    private String docTypeCode;
    private String demandType;
    private String volumId;
    private String issueId;
    private String seqId;
    private String refPurOrdId;
    private String refPurOrdDate;
    private String refInvDocId;
    private String refInvDocDate;
    private String refOtherDocId;
    private String docDesc;
    private String importRegId;
    private String batchIssueSdate;
    private String batchIssueEdate;
    private String totImprotCnt;
    private String supplierBizId;
    private String supplierId;
    private String supplierName;
    private String supplierPresidentName;
    private String supplierAddr;
    private String supplierBizType;
    private String supplierBizClass;
    private String supplierContactorDept;
    private String supplierContactorName;
    private String supplierContactorTel;
    private String supplierContactorEmail;
    private String buyerBizId;
    private String buyerId;
    private String buyerName;
    private String buyerPresidentName;
    private String buyerAddr;
    private String buyerBizType;
    private String buyerBizClass;
    private String buyerContactorDept;
    private String buyerContactorName;
    private String buyerContactorTel;
    private String buyerContactorEmail;
    private String chargeAmt;
    private String totTaxAmt;
    private String totForeAmt;
    private String totQuantity;
    private String totAmt;
    private String paymentCashDcAmt;
    private String paymentCashFcAmt;
    private String paymentCheckDcAmt;
    private String paymentCheckFcAmt;
    private String paymentBillDcAmt;
    private String paymentBillFcAmt;
    private String paymentCreditDcAmt;
    private String paymentCreditFcAmt;
    private String businessTypeCode;
    private String ntsIssueId;
    private String befNtsIssueId;
    private String modifyCode;
    private String supplierBizCd;
    private String buyerBizCd;
    private String docTypeDetail;
    private String aspIssueId;
}
