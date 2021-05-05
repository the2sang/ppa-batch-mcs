package com.kepco.ppa.web.batch.domain;

import com.kepco.ppa.web.common.CommonUtility;
import com.kepco.ppa.web.common.Paging;
import java.io.Serializable;

public class TaxInvoiceTaxEvidenceMetaVO extends Paging implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8786604764294734297L;

    private String uuid;
    private String createTime;
    private String completeTime;
    private String serviceId;
    private String signature;
    private String userDn;
    private String signcert;
    private String docState;
    private String senderId;
    private String receiverId;
    private String senderCompId;
    private String receiverCompId;
    private String extDocInsDate;
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

    public String getUuid() {
        return CommonUtility.TrimNull(uuid);
    }

    public String getCreateTime() {
        return CommonUtility.TrimNull(createTime);
    }

    public String getCompleteTime() {
        return CommonUtility.TrimNull(completeTime);
    }

    public String getServiceId() {
        return CommonUtility.TrimNull(serviceId);
    }

    public String getSignature() {
        return CommonUtility.TrimNull(signature);
    }

    public String getUserDn() {
        return CommonUtility.TrimNull(userDn);
    }

    public String getSigncert() {
        return CommonUtility.TrimNull(signcert);
    }

    public String getDocState() {
        return CommonUtility.TrimNull(docState);
    }

    public String getSenderId() {
        return CommonUtility.TrimNull(senderId);
    }

    public String getReceiverId() {
        return CommonUtility.TrimNull(receiverId);
    }

    public String getSenderCompId() {
        return CommonUtility.TrimNull(senderCompId);
    }

    public String getReceiverCompId() {
        return CommonUtility.TrimNull(receiverCompId);
    }

    public String getExtDocInsDate() {
        return CommonUtility.TrimNull(extDocInsDate);
    }

    public String getExtDocResultStatus() {
        return CommonUtility.TrimNull(extDocResultStatus);
    }

    public String getExtDocResultMsg() {
        return CommonUtility.TrimNull(extDocResultMsg);
    }

    public String getExtSystemType() {
        return CommonUtility.TrimNull(extSystemType);
    }

    public String getExtVoucherType() {
        return CommonUtility.TrimNull(extVoucherType);
    }

    public String getExtPurchaseType() {
        return CommonUtility.TrimNull(extPurchaseType);
    }

    public String getExtDecuctionStatus() {
        return CommonUtility.TrimNull(extDecuctionStatus);
    }

    public String getExtDecuctionDetail() {
        return CommonUtility.TrimNull(extDecuctionDetail);
    }

    public String getExtBuyerSabun() {
        return CommonUtility.TrimNull(extBuyerSabun);
    }

    public String getExtValidSdate() {
        return CommonUtility.TrimNull(extValidSdate);
    }

    public String getExtValidEdate() {
        return CommonUtility.TrimNull(extValidEdate);
    }

    public String getWriterId() {
        return CommonUtility.TrimNull(writerId);
    }

    public String getConfirmSigncert() {
        return CommonUtility.TrimNull(confirmSigncert);
    }

    public String getWriteType() {
        return CommonUtility.TrimNull(writeType);
    }

    public String getVoucherBuseo() {
        return CommonUtility.TrimNull(voucherBuseo);
    }

    public String getVoucherYearmonth() {
        return CommonUtility.TrimNull(voucherYearmonth);
    }

    public String getVoucherSeq() {
        return CommonUtility.TrimNull(voucherSeq);
    }

    public String getStatusCode() {
        return CommonUtility.TrimNull(statusCode);
    }

    public String getUpdateTrrigerState() {
        return CommonUtility.TrimNull(updateTrrigerState);
    }

    public String getContractorId() {
        return CommonUtility.TrimNull(contractorId);
    }

    public String getContractNo() {
        return CommonUtility.TrimNull(contractNo);
    }

    public String getConstructNo() {
        return CommonUtility.TrimNull(constructNo);
    }

    public String getKisungChgNo() {
        return CommonUtility.TrimNull(kisungChgNo);
    }

    public String getReportType() {
        return CommonUtility.TrimNull(reportType);
    }

    public String getInspectorId() {
        return CommonUtility.TrimNull(inspectorId);
    }

    public String getDocProcessStatus() {
        return CommonUtility.TrimNull(docProcessStatus);
    }

    public String getExtDocReissueMsg() {
        return CommonUtility.TrimNull(extDocReissueMsg);
    }

    public String getCompCode() {
        return CommonUtility.TrimNull(compCode);
    }

    public String getRelSystemId() {
        return CommonUtility.TrimNull(relSystemId);
    }

    public String getJobGubCode() {
        return CommonUtility.TrimNull(jobGubCode);
    }

    public String getVatGubCode() {
        return CommonUtility.TrimNull(vatGubCode);
    }

    public String getReceiptGubCode() {
        return CommonUtility.TrimNull(receiptGubCode);
    }

    public String getInvoiceeBusinessTypeCode() {
        return CommonUtility.TrimNull(invoiceeBusinessTypeCode);
    }

    public String getSvcManageId() {
        return CommonUtility.TrimNull(svcManageId);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setCompleteTime(String completeTime) {
        this.completeTime = completeTime;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setUserDn(String userDn) {
        this.userDn = userDn;
    }

    public void setSigncert(String signcert) {
        this.signcert = signcert;
    }

    public void setDocState(String docState) {
        this.docState = docState;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    public void setSenderCompId(String senderCompId) {
        this.senderCompId = senderCompId;
    }

    public void setReceiverCompId(String receiverCompId) {
        this.receiverCompId = receiverCompId;
    }

    public void setExtDocInsDate(String extDocInsDate) {
        this.extDocInsDate = extDocInsDate;
    }

    public void setExtDocResultStatus(String extDocResultStatus) {
        this.extDocResultStatus = extDocResultStatus;
    }

    public void setExtDocResultMsg(String extDocResultMsg) {
        this.extDocResultMsg = extDocResultMsg;
    }

    public void setExtSystemType(String extSystemType) {
        this.extSystemType = extSystemType;
    }

    public void setExtVoucherType(String extVoucherType) {
        this.extVoucherType = extVoucherType;
    }

    public void setExtPurchaseType(String extPurchaseType) {
        this.extPurchaseType = extPurchaseType;
    }

    public void setExtDecuctionStatus(String extDecuctionStatus) {
        this.extDecuctionStatus = extDecuctionStatus;
    }

    public void setExtDecuctionDetail(String extDecuctionDetail) {
        this.extDecuctionDetail = extDecuctionDetail;
    }

    public void setExtBuyerSabun(String extBuyerSabun) {
        this.extBuyerSabun = extBuyerSabun;
    }

    public void setExtValidSdate(String extValidSdate) {
        this.extValidSdate = extValidSdate;
    }

    public void setExtValidEdate(String extValidEdate) {
        this.extValidEdate = extValidEdate;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public void setConfirmSigncert(String confirmSigncert) {
        this.confirmSigncert = confirmSigncert;
    }

    public void setWriteType(String writeType) {
        this.writeType = writeType;
    }

    public void setVoucherBuseo(String voucherBuseo) {
        this.voucherBuseo = voucherBuseo;
    }

    public void setVoucherYearmonth(String voucherYearmonth) {
        this.voucherYearmonth = voucherYearmonth;
    }

    public void setVoucherSeq(String voucherSeq) {
        this.voucherSeq = voucherSeq;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setUpdateTrrigerState(String updateTrrigerState) {
        this.updateTrrigerState = updateTrrigerState;
    }

    public void setContractorId(String contractorId) {
        this.contractorId = contractorId;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public void setConstructNo(String constructNo) {
        this.constructNo = constructNo;
    }

    public void setKisungChgNo(String kisungChgNo) {
        this.kisungChgNo = kisungChgNo;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    public void setDocProcessStatus(String docProcessStatus) {
        this.docProcessStatus = docProcessStatus;
    }

    public void setExtDocReissueMsg(String extDocReissueMsg) {
        this.extDocReissueMsg = extDocReissueMsg;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public void setRelSystemId(String relSystemId) {
        this.relSystemId = relSystemId;
    }

    public void setJobGubCode(String jobGubCode) {
        this.jobGubCode = jobGubCode;
    }

    public void setVatGubCode(String vatGubCode) {
        this.vatGubCode = vatGubCode;
    }

    public void setReceiptGubCode(String receiptGubCode) {
        this.receiptGubCode = receiptGubCode;
    }

    public void setInvoiceeBusinessTypeCode(String invoiceeBusinessTypeCode) {
        this.invoiceeBusinessTypeCode = invoiceeBusinessTypeCode;
    }

    public void setSvcManageId(String svcManageId) {
        this.svcManageId = svcManageId;
    }
}
