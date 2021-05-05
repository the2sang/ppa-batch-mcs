package com.kepco.ppa.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class BizNoEncrypt {

    /**
     * <PRE>
     * 지정된 위치(/{WEB-ROOT}/WEB-INF/classes)의 properties파일을 읽어 key에 대한 value리턴
     *
     * </PRE>
     * @return  String Value
     */
    public static String getString(String key) {
        Properties props = null;
        //InputStream  in = null;
        FileInputStream in = null;
        String strReturn = "";

        /**
         * 프로퍼티 파일명
         */
        final String CONFIG_FILE = "ap.property";
        //		final String CONFIG_FILE = "kr/co/kepco/etax30/selling/util/ap.property";

        try {
            //File f = new File(CommProperties.class.getResource(CONFIG_FILE).getPath());
            File f = new File("/data5/ebxml/kepcobill2/kepcobill2/WEB-INF/batch/ap.property");
            //File f = new File("C:/ap.property");
            //System.out.println(CommProperties.class.getResource(CONFIG_FILE).getPath());
            in = new FileInputStream(f);
        } catch (Exception e) {
            System.out.println(CONFIG_FILE + " 화일이 없습니다.");
            e.printStackTrace();
        }

        if (in == null) {
            System.out.println(CONFIG_FILE + " 화일이 없습니다.");
            return strReturn;
        } else {
            try {
                props = new Properties();
                props.load(in);

                strReturn = props.getProperty(key);
            } catch (IOException ioe) {
                System.out.println("Exception 발생(CommProperties.java) : " + ioe.getMessage());
                ioe.printStackTrace();
            } finally {
                try {
                    if (in != null) in.close();
                } catch (Exception e) {
                    System.out.println("[CommProperties.java] 스트림 해제 에러");
                    e.printStackTrace();
                }
            }
            return strReturn;
        }
    }

    public String key = getString("AES_KEY4MAIL");

    public String encrypt(String message) throws Exception {
        System.out.println("1=======[encrypt_JUMIN]:>::" + message);
        String encrypted = "";

        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            //encrypted = new BASE64Encoder().encode(cipher.doFinal(message.getBytes()));
            encrypted = Base64.encodeBase64String(cipher.doFinal(message.getBytes()));

            System.out.println("2=======[encrypt_JUMIN]:>::" + encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public String decrypt(String encrypted) throws Exception {
        String originalString = "";
        System.out.println("1=======[decrypt_JUMIN]:>::" + encrypted);
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            //byte[] original = cipher.doFinal(new BASE64Decoder().decodeBuffer(encrypted));
            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            originalString = new String(original);
            System.out.println("2=======[decrypt_JUMIN]:>::" + originalString);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return originalString;
    }
}
