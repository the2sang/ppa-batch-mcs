package com.kepco.ppa.web.batch.domain;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IfTaxBillItemListVO {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;
    private long seqNo;
    private String purchaseDay;
    private String itemName;
    private String itemInfo;
    private String itemDesc;
    private double unitQuantity;
    private double unitAmount;
    private long invoiceAmount;
    private long taxAmount;
    private String billIssueYyyymm;
}
