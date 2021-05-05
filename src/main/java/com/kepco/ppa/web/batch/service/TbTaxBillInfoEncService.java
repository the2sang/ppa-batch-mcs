package com.kepco.ppa.web.batch.service;

import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import java.util.ArrayList;
import javax.sql.DataSource;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TbTaxBillInfoEncService {

    @Autowired
    @Setter
    private DataSource dataSource;

    public ArrayList<TbTaxBillInfoEncVO> getSelectENC(String issueId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);

        StringBuffer sb = new StringBuffer();

        sb.append("\n SELECT  IO_CODE, ISSUE_DAY, BIZ_MANAGE_ID, REL_SYSTEM_ID, JOB_GUB_CODE, UUID");
        sb.append("\n   FROM TB_TAX_BILL_INFO_ENC");
        sb.append("\n  WHERE ESERO_ISSUE_ID = '" + issueId + "'");

        return (ArrayList<TbTaxBillInfoEncVO>) jdbcTemplate.query(
            sb.toString(),
            new BeanPropertyRowMapper<TbTaxBillInfoEncVO>(TbTaxBillInfoEncVO.class)
        );
    }
}
