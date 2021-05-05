package com.kepco.ppa.web.batch.domain;

import com.kepco.ppa.web.common.CommonUtility;
import com.kepco.ppa.web.common.Paging;
import java.io.Serializable;

public class TaxSaleTaxInvoiceInfoVO extends Paging implements Serializable {

    private static final long serialVersionUID = 5982813399543388340L;

    private String ioCode;
    private String issueDay;
    private String bizManageId;
    private String svcManageId;
    private String issueDt;
    private String signature;
    private String issueId;
    private String billTypeCode;
    private String billTypeCodeNm;
    private String purposeCode;
    private String amendmentCode;
    private String description;
    private String importDocId;
    private String importPeriodStartDay;
    private String importPeriodEndDay;
    private String importItemQuantity;
    private String invoicerPartyId;
    private String invoicerTaxRegistId;
    private String invoicerPartyName;
    private String invoicerCeoName;
    private String invoicerAddr;
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
    private String payAmount1;
    private String paymentTypeCode2;
    private String payAmount2;
    private String paymentTypeCode3;
    private String payAmount3;
    private String paymentTypeCode4;
    private String payAmount4;
    private String chargeTotalAmount;
    private String taxTotalAmount;
    private String grandTotalAmount;
    private String statusCode;
    private String statusCodeNm;
    private String relSystemId;
    private String jobGubCode;
    private String electronicReportYn;
    private String addTaxYn;
    private String registDt;
    private String modifyDt;
    private String registId;
    private String modifyId;
    private String onlineGubCode;
    private String onlineGubCodeNm;
    private String invoiceeGubCode;
    private String upperManageId;
    private String erpSndYn;
    private String erpAccYear;
    private String erpSlipNo;
    private String taxTypeCode;
    private String taxTypeCodeNm;
    private String taxCancelData;
    private String erpSendCode;

    private String vatGubCode;
    private String receiptGubCode;
    private String uuid;

    private String grandTotalAmountSum; //일괄승인 총액
    private String chargeTotalAmountSum;
    private String taxTotalAmountSum;

    //IF_TAX_BILL_INFO
    private String custNo;
    private String billYyyymm;
    private String billIssueYyyymm;
    private String payDeadline;
    private String flg;
    private String cancelDt;
    private String eaiStat;
    private String eaiCdate;
    private String eaiUdate;
    private String belnr;

    private String procDay; //TB_STATUS_HIST의 AVL_BEGIN_DT 처리일자

    //ets asp issue_id
    private String aspIssueId;
    private String issueId1;
    private String issueId2;
    private String issueId3;

    //TAX_BRANCH_VIEW
    private String zbranCode;
    private String zbranCodeHigh;
    private String buyRegistId;
    private String zbranName;
    private String sosok1;
    private String sosok2;

    //POMASTT2@USER_LINK 의 부서,이름
    private String sosokHan;
    private String name;

    //개인메일 업로드시 사용
    private String mailGubCode;
    private String mailStatusCode;
    private String xmlIndividualKey;

    //원본 작성일
    private String ori_issue_day;

    //구분 값 ( 수정세금계산서 구분) //2012.02.13
    private String gubun;

    private String originIssueId;

    // excel기능으로 인한 추가

    private String esero_issue_id; //승인번호
    private String pupchase_day; //품목일자
    private String item_name; //품목명
    private String item_info; //품목 규격
    private String unit_quantity; //품목수량
    private String unit_amount; //품목 단가
    private String invoice_amount; //물품 공급가액
    private String tax_amount; //물품 세액
    private String item_desc; //비고
    private String t_amt; //총 합계 금액
    private String c_tot; // 총 공급가액
    private String t_t_amt; // 총 세액

    /**
     * @return the esero_issue_id
     */
    public String getEsero_issue_id() {
        return esero_issue_id;
    }

    /**
     * @param eseroIssueId the esero_issue_id to set
     */
    public void setEsero_issue_id(String eseroIssueId) {
        esero_issue_id = eseroIssueId;
    }

    /**
     * @return the pupchase_day
     */
    public String getPupchase_day() {
        return pupchase_day;
    }

    /**
     * @param pupchaseDay the pupchase_day to set
     */
    public void setPupchase_day(String pupchaseDay) {
        pupchase_day = pupchaseDay;
    }

    /**
     * @return the item_name
     */
    public String getItem_name() {
        return item_name;
    }

    /**
     * @param itemName the item_name to set
     */
    public void setItem_name(String itemName) {
        item_name = itemName;
    }

    /**
     * @return the item_info
     */
    public String getItem_info() {
        return item_info;
    }

    /**
     * @param itemInfo the item_info to set
     */
    public void setItem_info(String itemInfo) {
        item_info = itemInfo;
    }

    /**
     * @return the unit_quantity
     */
    public String getUnit_quantity() {
        return unit_quantity;
    }

    /**
     * @param unitQuantity the unit_quantity to set
     */
    public void setUnit_quantity(String unitQuantity) {
        unit_quantity = unitQuantity;
    }

    /**
     * @return the unit_amount
     */
    public String getUnit_amount() {
        return unit_amount;
    }

    /**
     * @param unitAmount the unit_amount to set
     */
    public void setUnit_amount(String unitAmount) {
        unit_amount = unitAmount;
    }

    /**
     * @return the invoice_amount
     */
    public String getInvoice_amount() {
        return invoice_amount;
    }

    /**
     * @param invoiceAmount the invoice_amount to set
     */
    public void setInvoice_amount(String invoiceAmount) {
        invoice_amount = invoiceAmount;
    }

    /**
     * @return the tax_amount
     */
    public String getTax_amount() {
        return tax_amount;
    }

    /**
     * @param taxAmount the tax_amount to set
     */
    public void setTax_amount(String taxAmount) {
        tax_amount = taxAmount;
    }

    /**
     * @return the item_desc
     */
    public String getItem_desc() {
        return item_desc;
    }

    /**
     * @param itemDesc the item_desc to set
     */
    public void setItem_desc(String itemDesc) {
        item_desc = itemDesc;
    }

    /**
     * @return the t_amt
     */
    public String getT_amt() {
        return t_amt;
    }

    /**
     * @param tAmt the t_amt to set
     */
    public void setT_amt(String tAmt) {
        t_amt = tAmt;
    }

    /**
     * @return the c_tot
     */
    public String getC_tot() {
        return c_tot;
    }

    /**
     * @param cTot the c_tot to set
     */
    public void setC_tot(String cTot) {
        c_tot = cTot;
    }

    /**
     * @return the t_t_amt
     */
    public String getT_t_amt() {
        return t_t_amt;
    }

    /**
     * @param tTAmt the t_t_amt to set
     */
    public void setT_t_amt(String tTAmt) {
        t_t_amt = tTAmt;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getIoCode() {
        return CommonUtility.TrimNull(ioCode);
    }

    public String getIssueDay() {
        return CommonUtility.TrimNull(issueDay);
    }

    public String getBizManageId() {
        return CommonUtility.TrimNull(bizManageId);
    }

    public String getSvcManageId() {
        return CommonUtility.TrimNull(svcManageId);
    }

    public String getIssueDt() {
        return CommonUtility.TrimNull(issueDt);
    }

    public String getSignature() {
        return CommonUtility.TrimNull(signature);
    }

    public String getIssueId() {
        return CommonUtility.TrimNull(issueId);
    }

    public String getBillTypeCode() {
        return CommonUtility.TrimNull(billTypeCode);
    }

    public String getBillTypeCodeNm() {
        return CommonUtility.TrimNull(billTypeCodeNm);
    }

    public String getPurposeCode() {
        return CommonUtility.TrimNull(purposeCode);
    }

    public String getAmendmentCode() {
        return CommonUtility.TrimNull(amendmentCode);
    }

    public String getDescription() {
        return CommonUtility.TrimNull(description);
    }

    public String getImportDocId() {
        return CommonUtility.TrimNull(importDocId);
    }

    public String getImportPeriodStartDay() {
        return CommonUtility.TrimNull(importPeriodStartDay);
    }

    public String getImportPeriodEndDay() {
        return CommonUtility.TrimNull(importPeriodEndDay);
    }

    public String getImportItemQuantity() {
        return CommonUtility.TrimNull(importItemQuantity);
    }

    public String getInvoicerPartyId() {
        return CommonUtility.TrimNull(invoicerPartyId);
    }

    public String getInvoicerTaxRegistId() {
        return CommonUtility.TrimNull(invoicerTaxRegistId);
    }

    public String getInvoicerPartyName() {
        return CommonUtility.TrimNull(invoicerPartyName);
    }

    public String getInvoicerCeoName() {
        return CommonUtility.TrimNull(invoicerCeoName);
    }

    public String getInvoicerAddr() {
        return invoicerAddr;
    }

    public String getInvoicerType() {
        return CommonUtility.TrimNull(invoicerType);
    }

    public String getInvoicerClass() {
        return CommonUtility.TrimNull(invoicerClass);
    }

    public String getInvoicerContactDepart() {
        return CommonUtility.TrimNull(invoicerContactDepart);
    }

    public String getInvoicerContactName() {
        return CommonUtility.TrimNull(invoicerContactName);
    }

    public String getInvoicerContactPhone() {
        return CommonUtility.TrimNull(invoicerContactPhone);
    }

    public String getInvoicerContactEmail() {
        return CommonUtility.TrimNull(invoicerContactEmail);
    }

    public String getInvoiceeBusinessTypeCode() {
        return CommonUtility.TrimNull(invoiceeBusinessTypeCode);
    }

    public String getInvoiceePartyId() {
        return CommonUtility.TrimNull(invoiceePartyId);
    }

    public String getInvoiceeTaxRegistId() {
        return CommonUtility.TrimNull(invoiceeTaxRegistId);
    }

    public String getInvoiceePartyName() {
        return CommonUtility.TrimNull(invoiceePartyName);
    }

    public String getInvoiceeCeoName() {
        return CommonUtility.TrimNull(invoiceeCeoName);
    }

    public String getInvoiceeAddr() {
        return invoiceeAddr;
    }

    public String getInvoiceeType() {
        return CommonUtility.TrimNull(invoiceeType);
    }

    public String getInvoiceeClass() {
        return CommonUtility.TrimNull(invoiceeClass);
    }

    public String getInvoiceeContactDepart1() {
        return CommonUtility.TrimNull(invoiceeContactDepart1);
    }

    public String getInvoiceeContactName1() {
        return CommonUtility.TrimNull(invoiceeContactName1);
    }

    public String getInvoiceeContactPhone1() {
        return CommonUtility.TrimNull(invoiceeContactPhone1);
    }

    public String getInvoiceeContactEmail1() {
        return CommonUtility.TrimNull(invoiceeContactEmail1);
    }

    public String getInvoiceeContactDepart2() {
        return CommonUtility.TrimNull(invoiceeContactDepart2);
    }

    public String getInvoiceeContactName2() {
        return CommonUtility.TrimNull(invoiceeContactName2);
    }

    public String getInvoiceeContactPhone2() {
        return CommonUtility.TrimNull(invoiceeContactPhone2);
    }

    public String getInvoiceeContactEmail2() {
        return CommonUtility.TrimNull(invoiceeContactEmail2);
    }

    public String getBrokerPartyId() {
        return CommonUtility.TrimNull(brokerPartyId);
    }

    public String getBrokerTaxRegistId() {
        return CommonUtility.TrimNull(brokerTaxRegistId);
    }

    public String getBrokerPartyName() {
        return CommonUtility.TrimNull(brokerPartyName);
    }

    public String getBrokerCeoName() {
        return CommonUtility.TrimNull(brokerCeoName);
    }

    public String getBrokerAddr() {
        return CommonUtility.TrimNull(brokerAddr);
    }

    public String getBrokerType() {
        return CommonUtility.TrimNull(brokerType);
    }

    public String getBrokerClass() {
        return CommonUtility.TrimNull(brokerClass);
    }

    public String getBrokerContactDepart() {
        return CommonUtility.TrimNull(brokerContactDepart);
    }

    public String getBrokerContactName() {
        return CommonUtility.TrimNull(brokerContactName);
    }

    public String getBrokerContactPhone() {
        return CommonUtility.TrimNull(brokerContactPhone);
    }

    public String getBrokerContactEmail() {
        return CommonUtility.TrimNull(brokerContactEmail);
    }

    public String getPaymentTypeCode1() {
        return CommonUtility.TrimNull(paymentTypeCode1);
    }

    public String getPayAmount1() {
        return CommonUtility.TrimNull(payAmount1);
    }

    public String getPaymentTypeCode2() {
        return CommonUtility.TrimNull(paymentTypeCode2);
    }

    public String getPayAmount2() {
        return CommonUtility.TrimNull(payAmount2);
    }

    public String getPaymentTypeCode3() {
        return CommonUtility.TrimNull(paymentTypeCode3);
    }

    public String getPayAmount3() {
        return CommonUtility.TrimNull(payAmount3);
    }

    public String getPaymentTypeCode4() {
        return CommonUtility.TrimNull(paymentTypeCode4);
    }

    public String getPayAmount4() {
        return CommonUtility.TrimNull(payAmount4);
    }

    public String getChargeTotalAmount() {
        return CommonUtility.TrimNull(chargeTotalAmount);
    }

    public String getTaxTotalAmount() {
        return CommonUtility.TrimNull(taxTotalAmount);
    }

    public String getGrandTotalAmount() {
        return CommonUtility.TrimNull(grandTotalAmount);
    }

    public String getStatusCode() {
        return CommonUtility.TrimNull(statusCode);
    }

    public String getStatusCodeNm() {
        return CommonUtility.TrimNull(statusCodeNm);
    }

    public String getRelSystemId() {
        return CommonUtility.TrimNull(relSystemId);
    }

    public String getJobGubCode() {
        return CommonUtility.TrimNull(jobGubCode);
    }

    public String getElectronicReportYn() {
        return CommonUtility.TrimNull(electronicReportYn);
    }

    public String getAddTaxYn() {
        return CommonUtility.TrimNull(addTaxYn);
    }

    public String getRegistDt() {
        return CommonUtility.TrimNull(registDt);
    }

    public String getModifyDt() {
        return CommonUtility.TrimNull(modifyDt);
    }

    public String getRegistId() {
        return CommonUtility.TrimNull(registId);
    }

    public String getModifyId() {
        return CommonUtility.TrimNull(modifyId);
    }

    public String getOnlineGubCode() {
        return CommonUtility.TrimNull(onlineGubCode);
    }

    public String getOnlineGubCodeNm() {
        return CommonUtility.TrimNull(onlineGubCodeNm);
    }

    public String getInvoiceeGubCode() {
        return CommonUtility.TrimNull(invoiceeGubCode);
    }

    public String getUpperManageId() {
        return CommonUtility.TrimNull(upperManageId);
    }

    public String getErpSndYn() {
        return CommonUtility.TrimNull(erpSndYn);
    }

    public String getErpAccYear() {
        return CommonUtility.TrimNull(erpAccYear);
    }

    public String getErpSlipNo() {
        return CommonUtility.TrimNull(erpSlipNo);
    }

    public String getTaxTypeCode() {
        return CommonUtility.TrimNull(taxTypeCode);
    }

    public String getTaxTypeCodeNm() {
        return CommonUtility.TrimNull(taxTypeCodeNm);
    }

    public String getTaxCancelData() {
        return CommonUtility.TrimNull(taxCancelData);
    }

    public String getErpSendCode() {
        return CommonUtility.TrimNull(erpSendCode);
    }

    public String getVatGubCode() {
        return CommonUtility.TrimNull(vatGubCode);
    }

    public String getReceiptGubCode() {
        return CommonUtility.TrimNull(receiptGubCode);
    }

    public String getUuid() {
        return CommonUtility.TrimNull(uuid);
    }

    public String getGrandTotalAmountSum() {
        return CommonUtility.TrimNull(grandTotalAmountSum);
    }

    public String getChargeTotalAmountSum() {
        return CommonUtility.TrimNull(chargeTotalAmountSum);
    }

    public String getTaxTotalAmountSum() {
        return CommonUtility.TrimNull(taxTotalAmountSum);
    }

    public String getCustNo() {
        return CommonUtility.TrimNull(custNo);
    }

    public String getBillYyyymm() {
        return CommonUtility.TrimNull(billYyyymm);
    }

    public String getBillIssueYyyymm() {
        return CommonUtility.TrimNull(billIssueYyyymm);
    }

    public String getPayDeadline() {
        return CommonUtility.TrimNull(payDeadline);
    }

    public String getFlg() {
        return CommonUtility.TrimNull(flg);
    }

    public String getCancelDt() {
        return CommonUtility.TrimNull(cancelDt);
    }

    public String getEaiStat() {
        return CommonUtility.TrimNull(eaiStat);
    }

    public String getEaiCdate() {
        return CommonUtility.TrimNull(eaiCdate);
    }

    public String getEaiUdate() {
        return CommonUtility.TrimNull(eaiUdate);
    }

    public String getBelnr() {
        return CommonUtility.TrimNull(belnr);
    }

    public String getProcDay() {
        return CommonUtility.TrimNull(procDay);
    }

    public String getZbranCode() {
        return CommonUtility.TrimNull(zbranCode);
    }

    public String getZbranCodeHigh() {
        return CommonUtility.TrimNull(zbranCodeHigh);
    }

    public String getBuyRegistId() {
        return CommonUtility.TrimNull(buyRegistId);
    }

    public String getZbranName() {
        return CommonUtility.TrimNull(zbranName);
    }

    public String getSosok1() {
        return CommonUtility.TrimNull(sosok1);
    }

    public String getSosok2() {
        return CommonUtility.TrimNull(sosok2);
    }

    public String getSosokHan() {
        return CommonUtility.TrimNull(sosokHan);
    }

    public String getName() {
        return CommonUtility.TrimNull(name);
    }

    public String getAspIssueId() {
        return CommonUtility.TrimNull(aspIssueId);
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

    public String getMailGubCode() {
        return CommonUtility.TrimNull(mailGubCode);
    }

    public String getMailStatusCode() {
        return CommonUtility.TrimNull(mailStatusCode);
    }

    public String getXmlIndividualKey() {
        return CommonUtility.TrimNull(xmlIndividualKey);
    }

    /** 20131109 당초세금계산서 승인번호 추가
     * @return the originIssueId
     */
    public String getOriginIssueId() {
        return CommonUtility.TrimNull(originIssueId);
    }

    public void setIoCode(String ioCode) {
        this.ioCode = ioCode;
    }

    public void setIssueDay(String issueDay) {
        this.issueDay = issueDay;
    }

    public void setBizManageId(String bizManageId) {
        this.bizManageId = bizManageId;
    }

    public void setSvcManageId(String svcManageId) {
        this.svcManageId = svcManageId;
    }

    public void setIssueDt(String issueDt) {
        this.issueDt = issueDt;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public void setBillTypeCode(String billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    public void setBillTypeCodeNm(String billTypeCodeNm) {
        this.billTypeCodeNm = billTypeCodeNm;
    }

    public void setPurposeCode(String purposeCode) {
        this.purposeCode = purposeCode;
    }

    public void setAmendmentCode(String amendmentCode) {
        this.amendmentCode = amendmentCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImportDocId(String importDocId) {
        this.importDocId = importDocId;
    }

    public void setImportPeriodStartDay(String importPeriodStartDay) {
        this.importPeriodStartDay = importPeriodStartDay;
    }

    public void setImportPeriodEndDay(String importPeriodEndDay) {
        this.importPeriodEndDay = importPeriodEndDay;
    }

    public void setImportItemQuantity(String importItemQuantity) {
        this.importItemQuantity = importItemQuantity;
    }

    public void setInvoicerPartyId(String invoicerPartyId) {
        this.invoicerPartyId = invoicerPartyId;
    }

    public void setInvoicerTaxRegistId(String invoicerTaxRegistId) {
        this.invoicerTaxRegistId = invoicerTaxRegistId;
    }

    public void setInvoicerPartyName(String invoicerPartyName) {
        this.invoicerPartyName = invoicerPartyName;
    }

    public void setInvoicerCeoName(String invoicerCeoName) {
        this.invoicerCeoName = invoicerCeoName;
    }

    public void setInvoicerAddr(String invoicerAddr) {
        this.invoicerAddr = invoicerAddr;
    }

    public void setInvoicerType(String invoicerType) {
        this.invoicerType = invoicerType;
    }

    public void setInvoicerClass(String invoicerClass) {
        this.invoicerClass = invoicerClass;
    }

    public void setInvoicerContactDepart(String invoicerContactDepart) {
        this.invoicerContactDepart = invoicerContactDepart;
    }

    public void setInvoicerContactName(String invoicerContactName) {
        this.invoicerContactName = invoicerContactName;
    }

    public void setInvoicerContactPhone(String invoicerContactPhone) {
        this.invoicerContactPhone = invoicerContactPhone;
    }

    public void setInvoicerContactEmail(String invoicerContactEmail) {
        this.invoicerContactEmail = invoicerContactEmail;
    }

    public void setInvoiceeBusinessTypeCode(String invoiceeBusinessTypeCode) {
        this.invoiceeBusinessTypeCode = invoiceeBusinessTypeCode;
    }

    public void setInvoiceePartyId(String invoiceePartyId) {
        this.invoiceePartyId = invoiceePartyId;
    }

    public void setInvoiceeTaxRegistId(String invoiceeTaxRegistId) {
        this.invoiceeTaxRegistId = invoiceeTaxRegistId;
    }

    public void setInvoiceePartyName(String invoiceePartyName) {
        this.invoiceePartyName = invoiceePartyName;
    }

    public void setInvoiceeCeoName(String invoiceeCeoName) {
        this.invoiceeCeoName = invoiceeCeoName;
    }

    public void setInvoiceeAddr(String invoiceeAddr) {
        this.invoiceeAddr = invoiceeAddr;
    }

    public void setInvoiceeType(String invoiceeType) {
        this.invoiceeType = invoiceeType;
    }

    public void setInvoiceeClass(String invoiceeClass) {
        this.invoiceeClass = invoiceeClass;
    }

    public void setInvoiceeContactDepart1(String invoiceeContactDepart1) {
        this.invoiceeContactDepart1 = invoiceeContactDepart1;
    }

    public void setInvoiceeContactName1(String invoiceeContactName1) {
        this.invoiceeContactName1 = invoiceeContactName1;
    }

    public void setInvoiceeContactPhone1(String invoiceeContactPhone1) {
        this.invoiceeContactPhone1 = invoiceeContactPhone1;
    }

    public void setInvoiceeContactEmail1(String invoiceeContactEmail1) {
        this.invoiceeContactEmail1 = invoiceeContactEmail1;
    }

    public void setInvoiceeContactDepart2(String invoiceeContactDepart2) {
        this.invoiceeContactDepart2 = invoiceeContactDepart2;
    }

    public void setInvoiceeContactName2(String invoiceeContactName2) {
        this.invoiceeContactName2 = invoiceeContactName2;
    }

    public void setInvoiceeContactPhone2(String invoiceeContactPhone2) {
        this.invoiceeContactPhone2 = invoiceeContactPhone2;
    }

    public void setInvoiceeContactEmail2(String invoiceeContactEmail2) {
        this.invoiceeContactEmail2 = invoiceeContactEmail2;
    }

    public void setBrokerPartyId(String brokerPartyId) {
        this.brokerPartyId = brokerPartyId;
    }

    public void setBrokerTaxRegistId(String brokerTaxRegistId) {
        this.brokerTaxRegistId = brokerTaxRegistId;
    }

    public void setBrokerPartyName(String brokerPartyName) {
        this.brokerPartyName = brokerPartyName;
    }

    public void setBrokerCeoName(String brokerCeoName) {
        this.brokerCeoName = brokerCeoName;
    }

    public void setBrokerAddr(String brokerAddr) {
        this.brokerAddr = brokerAddr;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    public void setBrokerClass(String brokerClass) {
        this.brokerClass = brokerClass;
    }

    public void setBrokerContactDepart(String brokerContactDepart) {
        this.brokerContactDepart = brokerContactDepart;
    }

    public void setBrokerContactName(String brokerContactName) {
        this.brokerContactName = brokerContactName;
    }

    public void setBrokerContactPhone(String brokerContactPhone) {
        this.brokerContactPhone = brokerContactPhone;
    }

    public void setBrokerContactEmail(String brokerContactEmail) {
        this.brokerContactEmail = brokerContactEmail;
    }

    public void setPaymentTypeCode1(String paymentTypeCode1) {
        this.paymentTypeCode1 = paymentTypeCode1;
    }

    public void setPayAmount1(String payAmount1) {
        this.payAmount1 = payAmount1;
    }

    public void setPaymentTypeCode2(String paymentTypeCode2) {
        this.paymentTypeCode2 = paymentTypeCode2;
    }

    public void setPayAmount2(String payAmount2) {
        this.payAmount2 = payAmount2;
    }

    public void setPaymentTypeCode3(String paymentTypeCode3) {
        this.paymentTypeCode3 = paymentTypeCode3;
    }

    public void setPayAmount3(String payAmount3) {
        this.payAmount3 = payAmount3;
    }

    public void setPaymentTypeCode4(String paymentTypeCode4) {
        this.paymentTypeCode4 = paymentTypeCode4;
    }

    public void setPayAmount4(String payAmount4) {
        this.payAmount4 = payAmount4;
    }

    public void setChargeTotalAmount(String chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public void setTaxTotalAmount(String taxTotalAmount) {
        this.taxTotalAmount = taxTotalAmount;
    }

    public void setGrandTotalAmount(String grandTotalAmount) {
        this.grandTotalAmount = grandTotalAmount;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusCodeNm(String statusCodeNm) {
        this.statusCodeNm = statusCodeNm;
    }

    public void setRelSystemId(String relSystemId) {
        this.relSystemId = relSystemId;
    }

    public void setJobGubCode(String jobGubCode) {
        this.jobGubCode = jobGubCode;
    }

    public void setElectronicReportYn(String electronicReportYn) {
        this.electronicReportYn = electronicReportYn;
    }

    public void setAddTaxYn(String addTaxYn) {
        this.addTaxYn = addTaxYn;
    }

    public void setRegistDt(String registDt) {
        this.registDt = registDt;
    }

    public void setModifyDt(String modifyDt) {
        this.modifyDt = modifyDt;
    }

    public void setRegistId(String registId) {
        this.registId = registId;
    }

    public void setModifyId(String modifyId) {
        this.modifyId = modifyId;
    }

    public void setOnlineGubCode(String onlineGubCode) {
        this.onlineGubCode = onlineGubCode;
    }

    public void setOnlineGubCodeNm(String onlineGubCodeNm) {
        this.onlineGubCodeNm = onlineGubCodeNm;
    }

    public void setInvoiceeGubCode(String invoiceeGubCode) {
        this.invoiceeGubCode = invoiceeGubCode;
    }

    public void setUpperManageId(String upperManageId) {
        this.upperManageId = upperManageId;
    }

    public void setErpSndYn(String erpSndYn) {
        this.erpSndYn = erpSndYn;
    }

    public void setErpAccYear(String erpAccYear) {
        this.erpAccYear = erpAccYear;
    }

    public void setErpSlipNo(String erpSlipNo) {
        this.erpSlipNo = erpSlipNo;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public void setTaxTypeCodeNm(String taxTypeCodeNm) {
        this.taxTypeCodeNm = taxTypeCodeNm;
    }

    public void setTaxCancelData(String taxCancelData) {
        this.taxCancelData = taxCancelData;
    }

    public void setErpSendCode(String erpSendCode) {
        this.erpSendCode = erpSendCode;
    }

    public void setVatGubCode(String vatGubCode) {
        this.vatGubCode = vatGubCode;
    }

    public void setReceiptGubCode(String receiptGubCode) {
        this.receiptGubCode = receiptGubCode;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setGrandTotalAmountSum(String grandTotalAmountSum) {
        this.grandTotalAmountSum = grandTotalAmountSum;
    }

    public void setChargeTotalAmountSum(String chargeTotalAmountSum) {
        this.chargeTotalAmountSum = chargeTotalAmountSum;
    }

    public void setTaxTotalAmountSum(String taxTotalAmountSum) {
        this.taxTotalAmountSum = taxTotalAmountSum;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public void setBillYyyymm(String billYyyymm) {
        this.billYyyymm = billYyyymm;
    }

    public void setBillIssueYyyymm(String billIssueYyyymm) {
        this.billIssueYyyymm = billIssueYyyymm;
    }

    public void setPayDeadline(String payDeadline) {
        this.payDeadline = payDeadline;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }

    public void setCancelDt(String cancelDt) {
        this.cancelDt = cancelDt;
    }

    public void setEaiStat(String eaiStat) {
        this.eaiStat = eaiStat;
    }

    public void setEaiCdate(String eaiCdate) {
        this.eaiCdate = eaiCdate;
    }

    public void setEaiUdate(String eaiUdate) {
        this.eaiUdate = eaiUdate;
    }

    public void setBelnr(String belnr) {
        this.belnr = belnr;
    }

    public void setProcDay(String procDay) {
        this.procDay = procDay;
    }

    public void setZbranCode(String zbranCode) {
        this.zbranCode = zbranCode;
    }

    public void setZbranCodeHigh(String zbranCodeHigh) {
        this.zbranCodeHigh = zbranCodeHigh;
    }

    public void setBuyRegistId(String buyRegistId) {
        this.buyRegistId = buyRegistId;
    }

    public void setZbranName(String zbranName) {
        this.zbranName = zbranName;
    }

    public void setSosok1(String sosok1) {
        this.sosok1 = sosok1;
    }

    public void setSosok2(String sosok2) {
        this.sosok2 = sosok2;
    }

    public void setSosokHan(String sosokHan) {
        this.sosokHan = sosokHan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAspIssueId(String aspIssueId) {
        this.aspIssueId = aspIssueId;
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

    public void setMailGubCode(String mailGubCode) {
        this.mailGubCode = mailGubCode;
    }

    public void setMailStatusCode(String mailStatusCode) {
        this.mailStatusCode = mailStatusCode;
    }

    public void setXmlIndividualKey(String xmlIndividualKey) {
        this.xmlIndividualKey = xmlIndividualKey;
    }

    public String getOri_issue_day() {
        return ori_issue_day;
    }

    public void setOri_issue_day(String oriIssueDay) {
        ori_issue_day = oriIssueDay;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    /** 20131109 당초세금계산서 승인번호 추가
     * @param originIssueId the originIssueId to set
     */
    public void setOriginIssueId(String originIssueId) {
        this.originIssueId = originIssueId;
    }
}
