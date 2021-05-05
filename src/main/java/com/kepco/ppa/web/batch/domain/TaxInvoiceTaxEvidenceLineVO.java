package com.kepco.ppa.web.batch.domain;

import com.kepco.ppa.web.common.CommonUtility;
import com.kepco.ppa.web.common.Paging;
import java.io.Serializable;

public class TaxInvoiceTaxEvidenceLineVO extends Paging implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 322671997675165323L;

    private String uuid;
    private String lineNum;
    private String transDate;
    private String id;
    private String classId;
    private String name;
    private String defineTxt;
    private String lineDesc;
    private String quantity;
    private String subTotQuantity;
    private String basisAmt;
    private String currencyCode;
    private String amt;
    private String subTotAmt;
    private String taxAmt;
    private String taxSubTotAmt;
    private String fornChargeAmt;
    private String fornChargeSubTotAmt;
    private String exchangeCurrencyRate;

    private String itemMon;
    private String itemDay;

    public String getUuid() {
        return CommonUtility.TrimNull(uuid);
    }

    public String getLineNum() {
        return CommonUtility.TrimNull(lineNum);
    }

    public String getTransDate() {
        return CommonUtility.TrimNull(transDate);
    }

    public String getId() {
        return CommonUtility.TrimNull(id);
    }

    public String getClassId() {
        return CommonUtility.TrimNull(classId);
    }

    public String getName() {
        return CommonUtility.TrimNull(name);
    }

    public String getDefineTxt() {
        return CommonUtility.TrimNull(defineTxt);
    }

    public String getLineDesc() {
        return CommonUtility.TrimNull(lineDesc);
    }

    public String getQuantity() {
        return CommonUtility.TrimNull(quantity);
    }

    public String getSubTotQuantity() {
        return CommonUtility.TrimNull(subTotQuantity);
    }

    public String getBasisAmt() {
        return CommonUtility.TrimNull(basisAmt);
    }

    public String getCurrencyCode() {
        return CommonUtility.TrimNull(currencyCode);
    }

    public String getAmt() {
        return CommonUtility.TrimNull(amt);
    }

    public String getSubTotAmt() {
        return CommonUtility.TrimNull(subTotAmt);
    }

    public String getTaxAmt() {
        return CommonUtility.TrimNull(taxAmt);
    }

    public String getTaxSubTotAmt() {
        return CommonUtility.TrimNull(taxSubTotAmt);
    }

    public String getFornChargeAmt() {
        return CommonUtility.TrimNull(fornChargeAmt);
    }

    public String getFornChargeSubTotAmt() {
        return CommonUtility.TrimNull(fornChargeSubTotAmt);
    }

    public String getExchangeCurrencyRate() {
        return CommonUtility.TrimNull(exchangeCurrencyRate);
    }

    public String getItemMon() {
        return CommonUtility.TrimNull(itemMon);
    }

    public String getItemDay() {
        return CommonUtility.TrimNull(itemDay);
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefineTxt(String defineTxt) {
        this.defineTxt = defineTxt;
    }

    public void setLineDesc(String lineDesc) {
        this.lineDesc = lineDesc;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setSubTotQuantity(String subTotQuantity) {
        this.subTotQuantity = subTotQuantity;
    }

    public void setBasisAmt(String basisAmt) {
        this.basisAmt = basisAmt;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public void setSubTotAmt(String subTotAmt) {
        this.subTotAmt = subTotAmt;
    }

    public void setTaxAmt(String taxAmt) {
        this.taxAmt = taxAmt;
    }

    public void setTaxSubTotAmt(String taxSubTotAmt) {
        this.taxSubTotAmt = taxSubTotAmt;
    }

    public void setFornChargeAmt(String fornChargeAmt) {
        this.fornChargeAmt = fornChargeAmt;
    }

    public void setFornChargeSubTotAmt(String fornChargeSubTotAmt) {
        this.fornChargeSubTotAmt = fornChargeSubTotAmt;
    }

    public void setExchangeCurrencyRate(String exchangeCurrencyRate) {
        this.exchangeCurrencyRate = exchangeCurrencyRate;
    }

    public void setItemMon(String itemMon) {
        this.itemMon = itemMon;
    }

    public void setItemDay(String itemDay) {
        this.itemDay = itemDay;
    }
}
