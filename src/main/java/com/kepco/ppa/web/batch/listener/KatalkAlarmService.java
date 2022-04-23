package com.kepco.ppa.web.batch.listener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;

public class KatalkAlarmService {

    public TsmsAgentMessageDTO makeReceiverDto(String phoneNumber, int count) {
        TsmsAgentMessageDTO dto = new TsmsAgentMessageDTO();
        dto.setServiceSeqno(1810013776L);
        dto.setSendMessage("PPA 배치처리 ERROR 발생:" + new Integer(count).toString());
        dto.setBackupMessage("PPA 배치처리 ERROR 발생:" + new Integer(count).toString());
        dto.setBackupProcessCode("000");
        dto.setMessageType("002");
        dto.setContentsType("004");
        dto.setReceiveMobileNo(phoneNumber);
        dto.setCallbackNo("123");
        dto.setJobType("R00");
        dto.setTemplateCode("[CRM]000001");
        dto.setRegisterBy("EDI OP");
        dto.setImgAttachFlag("N");
        dto.setCustData1("EDI-PPA");
        dto.setCustData2("EDI OP");
        dto.setCustData3("0910-7580");
        dto.setCustData4("073301");
        dto.setCustBackupFlag("N");
        dto.setCustMessageType("S");
        dto.setSendFlag("N");
        return dto;
    }

    public void setTsmsAgentMessageDTO(TsmsAgentMessageDTO tsmsAgentMessageDTO) {
        this.tsmsAgentMessageDTO = tsmsAgentMessageDTO;
    }

    private TsmsAgentMessageDTO tsmsAgentMessageDTO;
    //public static String TSMS_CREATE_CALL_URL = "http://localhost:9070/api/tsms-agent-messages";
    public static String TSMS_CREATE_CALL_URL = "http://168.78.201.129:9070/api/tsms-agent-messages";

    public KatalkAlarmService() {}

    public KatalkAlarmService(TsmsAgentMessageDTO tsmsAgentMessageDTO) {
        this.tsmsAgentMessageDTO = tsmsAgentMessageDTO;
    }

    public void post(String strUrl, TsmsAgentMessageDTO dto) throws JsonParseException {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
            con.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
            //con.addRequestProperty("x-api-key", RestTestCommon.API_KEY); //key값 설정

            con.setRequestMethod("POST");

            //json으로 message를 전달하고자 할 때
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoInput(true);
            con.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);

            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());

            ObjectMapper objectMapper = new ObjectMapper();

            String dtoJsonString = objectMapper.writeValueAsString(dto);

            wr.write(dtoJsonString); //json 형식의 message 전달
            wr.flush();

            StringBuilder sb = new StringBuilder();
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                System.out.println("" + sb.toString());
            } else {
                System.out.println(con.getResponseMessage());
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
