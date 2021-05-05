package com.kepco.ppa.web.batch.domain;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EtsTaxLineInfoTbVO {

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
}
