package com.kepco.ppa.web.batch.domain;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbTradeItemListVO {

    private String ioCode;
    private String issueDay;
    private String bizManageId;
    private int seqNo;
    private String purchaseDay;
    private String itemName;
    private String itemInfo;
    private String itemDesc;
    private long unitQuantity;
    private long unitAmount;
    private long invoiceAmount;
    private long taxAmount;
}
