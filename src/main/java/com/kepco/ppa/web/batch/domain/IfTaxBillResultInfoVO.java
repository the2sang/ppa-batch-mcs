package com.kepco.ppa.web.batch.domain;

import java.sql.Date;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IfTaxBillResultInfoVO {

    private String relSystemId;
    private String jobGubCode;
    private String manageId;
    private String statusCode;
    private String statusDesc;
    private Date registDt;
    private Date modifyDt;
    private String issueId;
    private String eaiStat;
    private String eaiCdate;
    private String eaiUdate;
    private String taxCancelData;
    private String eseroCreateTs;
    private String eseroFinishTs;
}
