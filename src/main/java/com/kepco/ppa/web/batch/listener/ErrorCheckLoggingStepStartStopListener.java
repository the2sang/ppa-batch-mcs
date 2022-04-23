package com.kepco.ppa.web.batch.listener;

import com.fasterxml.jackson.core.JsonParseException;
import java.text.SimpleDateFormat;
import liquibase.pro.packaged.K;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Michael Minella
 */
@Slf4j
public class ErrorCheckLoggingStepStartStopListener {

    private String alarmReceiver;

    public ErrorCheckLoggingStepStartStopListener(String alarmReceiver) {
        this.alarmReceiver = alarmReceiver;
    }

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

        message.append("  Step Status(ErorCheckStep):" + stepExecution.getStatus());
        message.append("  readData(ErrorCount):" + stepExecution.getReadCount());

        try {
            if (stepExecution.getReadCount() > 0) {
                String[] phoneArray = alarmReceiver.split(",");

                for (int i = 0; i < phoneArray.length; i++) {
                    KatalkAlarmService alarmService = new KatalkAlarmService();
                    alarmService.post(
                        KatalkAlarmService.TSMS_CREATE_CALL_URL,
                        alarmService.makeReceiverDto(phoneArray[i], stepExecution.getReadCount())
                    );
                }
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        }

        log.info("Step Information - " + message.toString());

        log.info(stepExecution.getStepName() + " has ended!");

        return stepExecution.getExitStatus();
    }
}
