package com.kepco.ppa.web.common;

//import org.apache.log4j.Logger;

public class Env {

    /*
     * 한전 정보
     */
    public static final String KEPCO_BIZ_NO = "1208200052";
    public static final String PARTY_ID = KEPCO_BIZ_NO;
    public static final String PARTY_NAME = "한국전력공사";
    public static final String CEO_NAME = "조환익";

    public static final String ADDR = "서울 강남구 삼성동 167번지";
    public static final String TYPE = "전기가스소매부";
    public static final String CLASS = "전기발전공급잡화임대";

    /*
     * log4j 설정
     */
    //    final public static Logger sysLogger = Logger.getLogger("sysLog");
    //    final public static Logger queryLogger = Logger.getLogger("queryLog");
    //    final public static Logger errorLogger = Logger.getLogger("errorLog");

    /*
     * 중복체크 코드
     */
    public static final String STANDARD_INFO_GROUP = "STANDARD_INFO_GROUP";
    public static final String STANDARD_INFO_ITEM = "STANDARD_INFO_ITEM";

    /*
     * 중복체크 메시지
     */
    public static final String OVERLAP_MSG_RESULT_D = "중복확인";
    public static final String OVERLAP_MSG_RESULT_Y = "<font color=\"#0000FF\">사용가능</font>";
    public static final String OVERLAP_MSG_RESULT_N = "<font color=\"#FF0000\">사용불가능</font>";

    /*
     * 디비 앨리어스
     */

    //    final public static String DB1 = "EXEDITEST.";
    //    final public static String DB2 = "EXEDI2TEST.";
    //    final public static String DB3 = "EXEDI3TEST.";
    //    final public static String DB4 = "KEY_POWEREDITEST.";
    //    final public static String DB5 = "EXEDIOFFTEST.";

    /*
     * 거래처 검증 결과 메시지
     */
    public static final String BIZ_ID_VERIFY_RESULT_01 = "<p style=\"color:#0000FF;font-size:30pt;font-weight:bold;\">정상</p>";
    public static final String BIZ_ID_VERIFY_RESULT_02 = "<p style=\"color:#0000FF;font-size:30pt;font-weight:bold;\">미등록</p>";
    public static final String BIZ_ID_VERIFY_RESULT_10 = "<p style=\"color:#0000FF;font-size:30pt;font-weight:bold;\">폐업</p>";
    public static final String BIZ_ID_VERIFY_RESULT_20 = "<p style=\"color:#0000FF;font-size:30pt;font-weight:bold;\">휴업</p>";
    public static final String BIZ_ID_VERIFY_RESULT_90 = "<p style=\"color:#0000FF;font-size:30pt;font-weight:bold;\">비정상</p>";
    public static final String BIZ_ID_VERIFY_RESULT_DEFAULT = "공급받는자 등록번호를 입력한 후 거래처 검증 버튼을 클릭하세요.";

    //final public static String UPLOAD_PATH = "D:/TAX/bill/WebContent/kepcobill2/kepcobill3/file";
    public static final String UPLOAD_PATH = "/data5/ebxml/kepcobill2/kepcobill2/kepcobill3/files";
    public static final int LIMIT_SIZE = 50 * 1024 * 1024; //업로드파일크기제한

    /*
     * 정보인증
     * 2012. 1. 12  by mopium -----------
     */
    public static final String KICA_SECU_FILES = "/data5/ebxml/xmledi/xmledi/WEB-INF/key/secu.cfg";
}
