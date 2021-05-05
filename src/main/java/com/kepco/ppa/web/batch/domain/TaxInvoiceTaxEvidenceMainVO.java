package com.kepco.ppa.web.batch.domain;

import com.kepco.ppa.web.common.CommonUtility;
import com.kepco.ppa.web.common.Paging;
import java.io.Serializable;

public class TaxInvoiceTaxEvidenceMainVO extends Paging implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4207863392992069541L;

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
    private String purposeCode;
    private String taxTypeCode;

    private String taxTypeName;
    private String docTypeDetailName;

    private String issueId1;
    private String issueId2;
    private String issueId3;

    public String getUuid() {
        return CommonUtility.TrimNull(uuid);
    }

    public String getManagementId() {
        return CommonUtility.TrimNull(managementId);
    }

    public String getDocDate() {
        return CommonUtility.TrimNull(docDate);
    }

    public String getBlankNum() {
        return CommonUtility.TrimNull(blankNum);
    }

    public String getDocTypeCode() {
        return CommonUtility.TrimNull(docTypeCode);
    }

    public String getDemandType() {
        return CommonUtility.TrimNull(demandType);
    }

    public String getVolumId() {
        return CommonUtility.TrimNull(volumId);
    }

    public String getIssueId() {
        return CommonUtility.TrimNull(issueId);
    }

    public String getSeqId() {
        return CommonUtility.TrimNull(seqId);
    }

    public String getRefPurOrdId() {
        return CommonUtility.TrimNull(refPurOrdId);
    }

    public String getRefPurOrdDate() {
        return CommonUtility.TrimNull(refPurOrdDate);
    }

    public String getRefInvDocId() {
        return CommonUtility.TrimNull(refInvDocId);
    }

    public String getRefInvDocDate() {
        return CommonUtility.TrimNull(refInvDocDate);
    }

    public String getRefOtherDocId() {
        return CommonUtility.TrimNull(refOtherDocId);
    }

    public String getDocDesc() {
        return CommonUtility.TrimNull(docDesc);
    }

    public String getImportRegId() {
        return CommonUtility.TrimNull(importRegId);
    }

    public String getBatchIssueSdate() {
        return CommonUtility.TrimNull(batchIssueSdate);
    }

    public String getBatchIssueEdate() {
        return CommonUtility.TrimNull(batchIssueEdate);
    }

    public String getTotImprotCnt() {
        return CommonUtility.TrimNull(totImprotCnt);
    }

    public String getSupplierBizId() {
        return CommonUtility.TrimNull(supplierBizId);
    }

    public String getSupplierId() {
        return CommonUtility.TrimNull(supplierId);
    }

    public String getSupplierName() {
        return CommonUtility.TrimNull(supplierName);
    }

    public String getSupplierPresidentName() {
        return CommonUtility.TrimNull(supplierPresidentName);
    }

    public String getSupplierAddr() {
        return CommonUtility.TrimNull(supplierAddr);
    }

    public String getSupplierBizType() {
        return CommonUtility.TrimNull(supplierBizType);
    }

    public String getSupplierBizClass() {
        return CommonUtility.TrimNull(supplierBizClass);
    }

    public String getSupplierContactorDept() {
        return CommonUtility.TrimNull(supplierContactorDept);
    }

    public String getSupplierContactorName() {
        return CommonUtility.TrimNull(supplierContactorName);
    }

    public String getSupplierContactorTel() {
        return CommonUtility.TrimNull(supplierContactorTel);
    }

    public String getSupplierContactorEmail() {
        return CommonUtility.TrimNull(supplierContactorEmail);
    }

    public String getBuyerBizId() {
        return CommonUtility.TrimNull(buyerBizId);
    }

    public String getBuyerId() {
        return CommonUtility.TrimNull(buyerId);
    }

    public String getBuyerName() {
        return CommonUtility.TrimNull(buyerName);
    }

    public String getBuyerPresidentName() {
        return CommonUtility.TrimNull(buyerPresidentName);
    }

    public String getBuyerAddr() {
        return CommonUtility.TrimNull(buyerAddr);
    }

    public String getBuyerBizType() {
        return CommonUtility.TrimNull(buyerBizType);
    }

    public String getBuyerBizClass() {
        return CommonUtility.TrimNull(buyerBizClass);
    }

    public String getBuyerContactorDept() {
        return CommonUtility.TrimNull(buyerContactorDept);
    }

    public String getBuyerContactorName() {
        return CommonUtility.TrimNull(buyerContactorName);
    }

    public String getBuyerContactorTel() {
        return CommonUtility.TrimNull(buyerContactorTel);
    }

    public String getBuyerContactorEmail() {
        return CommonUtility.TrimNull(buyerContactorEmail);
    }

    public String getChargeAmt() {
        return CommonUtility.TrimNull(chargeAmt);
    }

    public String getTotTaxAmt() {
        return CommonUtility.TrimNull(totTaxAmt);
    }

    public String getTotForeAmt() {
        return CommonUtility.TrimNull(totForeAmt);
    }

    public String getTotQuantity() {
        return CommonUtility.TrimNull(totQuantity);
    }

    public String getTotAmt() {
        return CommonUtility.TrimNull(totAmt);
    }

    public String getPaymentCashDcAmt() {
        return CommonUtility.TrimNull(paymentCashDcAmt);
    }

    public String getPaymentCashFcAmt() {
        return CommonUtility.TrimNull(paymentCashFcAmt);
    }

    public String getPaymentCheckDcAmt() {
        return CommonUtility.TrimNull(paymentCheckDcAmt);
    }

    public String getPaymentCheckFcAmt() {
        return CommonUtility.TrimNull(paymentCheckFcAmt);
    }

    public String getPaymentBillDcAmt() {
        return CommonUtility.TrimNull(paymentBillDcAmt);
    }

    public String getPaymentBillFcAmt() {
        return CommonUtility.TrimNull(paymentBillFcAmt);
    }

    public String getPaymentCreditDcAmt() {
        return CommonUtility.TrimNull(paymentCreditDcAmt);
    }

    public String getPaymentCreditFcAmt() {
        return CommonUtility.TrimNull(paymentCreditFcAmt);
    }

    public String getBusinessTypeCode() {
        return CommonUtility.TrimNull(businessTypeCode);
    }

    public String getNtsIssueId() {
        return CommonUtility.TrimNull(ntsIssueId);
    }

    public String getBefNtsIssueId() {
        return CommonUtility.TrimNull(befNtsIssueId);
    }

    public String getModifyCode() {
        return CommonUtility.TrimNull(modifyCode);
    }

    public String getSupplierBizCd() {
        return CommonUtility.TrimNull(supplierBizCd);
    }

    public String getBuyerBizCd() {
        return CommonUtility.TrimNull(buyerBizCd);
    }

    public String getDocTypeDetail() {
        return CommonUtility.TrimNull(docTypeDetail);
    }

    public String getAspIssueId() {
        return CommonUtility.TrimNull(aspIssueId);
    }

    public String getPurposeCode() {
        return CommonUtility.TrimNull(purposeCode);
    }

    public String getTaxTypeCode() {
        return CommonUtility.TrimNull(taxTypeCode);
    }

    public String getTaxTypeName() {
        return CommonUtility.TrimNull(taxTypeName);
    }

    public String getDocTypeDetailName() {
        return CommonUtility.TrimNull(docTypeDetailName);
    }

    public String getIssueId1() {
        return CommonUtility.TrimNull(issueId1);
    }

    public String getIssueId2() {
        return CommonUtility.TrimNull(issueId2);
    }

    public String getIssueId3() {
        return CommonUtility.TrimNull(issueId3);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setManagementId(String managementId) {
        this.managementId = managementId;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public void setBlankNum(String blankNum) {
        this.blankNum = blankNum;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public void setDemandType(String demandType) {
        this.demandType = demandType;
    }

    public void setVolumId(String volumId) {
        this.volumId = volumId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

    public void setRefPurOrdId(String refPurOrdId) {
        this.refPurOrdId = refPurOrdId;
    }

    public void setRefPurOrdDate(String refPurOrdDate) {
        this.refPurOrdDate = refPurOrdDate;
    }

    public void setRefInvDocId(String refInvDocId) {
        this.refInvDocId = refInvDocId;
    }

    public void setRefInvDocDate(String refInvDocDate) {
        this.refInvDocDate = refInvDocDate;
    }

    public void setRefOtherDocId(String refOtherDocId) {
        this.refOtherDocId = refOtherDocId;
    }

    public void setDocDesc(String docDesc) {
        this.docDesc = docDesc;
    }

    public void setImportRegId(String importRegId) {
        this.importRegId = importRegId;
    }

    public void setBatchIssueSdate(String batchIssueSdate) {
        this.batchIssueSdate = batchIssueSdate;
    }

    public void setBatchIssueEdate(String batchIssueEdate) {
        this.batchIssueEdate = batchIssueEdate;
    }

    public void setTotImprotCnt(String totImprotCnt) {
        this.totImprotCnt = totImprotCnt;
    }

    public void setSupplierBizId(String supplierBizId) {
        this.supplierBizId = supplierBizId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public void setSupplierPresidentName(String supplierPresidentName) {
        this.supplierPresidentName = supplierPresidentName;
    }

    public void setSupplierAddr(String supplierAddr) {
        this.supplierAddr = supplierAddr;
    }

    public void setSupplierBizType(String supplierBizType) {
        this.supplierBizType = supplierBizType;
    }

    public void setSupplierBizClass(String supplierBizClass) {
        this.supplierBizClass = supplierBizClass;
    }

    public void setSupplierContactorDept(String supplierContactorDept) {
        this.supplierContactorDept = supplierContactorDept;
    }

    public void setSupplierContactorName(String supplierContactorName) {
        this.supplierContactorName = supplierContactorName;
    }

    public void setSupplierContactorTel(String supplierContactorTel) {
        this.supplierContactorTel = supplierContactorTel;
    }

    public void setSupplierContactorEmail(String supplierContactorEmail) {
        this.supplierContactorEmail = supplierContactorEmail;
    }

    public void setBuyerBizId(String buyerBizId) {
        this.buyerBizId = buyerBizId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setBuyerPresidentName(String buyerPresidentName) {
        this.buyerPresidentName = buyerPresidentName;
    }

    public void setBuyerAddr(String buyerAddr) {
        this.buyerAddr = buyerAddr;
    }

    public void setBuyerBizType(String buyerBizType) {
        this.buyerBizType = buyerBizType;
    }

    public void setBuyerBizClass(String buyerBizClass) {
        this.buyerBizClass = buyerBizClass;
    }

    public void setBuyerContactorDept(String buyerContactorDept) {
        this.buyerContactorDept = buyerContactorDept;
    }

    public void setBuyerContactorName(String buyerContactorName) {
        this.buyerContactorName = buyerContactorName;
    }

    public void setBuyerContactorTel(String buyerContactorTel) {
        this.buyerContactorTel = buyerContactorTel;
    }

    public void setBuyerContactorEmail(String buyerContactorEmail) {
        this.buyerContactorEmail = buyerContactorEmail;
    }

    public void setChargeAmt(String chargeAmt) {
        this.chargeAmt = chargeAmt;
    }

    public void setTotTaxAmt(String totTaxAmt) {
        this.totTaxAmt = totTaxAmt;
    }

    public void setTotForeAmt(String totForeAmt) {
        this.totForeAmt = totForeAmt;
    }

    public void setTotQuantity(String totQuantity) {
        this.totQuantity = totQuantity;
    }

    public void setTotAmt(String totAmt) {
        this.totAmt = totAmt;
    }

    public void setPaymentCashDcAmt(String paymentCashDcAmt) {
        this.paymentCashDcAmt = paymentCashDcAmt;
    }

    public void setPaymentCashFcAmt(String paymentCashFcAmt) {
        this.paymentCashFcAmt = paymentCashFcAmt;
    }

    public void setPaymentCheckDcAmt(String paymentCheckDcAmt) {
        this.paymentCheckDcAmt = paymentCheckDcAmt;
    }

    public void setPaymentCheckFcAmt(String paymentCheckFcAmt) {
        this.paymentCheckFcAmt = paymentCheckFcAmt;
    }

    public void setPaymentBillDcAmt(String paymentBillDcAmt) {
        this.paymentBillDcAmt = paymentBillDcAmt;
    }

    public void setPaymentBillFcAmt(String paymentBillFcAmt) {
        this.paymentBillFcAmt = paymentBillFcAmt;
    }

    public void setPaymentCreditDcAmt(String paymentCreditDcAmt) {
        this.paymentCreditDcAmt = paymentCreditDcAmt;
    }

    public void setPaymentCreditFcAmt(String paymentCreditFcAmt) {
        this.paymentCreditFcAmt = paymentCreditFcAmt;
    }

    public void setBusinessTypeCode(String businessTypeCode) {
        this.businessTypeCode = businessTypeCode;
    }

    public void setNtsIssueId(String ntsIssueId) {
        this.ntsIssueId = ntsIssueId;
    }

    public void setBefNtsIssueId(String befNtsIssueId) {
        this.befNtsIssueId = befNtsIssueId;
    }

    public void setModifyCode(String modifyCode) {
        this.modifyCode = modifyCode;
    }

    public void setSupplierBizCd(String supplierBizCd) {
        this.supplierBizCd = supplierBizCd;
    }

    public void setBuyerBizCd(String buyerBizCd) {
        this.buyerBizCd = buyerBizCd;
    }

    public void setDocTypeDetail(String docTypeDetail) {
        this.docTypeDetail = docTypeDetail;
    }

    public void setAspIssueId(String aspIssueId) {
        this.aspIssueId = aspIssueId;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public void setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
    }

    public void setDocTypeDetailName(String docTypeDetailName) {
        this.docTypeDetailName = docTypeDetailName;
    }

    public void setIssueId1(String issueId1) {
        this.issueId1 = issueId1;
    }

    public void setIssueId2(String issueId2) {
        this.issueId2 = issueId2;
    }

    public void setIssueId3(String issueId3) {
        this.issueId3 = issueId3;
    }
}
