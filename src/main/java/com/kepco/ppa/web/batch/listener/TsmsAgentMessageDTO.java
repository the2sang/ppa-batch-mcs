package com.kepco.ppa.web.batch.listener;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TsmsAgentMessageDTO implements Serializable {

    //    private Long id;

    private Long messageSeqno;

    private Long serviceSeqno;

    private String sendMessage;

    private String subject;

    private String backupMessage;

    private String backupProcessCode;

    private String messageType;

    private String contentsType;

    private String receiveMobileNo;

    private String callbackNo;

    private String jobType;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private String sendReserveDate;

    private String templateCode;

    private String mmsImgPath1;

    private String mmsImgPath2;

    private String mmsImgPath3;

    private String imgAttachFlag;

    private String kkoBtnName;

    private String kkoBtnUrl;

    private String kkoBtnLink1;

    private String kkoBtnLink2;

    private String kkoBtnLink3;

    private String kkoBtnLink4;

    private String kkoBtnLink5;

    private String kkoImgPath;

    private String kkoImgLinkUrl;

    private String taxLevel1Nm;

    private String taxLevel2Nm;

    private String registerBy;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private String registerDate;

    private String custBackupFlag;

    private String custMessageType;

    private LocalDate custBackupDate;

    private String custData1;

    private String custData2;

    private String custData3;

    private String custData4;

    private String custData5;

    private String custData6;

    private String custData7;

    private String custData8;

    private String custData9;

    private String custData10;

    private String sendFlag;

    private LocalDate sendDate;

    private String resendFlag;

    private String mmsImgServerPath1;

    private String mmsImgServerPath2;

    private String mmsImgServerPath3;

    private LocalDate imgSendDate;

    private LocalDate updateDate;

    private String updateBy;

    private String kkoImgServerPath;

    private String intfNm;

    private String sendedId;

    //    public Long getId() {
    //        return id;
    //    }
    //
    //    public void setId(Long id) {
    //        this.id = id;
    //    }

    public Long getMessageSeqno() {
        return messageSeqno;
    }

    public void setMessageSeqno(Long messageSeqno) {
        this.messageSeqno = messageSeqno;
    }

    public Long getServiceSeqno() {
        return serviceSeqno;
    }

    public void setServiceSeqno(Long serviceSeqno) {
        this.serviceSeqno = serviceSeqno;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBackupMessage() {
        return backupMessage;
    }

    public void setBackupMessage(String backupMessage) {
        this.backupMessage = backupMessage;
    }

    public String getBackupProcessCode() {
        return backupProcessCode;
    }

    public void setBackupProcessCode(String backupProcessCode) {
        this.backupProcessCode = backupProcessCode;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getContentsType() {
        return contentsType;
    }

    public void setContentsType(String contentsType) {
        this.contentsType = contentsType;
    }

    public String getReceiveMobileNo() {
        return receiveMobileNo;
    }

    public void setReceiveMobileNo(String receiveMobileNo) {
        this.receiveMobileNo = receiveMobileNo;
    }

    public String getCallbackNo() {
        return callbackNo;
    }

    public void setCallbackNo(String callbackNo) {
        this.callbackNo = callbackNo;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSendReserveDate() {
        return sendReserveDate;
    }

    public void setSendReserveDate(String sendReserveDate) {
        this.sendReserveDate = sendReserveDate;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getMmsImgPath1() {
        return mmsImgPath1;
    }

    public void setMmsImgPath1(String mmsImgPath1) {
        this.mmsImgPath1 = mmsImgPath1;
    }

    public String getMmsImgPath2() {
        return mmsImgPath2;
    }

    public void setMmsImgPath2(String mmsImgPath2) {
        this.mmsImgPath2 = mmsImgPath2;
    }

    public String getMmsImgPath3() {
        return mmsImgPath3;
    }

    public void setMmsImgPath3(String mmsImgPath3) {
        this.mmsImgPath3 = mmsImgPath3;
    }

    public String getImgAttachFlag() {
        return imgAttachFlag;
    }

    public void setImgAttachFlag(String imgAttachFlag) {
        this.imgAttachFlag = imgAttachFlag;
    }

    public String getKkoBtnName() {
        return kkoBtnName;
    }

    public void setKkoBtnName(String kkoBtnName) {
        this.kkoBtnName = kkoBtnName;
    }

    public String getKkoBtnUrl() {
        return kkoBtnUrl;
    }

    public void setKkoBtnUrl(String kkoBtnUrl) {
        this.kkoBtnUrl = kkoBtnUrl;
    }

    public String getKkoBtnLink1() {
        return kkoBtnLink1;
    }

    public void setKkoBtnLink1(String kkoBtnLink1) {
        this.kkoBtnLink1 = kkoBtnLink1;
    }

    public String getKkoBtnLink2() {
        return kkoBtnLink2;
    }

    public void setKkoBtnLink2(String kkoBtnLink2) {
        this.kkoBtnLink2 = kkoBtnLink2;
    }

    public String getKkoBtnLink3() {
        return kkoBtnLink3;
    }

    public void setKkoBtnLink3(String kkoBtnLink3) {
        this.kkoBtnLink3 = kkoBtnLink3;
    }

    public String getKkoBtnLink4() {
        return kkoBtnLink4;
    }

    public void setKkoBtnLink4(String kkoBtnLink4) {
        this.kkoBtnLink4 = kkoBtnLink4;
    }

    public String getKkoBtnLink5() {
        return kkoBtnLink5;
    }

    public void setKkoBtnLink5(String kkoBtnLink5) {
        this.kkoBtnLink5 = kkoBtnLink5;
    }

    public String getKkoImgPath() {
        return kkoImgPath;
    }

    public void setKkoImgPath(String kkoImgPath) {
        this.kkoImgPath = kkoImgPath;
    }

    public String getKkoImgLinkUrl() {
        return kkoImgLinkUrl;
    }

    public void setKkoImgLinkUrl(String kkoImgLinkUrl) {
        this.kkoImgLinkUrl = kkoImgLinkUrl;
    }

    public String getTaxLevel1Nm() {
        return taxLevel1Nm;
    }

    public void setTaxLevel1Nm(String taxLevel1Nm) {
        this.taxLevel1Nm = taxLevel1Nm;
    }

    public String getTaxLevel2Nm() {
        return taxLevel2Nm;
    }

    public void setTaxLevel2Nm(String taxLevel2Nm) {
        this.taxLevel2Nm = taxLevel2Nm;
    }

    public String getRegisterBy() {
        return registerBy;
    }

    public void setRegisterBy(String registerBy) {
        this.registerBy = registerBy;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getCustBackupFlag() {
        return custBackupFlag;
    }

    public void setCustBackupFlag(String custBackupFlag) {
        this.custBackupFlag = custBackupFlag;
    }

    public String getCustMessageType() {
        return custMessageType;
    }

    public void setCustMessageType(String custMessageType) {
        this.custMessageType = custMessageType;
    }

    public LocalDate getCustBackupDate() {
        return custBackupDate;
    }

    public void setCustBackupDate(LocalDate custBackupDate) {
        this.custBackupDate = custBackupDate;
    }

    public String getCustData1() {
        return custData1;
    }

    public void setCustData1(String custData1) {
        this.custData1 = custData1;
    }

    public String getCustData2() {
        return custData2;
    }

    public void setCustData2(String custData2) {
        this.custData2 = custData2;
    }

    public String getCustData3() {
        return custData3;
    }

    public void setCustData3(String custData3) {
        this.custData3 = custData3;
    }

    public String getCustData4() {
        return custData4;
    }

    public void setCustData4(String custData4) {
        this.custData4 = custData4;
    }

    public String getCustData5() {
        return custData5;
    }

    public void setCustData5(String custData5) {
        this.custData5 = custData5;
    }

    public String getCustData6() {
        return custData6;
    }

    public void setCustData6(String custData6) {
        this.custData6 = custData6;
    }

    public String getCustData7() {
        return custData7;
    }

    public void setCustData7(String custData7) {
        this.custData7 = custData7;
    }

    public String getCustData8() {
        return custData8;
    }

    public void setCustData8(String custData8) {
        this.custData8 = custData8;
    }

    public String getCustData9() {
        return custData9;
    }

    public void setCustData9(String custData9) {
        this.custData9 = custData9;
    }

    public String getCustData10() {
        return custData10;
    }

    public void setCustData10(String custData10) {
        this.custData10 = custData10;
    }

    public String getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(String sendFlag) {
        this.sendFlag = sendFlag;
    }

    public LocalDate getSendDate() {
        return sendDate;
    }

    public void setSendDate(LocalDate sendDate) {
        this.sendDate = sendDate;
    }

    public String getResendFlag() {
        return resendFlag;
    }

    public void setResendFlag(String resendFlag) {
        this.resendFlag = resendFlag;
    }

    public String getMmsImgServerPath1() {
        return mmsImgServerPath1;
    }

    public void setMmsImgServerPath1(String mmsImgServerPath1) {
        this.mmsImgServerPath1 = mmsImgServerPath1;
    }

    public String getMmsImgServerPath2() {
        return mmsImgServerPath2;
    }

    public void setMmsImgServerPath2(String mmsImgServerPath2) {
        this.mmsImgServerPath2 = mmsImgServerPath2;
    }

    public String getMmsImgServerPath3() {
        return mmsImgServerPath3;
    }

    public void setMmsImgServerPath3(String mmsImgServerPath3) {
        this.mmsImgServerPath3 = mmsImgServerPath3;
    }

    public LocalDate getImgSendDate() {
        return imgSendDate;
    }

    public void setImgSendDate(LocalDate imgSendDate) {
        this.imgSendDate = imgSendDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getKkoImgServerPath() {
        return kkoImgServerPath;
    }

    public void setKkoImgServerPath(String kkoImgServerPath) {
        this.kkoImgServerPath = kkoImgServerPath;
    }

    public String getIntfNm() {
        return intfNm;
    }

    public void setIntfNm(String intfNm) {
        this.intfNm = intfNm;
    }

    public String getSendedId() {
        return sendedId;
    }

    public void setSendedId(String sendedId) {
        this.sendedId = sendedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TsmsAgentMessageDTO)) {
            return false;
        }

        TsmsAgentMessageDTO tsmsAgentMessageDTO = (TsmsAgentMessageDTO) o;
        if (this.messageSeqno == null) {
            return false;
        }
        return Objects.equals(this.messageSeqno, tsmsAgentMessageDTO.messageSeqno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.messageSeqno);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TsmsAgentMessageDTO{" +
//            "id=" + getId() +
            ", messageSeqno=" + getMessageSeqno() +
            ", serviceSeqno=" + getServiceSeqno() +
            ", sendMessage='" + getSendMessage() + "'" +
            ", subject='" + getSubject() + "'" +
            ", backupMessage='" + getBackupMessage() + "'" +
            ", backupProcessCode='" + getBackupProcessCode() + "'" +
            ", messageType='" + getMessageType() + "'" +
            ", contentsType='" + getContentsType() + "'" +
            ", receiveMobileNo='" + getReceiveMobileNo() + "'" +
            ", callbackNo='" + getCallbackNo() + "'" +
            ", jobType='" + getJobType() + "'" +
            ", sendReserveDate='" + getSendReserveDate() + "'" +
            ", templateCode='" + getTemplateCode() + "'" +
            ", mmsImgPath1='" + getMmsImgPath1() + "'" +
            ", mmsImgPath2='" + getMmsImgPath2() + "'" +
            ", mmsImgPath3='" + getMmsImgPath3() + "'" +
            ", imgAttachFlag='" + getImgAttachFlag() + "'" +
            ", kkoBtnName='" + getKkoBtnName() + "'" +
            ", kkoBtnUrl='" + getKkoBtnUrl() + "'" +
            ", kkoBtnLink1='" + getKkoBtnLink1() + "'" +
            ", kkoBtnLink2='" + getKkoBtnLink2() + "'" +
            ", kkoBtnLink3='" + getKkoBtnLink3() + "'" +
            ", kkoBtnLink4='" + getKkoBtnLink4() + "'" +
            ", kkoBtnLink5='" + getKkoBtnLink5() + "'" +
            ", kkoImgPath='" + getKkoImgPath() + "'" +
            ", kkoImgLinkUrl='" + getKkoImgLinkUrl() + "'" +
            ", taxLevel1Nm='" + getTaxLevel1Nm() + "'" +
            ", taxLevel2Nm='" + getTaxLevel2Nm() + "'" +
            ", registerBy='" + getRegisterBy() + "'" +
            ", registerDate='" + getRegisterDate() + "'" +
            ", custBackupFlag='" + getCustBackupFlag() + "'" +
            ", custMessageType='" + getCustMessageType() + "'" +
            ", custBackupDate='" + getCustBackupDate() + "'" +
            ", custData1='" + getCustData1() + "'" +
            ", custData2='" + getCustData2() + "'" +
            ", custData3='" + getCustData3() + "'" +
            ", custData4='" + getCustData4() + "'" +
            ", custData5='" + getCustData5() + "'" +
            ", custData6='" + getCustData6() + "'" +
            ", custData7='" + getCustData7() + "'" +
            ", custData8='" + getCustData8() + "'" +
            ", custData9='" + getCustData9() + "'" +
            ", custData10='" + getCustData10() + "'" +
            ", sendFlag='" + getSendFlag() + "'" +
            ", sendDate='" + getSendDate() + "'" +
            ", resendFlag='" + getResendFlag() + "'" +
            ", mmsImgServerPath1='" + getMmsImgServerPath1() + "'" +
            ", mmsImgServerPath2='" + getMmsImgServerPath2() + "'" +
            ", mmsImgServerPath3='" + getMmsImgServerPath3() + "'" +
            ", imgSendDate='" + getImgSendDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", updateBy='" + getUpdateBy() + "'" +
            ", kkoImgServerPath='" + getKkoImgServerPath() + "'" +
            ", intfNm='" + getIntfNm() + "'" +
            ", sendedId='" + getSendedId() + "'" +
            "}";
    }
}
