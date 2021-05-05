package com.kepco.ppa.web.batch.domain;

import java.sql.Date;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TbStatusHistVO {

    private String ioCode;
    private String issueDay;
    private String bizManageId;
    private int seqNo;
    private String avlEndDt;
    private String avlBeginDt;
    private String statusCode;
    private Date registDt;
    private String registId;
    private String statusDesc;
}
