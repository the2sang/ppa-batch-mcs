package com.kepco.ppa.web.batch.listener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

/**
 * @author Michael Minella
 */
@Slf4j
public class LoggingStepStartStopListener {

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        log.info(stepExecution.getStepName() + " has begun!");
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        StringBuffer message = new StringBuffer();
        String startFormatDate = "";
        String endFormatDate = "";

        if (stepExecution.getStartTime() != null && stepExecution.getEndTime() != null) {
            startFormatDate = dtFormat.format(stepExecution.getStartTime());
            endFormatDate = dtFormat.format(stepExecution.getEndTime());
            message.append(stepExecution.getStepName() + " - StartTime:" + startFormatDate + " / EndTime:" + endFormatDate);
        }

        message.append("  Step Status:" + stepExecution.getStatus());
        message.append("  readData:" + stepExecution.getReadCount());

        log.info("Step Information - " + message.toString());

        log.info(stepExecution.getStepName() + " has ended!");

        return stepExecution.getExitStatus();
    }
}
