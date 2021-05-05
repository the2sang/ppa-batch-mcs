package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class TbStatusHistTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n MERGE INTO EXEDI.TB_STATUS_HIST A");
        sb.append("\n USING ( SELECT  ? IO_CODE , ? ISSUE_DAY, ? BIZ_MANAGE_ID");
        sb.append("\n   FROM DUAL ) B      ");
        sb.append("\n  ON (A.IO_CODE = B.IO_CODE AND A.ISSUE_DAY = B.ISSUE_DAY AND A.BIZ_MANAGE_ID = B.BIZ_MANAGE_ID ) ");
        sb.append("\n  WHEN MATCHED THEN ");
        sb.append(" \n UPDATE SET");
        sb.append(" \n        AVL_END_DT = TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')");
        sb.append(" \n      , STATUS_CODE = TRIM(?)");
        sb.append(" \n      , STATUS_DESC = GET_CODE_NAME('STATUS_CODE', TRIM(?))");
        sb.append(" \n  WHERE IO_CODE = ? ");
        sb.append(" \n    AND ISSUE_DAY = ? ");
        sb.append(" \n    AND BIZ_MANAGE_ID = ? ");
        sb.append(" \n    AND SEQ_NO = ? ");
        sb.append("\n  WHEN NOT MATCHED THEN");
        sb.append("\n INSERT");
        sb.append("\n           (");
        sb.append("\n             IO_CODE, ISSUE_DAY, BIZ_MANAGE_ID, SEQ_NO, AVL_END_DT");
        sb.append("\n           , AVL_BEGIN_DT, STATUS_CODE, REGIST_DT, REGIST_ID, STATUS_DESC");
        sb.append("\n           )");
        sb.append("\n      VALUES");
        sb.append("\n           (");
        sb.append("\n             TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?) ");
        sb.append("\n           , TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS'), TRIM(?), SYSDATE, TRIM(?), GET_CODE_NAME('STATUS_CODE', TRIM(?))");
        sb.append("\n           )");

        return sb.toString();
    }
}
