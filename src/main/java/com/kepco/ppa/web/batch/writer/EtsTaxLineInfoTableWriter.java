package com.kepco.ppa.web.batch.writer;

import javax.sql.DataSource;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public class EtsTaxLineInfoTableWriter {

    @Autowired
    @Setter
    private DataSource dataSource;

    public String getWriteSQL() {
        StringBuffer sb = new StringBuffer();

        //2017 0525  수정 유종일
        //sb.append("\n MERGE INTO ETS_TAX_LINE_INFO_TB");
        //sb.append("\n USING ( SELECT COUNT(*) CNT");
        //sb.append("\n           FROM ETS_TAX_LINE_INFO_TB");
        //sb.append("\n          WHERE UUID = ?) T");
        //sb.append("\n    ON (T.CNT > 0)");

        sb.append("\n MERGE INTO EXEDI.ETS_TAX_LINE_INFO_TB BAT");
        sb.append("\n USING ( SELECT ? UUID, ? LINE_NUM FROM DUAL ) T");
        sb.append("\n    ON (BAT.UUID = T.UUID AND BAT.LINE_NUM = T.LINE_NUM )");
        sb.append("\n  WHEN MATCHED THEN");
        sb.append("\n        UPDATE SET");
        sb.append("\n               TRANS_DATE = TRIM(?)");
        sb.append("\n             , ID = TRIM(?)");
        sb.append("\n             , CLASS_ID = TRIM(?)");
        sb.append("\n             , NAME = TRIM(?)");
        sb.append("\n             , DEFINE_TXT = TRIM(?)");
        sb.append("\n             , LINE_DESC = TRIM(?)");
        sb.append("\n             , QUANTITY = TRIM(?)");
        sb.append("\n             , SUB_TOT_QUANTITY = TRIM(?)");
        sb.append("\n             , BASIS_AMT = TRIM(?)");
        sb.append("\n             , CURRENCY_CODE = TRIM(?)");
        sb.append("\n             , AMT = TRIM(?)");
        sb.append("\n             , SUB_TOT_AMT = TRIM(?)");
        sb.append("\n             , TAX_AMT = TRIM(?)");
        sb.append("\n             , TAX_SUB_TOT_AMT = TRIM(?)");
        sb.append("\n             , FORN_CHARGE_AMT = TRIM(?)");
        sb.append("\n             , FORN_CHARGE_SUB_TOT_AMT = TRIM(?)");
        sb.append("\n             , EXCHANGE_CURRENCY_RATE = TRIM(?)");
        //20170525 수정 유종일
        //sb.append("\n         WHERE UUID = ?");
        sb.append("\n  WHEN NOT MATCHED THEN");
        sb.append("\n        INSERT(UUID, LINE_NUM, TRANS_DATE, ID, CLASS_ID");
        sb.append("\n             , NAME, DEFINE_TXT, LINE_DESC, QUANTITY, SUB_TOT_QUANTITY");
        sb.append("\n             , BASIS_AMT, CURRENCY_CODE, AMT, SUB_TOT_AMT, TAX_AMT");
        sb.append("\n             , TAX_SUB_TOT_AMT, FORN_CHARGE_AMT, FORN_CHARGE_SUB_TOT_AMT, EXCHANGE_CURRENCY_RATE)");
        sb.append("\n        VALUES(TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?), TRIM(?)");
        sb.append("\n             , TRIM(?), TRIM(?), TRIM(?), TRIM(?))");

        return sb.toString();
    }
}
