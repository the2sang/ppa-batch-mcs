package com.kepco.ppa.web.web.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Getter
@NoArgsConstructor
@Setter
public class CreateBachIdsJobParameter {


    @Value("#{jobParameters[batchIds]}")
    private String batchIds;

    private String time;

    @Value("#{jobParameters[time]}") // (2)
    public void setTime(String time) {
        this.time = Long.toString(System.currentTimeMillis());
    }



}
