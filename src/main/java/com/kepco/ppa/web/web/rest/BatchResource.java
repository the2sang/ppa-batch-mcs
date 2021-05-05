package com.kepco.ppa.web.web.rest;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class BatchResource {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job ppaBatchJob;

//    @Autowired
//    JobRepository jobRepository;
//
//    public JobLauncher jobLauncher() throws Exception {
//        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//        jobLauncher.setJobRepository(jobRepository);
//        jobLauncher.afterPropertiesSet();
//        return jobLauncher;
//    }

    private JobParameters createInitialJobParameterMap(String batchIds) {
        Map<String, JobParameter> m = new HashMap<>();
        m.put("time", new JobParameter(System.currentTimeMillis()));
        m.put("batchIds", new JobParameter(batchIds));
        JobParameters p = new JobParameters(m);
        return p;
    }

    //배치 실행
    @GetMapping("/ppa-batch-starting/{batchIds}")
    @ResponseBody
    @CrossOrigin("*")
    public String startBatch(@PathVariable(value = "batchIds", required = true) final String batchIds)
        throws Exception {


        jobLauncher.run(ppaBatchJob, createInitialJobParameterMap(batchIds));
        return "startBatch";
    }
}
