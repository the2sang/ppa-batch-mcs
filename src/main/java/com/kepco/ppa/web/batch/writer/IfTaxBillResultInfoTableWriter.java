package com.kepco.ppa.web.batch.writer;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IfTaxBillResultInfoTableWriter {

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        sb.append(
            "\n   INSERT INTO KEY_POWEREDI.IF_TAX_BILL_RESULT_INFO (REL_SYSTEM_ID, JOB_GUB_CODE, MANAGE_ID, STATUS_CODE, STATUS_DESC"
        );
        sb.append("\n , REGIST_DT, MODIFY_DT, ISSUE_ID, EAI_STAT, EAI_CDATE");
        sb.append("\n , EAI_UDATE, TAX_CANCEL_DATA )");
        sb.append("\n   SELECT REL_SYSTEM_ID");
        sb.append("\n      , JOB_GUB_CODE");
        sb.append("\n      , SVC_MANAGE_ID MANAGE_ID");
        sb.append("\n      , STATUS_CODE");
        sb.append("\n      , GET_CODE_NAME('STATUS_CODE',STATUS_CODE) STATUS_DESC");
        sb.append("\n      , SYSDATE REGIST_DT");
        sb.append("\n      , SYSDATE MODIFY_DT");
        sb.append("\n      , ISSUE_ID");
        sb.append("\n      , '' EAI_STAT");
        sb.append("\n      , '' EAI_CDATE");
        sb.append("\n      , '' EAI_UDATE");
        sb.append("\n      , TAX_CANCEL_DATA");
        sb.append("\n   FROM EXEDI.TB_TAX_BILL_INFO");
        sb.append("\n  WHERE IO_CODE = ?");
        sb.append("\n    AND ISSUE_DAY = ?");
        sb.append("\n    AND BIZ_MANAGE_ID = ?");

        return sb.toString();
    }
}
