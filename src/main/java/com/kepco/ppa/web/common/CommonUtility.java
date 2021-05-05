package com.kepco.ppa.web.common;

import java.io.File;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class CommonUtility {

    public static final String EMPTY_STRING = "";
    public static final String dateStr = ".";

    /**
     * null -> ""
     * @param str
     * @return
     */
    public static String TrimNull(String str) {
        String returnStr = null;

        if (str == null || str.equals("null")) {
            returnStr = "";
        } else {
            returnStr = str.trim();
        }

        return returnStr;
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof String) && (((String) obj).trim().length() == 0)) {
            return true;
        }
        if (obj instanceof Map) {
            return ((Map<?, ?>) obj).isEmpty();
        }
        if (obj instanceof List) {
            return ((List<?>) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return (((Object[]) obj).length == 0);
        }

        return false;
    }

    public static String NotTrimNull(String str) {
        String returnStr = null;

        if (str == null || str.equals("null")) {
            returnStr = "";
        } else {
            returnStr = str;
        }

        return returnStr;
    }

    public static String ChangeStr(String val, String str) {
        String returnStr = null;

        if (val == null || val.equals("null") || val.equals("")) {
            returnStr = str;
        } else {
            returnStr = val.trim();
        }

        return returnStr;
    }

    /**
     *
     * @param str
     * @param str1
     * @return
     */
    public static String TrimNullInitStr(String str, String str1) {
        String returnStr = null;

        if (str == null || str.equals("null") || str.trim().equals("")) {
            returnStr = str1.trim();
        } else {
            returnStr = str.trim();
        }

        return returnStr;
    }

    /**
     *
     * @param str
     * @param str1
     * @param str2
     * @return
     */
    public static String TrimNullReplace(String str, String str1, String str2) {
        String returnStr = null;

        if (str == null || str.equals("null") || str.equals("")) {
            returnStr = "";
        } else {
            returnStr = str.trim().replaceAll(str1, str2);
        }

        return returnStr;
    }

    /**
     * @param NullString
     * @return
     */
    public static String NotCommaNull(String NullString) {
        String ReturnString = "";

        try {
            if (NullString == null || NullString.equals("null")) {
                ReturnString = "";
            } else {
                ReturnString = NullString.replaceAll(",", "");
            }
        } catch (Exception e) {}

        return ReturnString;
    }

    public static String trimDate(String NullString) {
        String ReturnString = "";

        try {
            if (NullString == null || NullString.equals("null")) {
                ReturnString = "";
            } else {
                ReturnString = NullString.replaceAll("\\.", "");
            }
        } catch (Exception e) {}

        return ReturnString;
    }

    /**
     * "" -> &nbsp;
     * @param str
     * @return
     */
    public static String TrimNbsp(String str) {
        String returnStr = null;

        if (str == null || str.equals("null") || str.equals("")) {
            returnStr = "&nbsp;";
        } else {
            returnStr = str.trim();
        }

        return returnStr;
    }

    /**
     * yyyymmdd -> yyyy.mm.dd
     * @param dateString
     * @return
     */
    public static String getFormatDate422(String dateString, String gubun) {
        String dateFormat422 = "";

        try {
            if (dateString.length() < 8) {
                dateFormat422 = dateString;
            } else {
                dateFormat422 = dateString.substring(0, 4) + gubun + dateString.substring(4, 6) + gubun + dateString.substring(6, 8);
            }
        } catch (Exception e) {}

        return dateFormat422;
    }

    /**
     * yyyymmdd -> yyyy.mm.dd
     * @param dateString
     * @return
     */
    public static String getFormatDateTime(String dateString, String gubun) {
        String dateFormat422 = "";

        try {
            if (dateString.length() < 12) {
                dateFormat422 = dateString;
            } else {
                dateFormat422 =
                    dateString.substring(0, 4) +
                    gubun +
                    dateString.substring(4, 6) +
                    gubun +
                    dateString.substring(6, 8) +
                    " " +
                    dateString.substring(8, 10) +
                    ":" +
                    dateString.substring(10, 12) +
                    ":" +
                    dateString.substring(12, 14);
            }
        } catch (Exception e) {}

        return dateFormat422;
    }

    /**
     * yyyymmdd -> yyyy년mm월dd일
     * @param dateString
     * @return
     */
    public static String getFormatDate(String dateString) {
        String dateFormat422 = "";

        try {
            if (dateString.length() < 8) {
                dateFormat422 = dateString;
            } else {
                dateFormat422 = dateString.substring(0, 4) + "년" + dateString.substring(4, 6) + "월" + dateString.substring(6, 8) + "일";
            }
        } catch (Exception e) {}

        return dateFormat422;
    }

    /**
     * yyyymm -> yyyy.mm
     * @param dateString
     * @return
     */
    public static String getFormatDate42(String dateString, String gubun) {
        String dateFormat42 = "";

        try {
            if (dateString.length() < 4) {
                dateFormat42 = dateString;
            } else {
                dateFormat42 = dateString.substring(0, 4) + gubun + dateString.substring(4, 6);
            }
        } catch (Exception e) {}

        return dateFormat42;
    }

    /**
     * 현재 yyyy
     * @return
     */
    public static String getYYYY() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue = Integer.toString(cal.get(Calendar.YEAR));
        return strTValue;
    }

    /**
     * 현재 mm
     * @return
     */
    public static String getMM() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue +=
            (cal.get(Calendar.MONTH) + 1 >= 10) ? Integer.toString(cal.get(Calendar.MONTH) + 1) : "0" + (cal.get(Calendar.MONTH) + 1);
        return strTValue;
    }

    /**
     * 현재 dd
     * @return
     */
    public static String getDD() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue += (cal.get(Calendar.DATE) >= 10) ? Integer.toString(cal.get(Calendar.DATE)) : "0" + (cal.get(Calendar.DATE));
        return strTValue;
    }

    /**
     * 현재 yyyymm
     * @return
     */
    public static String getYYYYMM() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue = Integer.toString(cal.get(Calendar.YEAR));
        strTValue +=
            (cal.get(Calendar.MONTH) + 1 >= 10) ? Integer.toString(cal.get(Calendar.MONTH) + 1) : "0" + (cal.get(Calendar.MONTH) + 1);
        return strTValue;
    }

    /**
     * 현재 yyyymmdd
     * @return
     */
    public static String getYYYYMMDD() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue = Integer.toString(cal.get(Calendar.YEAR));
        strTValue +=
            (cal.get(Calendar.MONTH) + 1 >= 10) ? Integer.toString(cal.get(Calendar.MONTH) + 1) : "0" + (cal.get(Calendar.MONTH) + 1);
        strTValue += (cal.get(Calendar.DATE) >= 10) ? Integer.toString(cal.get(Calendar.DATE)) : "0" + (cal.get(Calendar.DATE));
        return strTValue;
    }

    /**
     * 현재 yyyymmddHHMMSS
     * @return
     */
    public static String getYYYYMMDDTIME() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        strTValue = Integer.toString(cal.get(Calendar.YEAR));
        strTValue +=
            (cal.get(Calendar.MONTH) + 1 >= 10) ? Integer.toString(cal.get(Calendar.MONTH) + 1) : "0" + (cal.get(Calendar.MONTH) + 1);
        strTValue += (cal.get(Calendar.DATE) >= 10) ? Integer.toString(cal.get(Calendar.DATE)) : "0" + (cal.get(Calendar.DATE));
        strTValue +=
            (cal.get(Calendar.HOUR_OF_DAY) >= 10) ? Integer.toString(cal.get(Calendar.HOUR_OF_DAY)) : "0" + (cal.get(Calendar.HOUR_OF_DAY));
        strTValue += (cal.get(Calendar.MINUTE) >= 10) ? Integer.toString(cal.get(Calendar.MINUTE)) : "0" + (cal.get(Calendar.MINUTE));
        strTValue += (cal.get(Calendar.SECOND) >= 10) ? Integer.toString(cal.get(Calendar.SECOND)) : "0" + (cal.get(Calendar.SECOND));
        return strTValue;
    }

    /**
     * 숫자에 콤마
     * @param i
     * @return
     */
    /*
	public static String commaformat(String str){

		NumberFormat oForm = NumberFormat.getInstance();

		if(!str.equals("")){
			int i = Integer.parseInt(str);

				//if(i != 0){
				str = oForm.format(i);
				//}
		}
		return str;
	}


	public static String commaformat1(String str){

		NumberFormat oForm = NumberFormat.getInstance();

		if(!str.equals("")){
			float i = Float.parseFloat(str);

				//if(i != 0){
				str = oForm.format(i);
				//}
		}
		return str;
	}
	*/

    /**
     * 3자리마다 , 붙이기(String 형)
     */
    public static String getComma(String str) {
        String flag = "N"; //소숫점 체크
        int iPos = 0;
        int p = 0;
        String retVal = "";

        if (str.equals("") || str == null || str.equals("null")) {
            retVal = "";
        } else {
            iPos = str.length();

            for (int i = 0; i < str.length(); i++) {
                if (str.substring(i, (i + 1)).equals(".")) {
                    //System.out.println(i+"번째 소수점 발생");
                    flag = "Y";
                    iPos = i;
                }
            }

            StringBuffer sb = new StringBuffer(str.substring(0, iPos).toString());
            StringBuffer rsb = new StringBuffer();
            StringBuffer sbf = new StringBuffer(str.substring(iPos, str.length()));
            sb = sb.reverse();

            for (int i = 0; i < iPos; i++) {
                p = i % 3;
                if (i > 0) if (p == 0 && !sb.substring(i, (i + 1)).equals("-")) rsb.append(",");
                rsb.append(sb.substring(i, (i + 1)));
            }

            retVal = (rsb.reverse()).toString();

            if (flag.equals("Y")) {
                retVal = retVal + sbf.toString();
            }
        }

        return retVal;
    }

    public static String addHtmlTag(String saStr) {
        String slRtnStr = saStr;
        slRtnStr = REPLACE(slRtnStr, "&lt;", "<");
        slRtnStr = REPLACE(slRtnStr, "&gt;", ">");
        slRtnStr = REPLACE(slRtnStr, "&amp;", "&");
        //추가
        slRtnStr = REPLACE(slRtnStr, "\n", "<BR>");
        slRtnStr = REPLACE(slRtnStr, " ", "&nbsp;");

        slRtnStr = REPLACE(slRtnStr, "\"", "&#34;");
        slRtnStr = REPLACE(slRtnStr, "'", "&#39;");
        slRtnStr = REPLACE(slRtnStr, "\\\"", "&quot;");
        return slRtnStr;
    }

    public static String addHtmlTag2(String saStr) {
        String slRtnStr = saStr;
        slRtnStr = slRtnStr.replaceAll("&lt;", "<");
        slRtnStr = slRtnStr.replaceAll("&gt;", ">");
        slRtnStr = slRtnStr.replaceAll("&amp;", "&");
        //추가
        slRtnStr = slRtnStr.replaceAll("\n", "<BR>");
        slRtnStr = slRtnStr.replaceAll(" ", "&nbsp;");

        slRtnStr = slRtnStr.replaceAll("\"", "&#34;");
        slRtnStr = slRtnStr.replaceAll("'", "&#39;");
        slRtnStr = REPLACE(slRtnStr, "\\\"", "&quot;");
        return slRtnStr;
    }

    /*
     * alditor 사용시
     */
    public static String addHtmlTag1(String saStr) {
        String slRtnStr = saStr;
        slRtnStr = REPLACE(slRtnStr, "&lt;", "<");
        slRtnStr = REPLACE(slRtnStr, "&gt;", ">");
        slRtnStr = REPLACE(slRtnStr, "&amp;", "&");
        //추가
        slRtnStr = REPLACE(slRtnStr, "\n", "<BR>");

        return slRtnStr;
    }

    public static String resultTag(String saStr) {
        String slRtnStr = saStr;

        //slRtnStr = REPLACE(slRtnStr, "(", "&lt;");
        //slRtnStr = REPLACE(slRtnStr, ")", "&gt;");
        slRtnStr = slRtnStr.replaceAll("\"", "");
        slRtnStr = slRtnStr.replaceAll("\\(", "<");
        slRtnStr = slRtnStr.replaceAll("\\)", ">");
        slRtnStr = slRtnStr.replaceAll("\n", "");
        return slRtnStr;
    }

    /**
     * src에서 str1와 str2를 REPLACE한다
     * @param src source string
     * @param str1 pattern string
     * @param str2 대치되어 들어갈 string
     * @return 변환된 String
     */
    public static String REPLACE(String src, String str1, String str2) {
        // argument가 null일 경우 EMPTY_STRING을 리턴
        if (src == null || str2 == null || str1 == null || src.equals("") || str1.equals("") || str2.equals("")) return EMPTY_STRING;
        // argument의 length가 0일 경우 EMPTY_STRING을 리턴
        if ((src.length() == 0) || (str1.length() == 0) || (str2.length() == 0)) return EMPTY_STRING;
        // 일치하는 패턴이 없을 경우 src를 그대로 return
        if (src.indexOf(str1) < 0) return src;
        StringBuffer buff = new StringBuffer(0);
        StringBuffer tmp = new StringBuffer(src);
        int idx = 0;
        int len = str1.length();

        while ((idx = tmp.toString().indexOf(str1)) > -1) {
            if (idx == 0) buff.append(str2); else {
                buff.append(tmp.substring(0, idx));
                buff.append(str2);
            }
            tmp = new StringBuffer(tmp.substring(idx + len));
        }
        buff.append(tmp);
        return buff.toString();
    }

    public static int NullToZero(String NullString) {
        int ReturnInt = 0;

        try {
            if (NullString == null || NullString.equals("null") || NullString.equals("")) {
                ReturnInt = 0;
            } else {
                ReturnInt = Integer.parseInt(NullString);
            }
        } catch (Exception e) {}

        return ReturnInt;
    }

    public static int NullToOne(String NullString) {
        int ReturnInt = 1;

        try {
            if (NullString == null || NullString.equals("null") || NullString.equals("")) {
                ReturnInt = 1;
            } else {
                ReturnInt = Integer.parseInt(NullString);
            }
        } catch (Exception e) {}

        return ReturnInt;
    }

    public static String NullToZeroStr(String NullString) {
        String ReturnStr = "0";

        try {
            if (NullString == null || NullString.equals("null") || NullString.equals("")) {
                ReturnStr = "0";
            } else {
                ReturnStr = NullString.trim();
            }
        } catch (Exception e) {}

        return ReturnStr;
    }

    public static String zeroToNull(String zero) {
        String returnStr = null;

        if (zero == null || zero.equals("null") || zero.equals("0")) {
            returnStr = "";
        } else {
            returnStr = zero.trim();
        }

        return returnStr;
    }

    public static double NullToZeroD(String str) {
        double returnVal = 0;

        try {
            if (str == null || str.equals("null") || str.equals("")) {
                returnVal = 0;
            } else {
                returnVal = Double.parseDouble(str);
            }
        } catch (Exception e) {}

        return returnVal;
    }

    public static long NullToZeroL(String str) {
        long returnVal = 0;

        try {
            if (str == null || str.equals("null") || str.equals("")) {
                returnVal = 0;
            } else {
                returnVal = Long.parseLong(str);
            }
        } catch (Exception e) {}

        return returnVal;
    }

    public static float NullToZeroF(String str) {
        float returnVal = 0;

        try {
            if (str == null || str.equals("null") || str.equals("")) {
                returnVal = 0;
            } else {
                returnVal = Float.parseFloat(str);
            }
        } catch (Exception e) {}

        return returnVal;
    }

    public static String substrParam(String value, int cut) {
        String str = "";
        if (value == null) value = "";
        int len = value.length();

        if (len != 0 && cut != 0 && len > cut) {
            str = value.substring(0, cut) + "..";
        } else {
            str = value;
        }

        return str;
    }

    public static String NULLC(String NullString) {
        String ReturnString = "";

        try {
            if (NullString == null || NullString.equals("null")) {
                ReturnString = "";
            } else {
                ReturnString = modifyStr(NullString);
            }
        } catch (Exception e) {}

        return ReturnString;
    }

    public static String modifyStr(String str) {
        if (str == null) {
            str = "";
        } else {
            str = str.replaceAll("\"", "&#34;");
            str = str.replaceAll("'", "&#39;");
        }
        return str;
    }

    //디렉토리만들기
    public static String Dir_Make(String dr_nm) {
        String strFiles = "";
        strFiles = Env.UPLOAD_PATH + "/" + dr_nm;

        File f1 = new File(strFiles);

        if (!f1.exists()) { // dr_nm
            f1.mkdirs();
        }

        return strFiles;
    }

    //디렉토리만들기
    public static String Dir_Make2(String strFiles) {
        File f1 = new File(strFiles);

        if (!f1.exists()) { // dr_nm
            f1.mkdirs();
        }

        return strFiles;
    }

    //디렉토리 or 하위디렉토리 모두 삭제

    public static void deleteSubFile(File file) {
        if (file.isDirectory()) {
            if (file.listFiles().length != 0) {
                File[] fileList = file.listFiles();

                for (int i = 0; i < fileList.length; i++) {
                    deleteSubFile(fileList[i]);
                    file.delete();
                }
            } else {
                file.delete();
            }
        } else {
            file.delete();
        }
    }

    /**
     * null -> ""
     * @param str
     * @return
     */
    public static String singleComma(String str) {
        String returnStr = null;

        if (str == null || str.equals("null")) {
            returnStr = "";
        } else {
            returnStr = str.trim().replaceAll("\'", "\'\'");
        }

        return returnStr;
    }

    public static String ReadClob(Reader input) {
        String retStr = "";
        StringBuffer output = new StringBuffer();
        char[] buffer = new char[1024];
        int byteRead = 0;
        try {
            while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
                output.append(buffer, 0, byteRead);
            }
            // contents -> CLOB 데이터가 저장될 String
        } catch (Exception e) {}

        return retStr = output.toString();
    }

    public static String getJuminAll(String str) {
        String retStr = NULLC(str).trim();
        if (str.length() == 13) {
            retStr = retStr.substring(0, 6) + "-" + retStr.substring(6, 13);
        }
        return retStr;
    }

    public static String getFormatTime(String str) {
        String retStr = "";

        try {
            if (str.length() < 4) {
                retStr = str;
            } else {
                retStr = str.substring(0, 2) + ":" + str.substring(2, 4);
            }
        } catch (Exception e) {}

        return retStr;
    }

    public static String substrParamNullc(String value, int cut) {
        String str = "&nbsp;";
        if (value == null) value = "";
        int len = value.length();

        if (len != 0 && cut != 0 && len > cut) {
            str = value.substring(0, cut);
            str = "<font title='" + value + "'>" + str + "...</font>";
        } else {
            str = value;
        }

        return str;
    }

    public static String substrParamNullc(String value, int cut, String flag) {
        String str = "&nbsp;";
        String altTag = "";

        if (value == null) value = "";
        int len = value.length();

        if (len != 0 && cut != 0 && len > cut) {
            str = value.substring(0, cut);

            if (flag.equals("1")) {
                altTag = "<span onmouseover=\"alt('" + value + "')\" onmouseout=\"alt()\">" + str + "...</span>";
            } else {
                altTag = str + "...";
            }
        } else {
            altTag = value;
        }

        return altTag;
    }

    public static String substrParamNullc(String value) {
        String altTag = "";

        altTag = "<span title=\"" + value + "\"><nobr>" + value + "</nobr></span>";

        return altTag;
    }

    public static String modifyReturn(String str) {
        if (str == null) {
            str = "";
        } else {
            str = str.replaceAll("\n", "<br>");
        }
        return str;
    }

    public static String viewStr(String str) {
        String returnStr = "&nbsp;";
        if (str == null || str.equals("null")) {
            returnStr = "";
        } else {
            returnStr = modifyReturn(modifyStr(str));
        }
        return returnStr;
    }

    public static String addZero(String str) {
        String returnStr = str;
        if (str == null || str.equals("null") || str.equals("")) {
            returnStr = "";
        } else {
            if (str.substring(0, 1).equals(".")) {
                returnStr = "0" + str;
            } else if (str.substring(0, 1).equals("-")) {
                if (str.length() > 1) {
                    if (str.substring(1, 2).equals(".")) {
                        returnStr = "-0" + str.substring(1);
                    }
                }
            }
        }
        return returnStr;
    }

    public static String NulltoSpace(String str) {
        String returnStr = str;

        if (str == null || str.equals("null") || str.equals("")) {
            returnStr = " ";
        }
        return returnStr;
    }

    public static float getUpRound(float param, int digit) {
        BigDecimal value = new BigDecimal("" + param);

        value = value.setScale(digit, BigDecimal.ROUND_HALF_UP);

        return value.floatValue();
    }

    public static float getDownRound(float param, int digit) {
        BigDecimal value = new BigDecimal("" + param);

        value = value.setScale(digit, BigDecimal.ROUND_DOWN);

        return value.floatValue();
    }

    public static String getMod(String str, int num) {
        System.out.println("str:" + str + ", num:" + num);
        String temp = "";
        if (str != null && !str.equals("")) {
            if (num == 0) {
                temp = "";
            } else {
                temp = Integer.toString(Integer.parseInt(str) / num);
            }
        }
        return getComma(temp);
    }

    public static String getQuarter() {
        Calendar cal = Calendar.getInstance();
        String strTValue = "";
        int thisMonth = cal.get(Calendar.MONTH) + 1;
        if (thisMonth <= 3) {
            strTValue += "1";
        } else if (thisMonth <= 6) {
            strTValue += "2";
        } else if (thisMonth <= 9) {
            strTValue += "3";
        } else {
            strTValue += "4";
        }
        return strTValue;
    }

    public static String getFormatBizId(String bizId) {
        String retBizId = "";

        try {
            if (bizId.length() < 10) {
                retBizId = bizId;
            } else {
                retBizId = bizId.substring(0, 3) + "-" + bizId.substring(3, 5) + "-" + bizId.substring(5, 10);
            }
        } catch (Exception e) {}

        return retBizId;
    }

    public static String getFormatMulti(String str) {
        //str.length : 10 - 사업자번호 XXX-XX-XXXXX
        //str.length : 13 - 주민번호, 외국인  XXXXXX-XXXXXXX

        String retStr = "";

        try {
            if (str.length() == 10) {
                retStr = str.substring(0, 3) + "-" + str.substring(3, 5) + "-" + str.substring(5, 10);
            } else if (str.length() == 13) {
                retStr = str.substring(0, 6) + "-*******";
            } else {
                retStr = str;
            }
        } catch (Exception e) {}

        return retStr;
    }

    /**
     * 수정일 경우 주민번호가 전부 출력
     * @param str
     * @return
     */
    public static String getFormatMulti2(String str) {
        //str.length : 10 - 사업자번호 XXX-XX-XXXXX
        //str.length : 13 - 주민번호, 외국인  XXXXXX-XXXXXXX

        String retStr = "";

        try {
            if (str.length() == 10) {
                retStr = str.substring(0, 3) + "-" + str.substring(3, 5) + "-" + str.substring(5, 10);
            } else if (str.length() == 13) {
                retStr = str.substring(0, 6) + "-" + str.substring(6, 13);
            } else {
                retStr = str;
            }
        } catch (Exception e) {}

        return retStr;
    }

    /**
     * 종사업장번호 변경(0000 -> "")
     * @param taxRegistId
     * @return
     */
    public static String getTaxRegistId(String taxRegistId) {
        String retVal = "";
        try {
            if (taxRegistId.equals("0000")) {
                retVal = "";
            } else {
                retVal = taxRegistId;
            }
        } catch (Exception e) {}

        return retVal;
    }

    // 20140416 공급자 종목(strClassificationCode)의 byte 크기를  지정된 값(limit)과 비교후 수정.
    public static String compareByte(String strClassificationCode, int limit, int toLength) { // limit 비교 길이값, toLength 자를 길이값
        int strClassificationCodeLength = strClassificationCode.getBytes().length;

        if (strClassificationCodeLength > limit) {
            String strClassificationCode_Copy = CommonUtility.cutStringByte(strClassificationCode, toLength);
            strClassificationCode_Copy = strClassificationCode_Copy + "..";
            strClassificationCode = strClassificationCode_Copy;
        }
        return strClassificationCode;
    }

    // 입력된 문자열(str)을 지정된  바이트 크기(limit)만큼 만  잘라서  문자열(cutStr)을 반환  2012.04.13 윤민호
    public static String cutStringByte(String str, int limit) {
        //String str=comp.getAddr();   //입력정보
        //int limit=145;               //Byte 제한

        String[] ary = null;
        String cutStr = "";

        try {
            byte[] rawBytes = str.getBytes("EUC-KR");
            int rawLength = rawBytes.length;

            int index = 0;
            int minus_byte_num = 0;
            int offset = 0;
            int hangul_byte_num = 2;

            if (rawLength > limit) {
                int aryLength = (rawLength / limit) + (rawLength % limit != 0 ? 1 : 0);
                ary = new String[aryLength];

                for (int i = 0; i < aryLength; i++) {
                    minus_byte_num = 0;
                    offset = limit;

                    if (index + offset > rawBytes.length) {
                        offset = rawBytes.length - index;
                    }

                    for (int j = 0; j < offset; j++) {
                        if (((int) rawBytes[index + j] & 0x80) != 0) {
                            minus_byte_num++;
                        }
                    } //for

                    if (minus_byte_num % hangul_byte_num != 0) {
                        offset -= minus_byte_num % hangul_byte_num;
                    }

                    ary[i] = new String(rawBytes, index, offset, "EUC-KR");
                    index += offset;
                } //aryLength for
            } else { //rawLength if
                ary = new String[] { str };
            }

            cutStr = ary[0];
        } catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }

        return cutStr;
    }
}
