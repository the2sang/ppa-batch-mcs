package com.kepco.ppa.web.batch.domain;

import com.kepco.ppa.web.common.Paging;
import java.io.Serializable;
import java.util.ArrayList;

public class TaxSaleTaxInvoiceMgrVO extends Paging implements Serializable {

    private static final long serialVersionUID = -463090816958054609L;

    private TaxSaleTaxInvoiceInfoVO info;
    private ArrayList itemList;

    private TaxInvoiceTaxEvidenceMetaVO meta;
    private TaxInvoiceTaxEvidenceMainVO main;
    private ArrayList lineList;

    // 2021.03 신규 추가
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public TaxSaleTaxInvoiceMgrVO() {
        this.info = new TaxSaleTaxInvoiceInfoVO();
        this.itemList = new ArrayList();
        this.meta = new TaxInvoiceTaxEvidenceMetaVO();
        this.main = new TaxInvoiceTaxEvidenceMainVO();
        this.lineList = new ArrayList();
    }

    public TaxSaleTaxInvoiceInfoVO getInfo() {
        return info;
    }

    public ArrayList getItemList() {
        return itemList;
    }

    public TaxInvoiceTaxEvidenceMetaVO getMeta() {
        return meta;
    }

    public TaxInvoiceTaxEvidenceMainVO getMain() {
        return main;
    }

    public ArrayList getLineList() {
        return lineList;
    }

    public void setInfo(TaxSaleTaxInvoiceInfoVO info) {
        this.info = info;
    }

    public void setItemList(ArrayList itemList) {
        this.itemList = itemList;
    }

    public void setMeta(TaxInvoiceTaxEvidenceMetaVO meta) {
        this.meta = meta;
    }

    public void setMain(TaxInvoiceTaxEvidenceMainVO main) {
        this.main = main;
    }

    public void setLineList(ArrayList lineList) {
        this.lineList = lineList;
    }
}
