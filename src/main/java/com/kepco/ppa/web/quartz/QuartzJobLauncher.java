package com.kepco.ppa.web.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class QuartzJobLauncher extends QuartzJobBean {

    private String jobName;
    private JobLauncher jobLauncher;
    private JobLocator jobLocator;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public JobLocator getJobLocator() {
        return jobLocator;
    }

    public void setJobLocator(JobLocator jobLocator) {
        this.jobLocator = jobLocator;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();

        try {
            ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
            jobLocator = (JobLocator) applicationContext.getBean(JobLocator.class);
            jobLauncher = (JobLauncher) applicationContext.getBean(JobLauncher.class);
            Job job = jobLocator.getJob(jobName);
            JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
