package com.kepco.ppa.web.batch.service;

import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoVO;
import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.common.CommonUtility;
import javax.sql.DataSource;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TbTaxBillInfoEncInitial {

    @Autowired
    @Setter
    private DataSource dataSource;

    public TbTaxBillInfoEncVO tbTaxBillInfoEncInitialize(TaxEmailBillInfoVO sourceVO) throws Exception {
        log.info("TEST-PPA MAIL: " + sourceVO.toString());

        String issueDay = sourceVO.getIssueDay();
        String jobGubCode = "275210"; // 275210: PPA세금계산서
        String relSystemId = "K1ERP11000"; //Default - K1ERP11000
        String bizManageId = getMakeBizManageId(relSystemId, jobGubCode);
        String svcManageId = getMakeSvcManageId(issueDay);
        String uuid = getMakePpaUuid();
        String issueId = getMakeIssueId(issueDay);
        String invoiceeTaxRegistId = CommonUtility.TrimNull(sourceVO.getInvoiceeTaxRegistId()); // 공급받는자 종사업장 번호

        //종사업장 번호의 길이가 4자가 안될경우 앞에 '0'을 길이만큼붙여준다.
        if (invoiceeTaxRegistId.length() > 0 && invoiceeTaxRegistId.length() < 5) {
            int temp_len = 4;
            temp_len = temp_len - invoiceeTaxRegistId.length();
            for (int temp_cnt = 0; temp_len > temp_cnt; temp_cnt++) {
                invoiceeTaxRegistId = "0" + invoiceeTaxRegistId;
            }
        }

        TbTaxBillInfoEncVO targetVO = new TbTaxBillInfoEncVO();

        targetVO.setIoCode("2"); // 1-매출, 2-매입
        targetVO.setIssueDay(CommonUtility.TrimNull(sourceVO.getIssueDay()));
        targetVO.setBizManageId(CommonUtility.TrimNull(bizManageId));
        targetVO.setSvcManageId(CommonUtility.TrimNull(svcManageId));
        targetVO.setIssueDt("");
        targetVO.setSignature("");
        targetVO.setIssueId(issueId);
        targetVO.setBillTypeCode(CommonUtility.TrimNull(sourceVO.getBillTypeCode()));
        targetVO.setPurposeCode(CommonUtility.TrimNull(sourceVO.getPurposeCode()));
        if ("02,04".indexOf(sourceVO.getBillTypeCode().substring(0, 2)) > -1) {
            targetVO.setAmendmentCode(CommonUtility.TrimNull(sourceVO.getAmendmentCode()));
        } else {
            targetVO.setAmendmentCode("");
        }
        targetVO.setDescription(CommonUtility.TrimNull(sourceVO.getDescription())); //비고
        targetVO.setImportDocId("");
        targetVO.setImportPeriodStartDay("");
        targetVO.setImportPeriodEndDay("");
        targetVO.setImportItemQuantity(0);
        targetVO.setInvoicerPartyId(CommonUtility.TrimNull(sourceVO.getInvoicerPartyId()).replaceAll("-", "")); //공급자 사업자번호
        targetVO.setInvoicerTaxRegistId(CommonUtility.TrimNull(sourceVO.getInvoicerTaxRegistId())); //공급자 종사업자 번호
        targetVO.setInvoicerPartyName(CommonUtility.TrimNull(sourceVO.getInvoicerPartyName())); //공급자 상호
        targetVO.setInvoicerCeoName(CommonUtility.TrimNull(sourceVO.getInvoicerCeoName())); //공급자 대표자
        targetVO.setInvoicerAddr(CommonUtility.cutStringByte(sourceVO.getInvoicerAddr(), 148)); //공급자  소재지
        targetVO.setInvoicerType(CommonUtility.TrimNull(CommonUtility.cutStringByte(sourceVO.getInvoicerType(), 38))); //공급자 업테
        targetVO.setInvoicerClass(CommonUtility.TrimNull(CommonUtility.cutStringByte(sourceVO.getInvoicerClass(), 38)));
        targetVO.setInvoicerContactDepart(""); //담당부서( 넘겨주는값 없음  )
        targetVO.setInvoicerContactName(CommonUtility.TrimNull(sourceVO.getInvoicerContactName()));
        if (!CommonUtility.isEmpty(sourceVO.getInvoicerContactPhone())) {
            targetVO.setInvoicerContactPhone(CommonUtility.TrimNull(sourceVO.getInvoicerContactPhone().replaceAll("-", "")));
        }
        targetVO.setInvoicerContactEmail(sourceVO.getInvoicerContactEmail()); //공급자 이메일
        targetVO.setInvoiceeBusinessTypeCode("01"); // 20121126 매입증빙 공급자 구분 . --> 공급받는자 구분값 01 고정.
        targetVO.setInvoiceePartyId(CommonUtility.TrimNull(sourceVO.getInvoiceePartyId()).replaceAll("-", ""));
        // 한전 종사업장 번호
        targetVO.setInvoiceeTaxRegistId(CommonUtility.getTaxRegistId(CommonUtility.TrimNull(invoiceeTaxRegistId))); //공급받는자 종사업장 번호
        targetVO.setInvoiceePartyName(CommonUtility.TrimNull(sourceVO.getInvoiceePartyName()));
        targetVO.setInvoiceeCeoName(CommonUtility.TrimNull(sourceVO.getInvoiceeCeoName()));

        String invoiceeAddr = CommonUtility.TrimNull(CommonUtility.cutStringByte(sourceVO.getInvoiceeAddr(), 148));

        if ("".equals(invoiceeAddr)) {
            invoiceeAddr = "BLANK";
        }

        targetVO.setInvoiceeAddr(invoiceeAddr);
        //-------------------
        targetVO.setInvoiceeType(CommonUtility.TrimNull(CommonUtility.cutStringByte(sourceVO.getInvoiceeType(), 38)));
        targetVO.setInvoiceeClass(CommonUtility.TrimNull(CommonUtility.cutStringByte(sourceVO.getInvoiceeClass(), 38))); //공급받는자 종목
        //######### 한전 정보 셋팅 ##############
        targetVO.setInvoiceeContactDepart1(""); //담당부서 (넘겨주는 값 없음)
        targetVO.setInvoiceeContactName1("BATCH");
        if (!CommonUtility.isEmpty(sourceVO.getInvoiceeContactPhone1())) {
            targetVO.setInvoiceeContactPhone1(CommonUtility.TrimNull(sourceVO.getInvoiceeContactPhone1().replaceAll("-", "")));
        }
        targetVO.setInvoiceeContactEmail1(sourceVO.getInvoiceeContactEmail1());
        targetVO.setInvoiceeContactDepart2(sourceVO.getInvoiceeContactDepart2());
        targetVO.setInvoiceeContactName2(sourceVO.getInvoiceeContactName2());
        targetVO.setInvoiceeContactPhone2(sourceVO.getInvoiceeContactPhone2());
        targetVO.setInvoiceeContactEmail2(sourceVO.getInvoiceeContactEmail2());
        //######### 한전 정보 셋팅 ##############
        //넘겨주는값 없음
        targetVO.setBrokerPartyId("");
        targetVO.setBrokerTaxRegistId("");
        targetVO.setBrokerPartyName("");
        targetVO.setBrokerCeoName("");
        targetVO.setBrokerAddr("");
        targetVO.setBrokerType("");
        targetVO.setBrokerClass("");
        targetVO.setBrokerContactDepart("");
        targetVO.setBrokerContactName("");
        targetVO.setBrokerContactPhone("");
        targetVO.setBrokerContactEmail("");
        if (!CommonUtility.isEmpty(sourceVO.getPaymentTypeCode1())) {
            targetVO.setPaymentTypeCode1(CommonUtility.TrimNull(sourceVO.getPaymentTypeCode1().equals("") ? "" : "10"));
        }
        targetVO.setPayAmount1(sourceVO.getPayAmount1());

        if (!CommonUtility.isEmpty(sourceVO.getPaymentTypeCode2())) {
            targetVO.setPaymentTypeCode2(CommonUtility.TrimNull(sourceVO.getPaymentTypeCode2().equals("") ? "" : "20"));
        }
        targetVO.setPayAmount2(sourceVO.getPayAmount2());

        if (!CommonUtility.isEmpty(sourceVO.getPaymentTypeCode3())) {
            targetVO.setPaymentTypeCode3(CommonUtility.TrimNull(sourceVO.getPaymentTypeCode3().equals("") ? "" : "30"));
        }
        targetVO.setPayAmount3(sourceVO.getPayAmount3());

        if (!CommonUtility.isEmpty(sourceVO.getPaymentTypeCode4())) {
            targetVO.setPaymentTypeCode4(CommonUtility.TrimNull(sourceVO.getPaymentTypeCode4().equals("") ? "" : "40"));
        }
        targetVO.setPayAmount4(sourceVO.getPayAmount4());
        targetVO.setChargeTotalAmount(sourceVO.getChargeTotalAmount());
        targetVO.setTaxTotalAmount(sourceVO.getTaxTotalAmount());
        targetVO.setGrandTotalAmount(sourceVO.getGrandTotalAmount());
        targetVO.setStatusCode("00");
        targetVO.setRelSystemId(CommonUtility.TrimNull(relSystemId));
        targetVO.setJobGubCode(CommonUtility.TrimNull(jobGubCode));
        targetVO.setElectronicReportYn("F"); // N:신고대상, Y:신고완료, F:미신고대상(미동의등)
        targetVO.setAddTaxYn("N"); //가산세 여부
        targetVO.setModifyId("");
        targetVO.setOnlineGubCode("1"); // 1:온라인, 2:오프라인, 3:영업온라인
        targetVO.setInvoiceeGubCode("00"); //매입만사용 00:한전, 기타:발전사
        targetVO.setUpperManageId("");
        targetVO.setErpSndYn("");
        targetVO.setErpAccYear("");
        targetVO.setErpSlipNo("");
        targetVO.setTaxTypeCode("12"); // 매일증빙 - ASP매입(개별메일)
        targetVO.setTaxCancelData("");
        targetVO.setErpSendCode("Y"); // Y:확인요청
        targetVO.setVatGubCode("V1"); // 매입세금계산서 - 일반매입
        targetVO.setReceiptGubCode("3"); // 1:인편, 2:우편, 3:이메일
        targetVO.setUuid(uuid);
        targetVO.setEseroIssueId(CommonUtility.TrimNull(sourceVO.getIssueId()));

        return targetVO;
    }

    public String getMakePpaUuid() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        StringBuffer sb = new StringBuffer();

        sb.append("\n SELECT '000000404' || LPAD(EXEDI.SQ_UUID.NEXTVAL, 7, 0) FROM DUAL");

        return jdbcTemplate.queryForObject(sb.toString(), String.class);
    }

    public String getMakeBizManageId(String relSystemId, String jobGubCode) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        //EDI -> BAT
        StringBuffer sb = new StringBuffer();
        sb.append(
            "\n SELECT TO_CHAR(SYSDATE,'YYYYMM') || '1' || NVL(SUBSTR('" +
            relSystemId +
            "', 1, 3), 'BAT') || '" +
            jobGubCode +
            "' || LPAD(EXEDI.SQ_MNG_ID.NEXTVAL, 8, 0) FROM DUAL"
        );

        return jdbcTemplate.queryForObject(sb.toString(), String.class);
    }

    public String getMakeSvcManageId(String issueDay) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        String svcManageId = null;
        String sosok2 = "1000"; //실제 웹 처리화면의 request의 sosok2 이름으로 가져오는 값을 확인해야함. request.getParameter("sosok2")
        String issueDay2 = issueDay.replaceAll("\\.", "");

        StringBuffer sb = new StringBuffer();
        sb.append("\n SELECT 'V' || '" + sosok2 + "' || SUBSTR('" + issueDay2 + "', 1, 6) || EXEDI.SQ_SVC_MANAGE_ID.NEXTVAL FROM DUAL");

        return jdbcTemplate.queryForObject(sb.toString(), String.class);
    }

    public String getMakeIssueId(String issueDay) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        String issueDay2 = issueDay.replaceAll("\\.", "");

        StringBuffer sb = new StringBuffer();

        sb.append("\n SELECT '" + issueDay2 + "' || 'ASP00000' || 't' || LPAD(EXEDI.SQ_ISSUE_ID.NEXTVAL, 7, 0) FROM DUAL");

        return jdbcTemplate.queryForObject(sb.toString(), String.class);
    }

    public String getStringParsing(String email, int start, int end) {
        return email.substring(start, end);
    }
}
