package com.kepco.ppa.web.batch.processor;

import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoVO;
import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.batch.service.TbTaxBillInfoEncInitial;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TbTaxBillInfoEncProcessor {

    @Bean
    public ItemProcessorAdapter<TaxEmailBillInfoVO, TbTaxBillInfoEncVO> itemProcessor(TbTaxBillInfoEncInitial service) {
        ItemProcessorAdapter<TaxEmailBillInfoVO, TbTaxBillInfoEncVO> adapter = new ItemProcessorAdapter<>();

        adapter.setTargetObject(service);
        adapter.setTargetMethod("tbTaxBillInfoEncInitialize");
        return adapter;
    }
}
