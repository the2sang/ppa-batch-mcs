package com.kepco.ppa.web.config;

import static org.quartz.CronScheduleBuilder.cronSchedule;

import com.kepco.ppa.web.quartz.QuartzJobLauncher;
import java.io.IOException;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
@Slf4j
public class QuartzConfig {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobLocator jobLocator;

    @Value("${cronExpression}")
    private String cronExpression;

    @Value("${quartz_run}")
    private String quartzRun;

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor(JobRegistry jobRegistry) {
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);

        return jobRegistryBeanPostProcessor;
    }

    @Bean
    public JobDetail jobDetail() {
        //Set Job data map
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("jobName", "ppaBatchJob");

        return JobBuilder.newJob(QuartzJobLauncher.class).withIdentity("job", null).setJobData(jobDataMap).storeDurably().build();
    }

    @Bean
    public Trigger jobTrigger() {
        return TriggerBuilder
            .newTrigger()
            .forJob(jobDetail())
            .withIdentity("jobTrigger", null)
            .withSchedule(cronSchedule(cronExpression))
            .build();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException, SchedulerException {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(jobTrigger());
        scheduler.setQuartzProperties(quartzProperties());
        scheduler.setJobDetails(jobDetail());
        scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        return scheduler;
    }

    public Properties quartzProperties() throws IOException {
        String quartzRunBase = this.quartzRun;
        String classPathResourceValue = "/config/application-dev.yml"; //Default dev

        if (quartzRunBase != null && quartzRunBase.equals("dev")) {
            classPathResourceValue = "/config/application-dev.yml";
        } else if (quartzRunBase != null && quartzRunBase.equals("prod")) {
            classPathResourceValue = "/config/application-prod.yml";
        }

        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(classPathResourceValue));
        //propertiesFactoryBean.setLocation(new ClassPathResource("/config/application-prod.yml"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
}
