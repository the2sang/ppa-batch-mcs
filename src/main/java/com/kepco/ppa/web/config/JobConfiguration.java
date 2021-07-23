package com.kepco.ppa.web.config;

import com.kepco.ppa.web.batch.domain.TaxEmailBillInfoVO;
import com.kepco.ppa.web.batch.domain.TaxEmailItemListVO;
import com.kepco.ppa.web.batch.domain.TbTaxBillInfoEncVO;
import com.kepco.ppa.web.batch.listener.ErrorCheckLoggingStepStartStopListener;
import com.kepco.ppa.web.batch.listener.JobLoggerListener;
import com.kepco.ppa.web.batch.listener.LoggingStepStartStopListener;
import com.kepco.ppa.web.batch.reader.TaxEmailBillInfoDataReader;
import com.kepco.ppa.web.batch.reader.TaxEmailBillInfoEncCheckReader;
import com.kepco.ppa.web.batch.reader.TaxEmailBillInfoMailStatusCode99Reader;
import com.kepco.ppa.web.batch.reader.TaxEmailItemListDataReader;
import com.kepco.ppa.web.batch.service.TbTaxBillInfoEncInitial;
import com.kepco.ppa.web.batch.writer.*;
import com.kepco.ppa.web.batch.writer.preparedStatmementSetter.*;
import com.kepco.ppa.web.common.YAMLConfig;
import com.kepco.ppa.web.web.rest.CreateBachIdsJobParameter;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.jsr.configuration.xml.JsrJobListenerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.adapter.ItemProcessorAdapter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcPagingItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Created By K.H.C (Hanjun KDN)
 * @since 2021.03.10
 * @version 1.0
 */

@RequiredArgsConstructor
@Slf4j
@EnableBatchProcessing
@Configuration
public class JobConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    JobExplorer jobExplorer;

    @Autowired
    @Qualifier("etaxdatasource")
    public DataSource etaxDataSource;

    @Autowired
    @Qualifier("exedidatasource")
    public DataSource exediDataSource;

    @Value("${DB_ENC}")
    private String dbencConfig;

    @Value("${katalkAlamReceiver}")
    private String alarmReceiver;

    @Autowired
    private CreateBachIdsJobParameter jobParameter;

    @Bean
    @JobScope // (2)
    public CreateBachIdsJobParameter jobParameter() {
        return new CreateBachIdsJobParameter();
    }

    @Bean
    public JobLauncher jobLauncher() throws Exception {
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(jobRepository);
        jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
        jobLauncher.afterPropertiesSet();
        return jobLauncher;
    }

    @Bean
    @StepScope
    public JdbcPagingItemReader<TaxEmailBillInfoVO> pagingTaxEmailBillInfoItemReader() {
        //log.info(">>>>>>>>>>> time={}, batchIds={}", jobParameter.getTime(), jobParameter.getBatchIds());

        Map<String, Object> params = new HashMap<>();
        params.put("time", jobParameter.getTime()); // (4)
        params.put("batchIds", jobParameter.getBatchIds());
        log.info(">>>>>>>>>>> time={}, batchIds={}", jobParameter.getTime(), jobParameter.getBatchIds());

        TaxEmailBillInfoDataReader dataReader = new TaxEmailBillInfoDataReader(jobParameter.getBatchIds());
        dataReader.setDataSource(this.etaxDataSource);

        return dataReader.getPagingReader();
    }

    @Bean
    @StepScope
    public JdbcPagingItemReader<TaxEmailBillInfoVO> pagingTaxEmailBillInfoEncCheckItemReader() {
        //log.info(">>>>>>>>>>> time={}, batchIds={}", jobParameter.getTime(), jobParameter.getBatchIds());

        Map<String, Object> params = new HashMap<>();
        params.put("time", jobParameter.getTime()); // (4)
        params.put("batchIds", jobParameter.getBatchIds());
        log.info(
            ">>>>>>>>>>> Step0 Enc Table ESERO_ISSUE_ID CHECK time={}, batchIds={}",
            jobParameter.getTime(),
            jobParameter.getBatchIds()
        );

        TaxEmailBillInfoEncCheckReader dataReader = new TaxEmailBillInfoEncCheckReader(jobParameter.getBatchIds());
        dataReader.setDataSource(this.etaxDataSource);

        return dataReader.getPagingReader();
    }

    @Bean
    @StepScope
    public JdbcPagingItemReader<TaxEmailBillInfoVO> pagingTaxEmailBillInfoMailStatusCodeCheckItemReader() {
        //log.info(">>>>>>>>>>> time={}, batchIds={}", jobParameter.getTime(), jobParameter.getBatchIds());

        Map<String, Object> params = new HashMap<>();
        params.put("time", jobParameter.getTime()); // (4)
        params.put("batchIds", jobParameter.getBatchIds());
        log.info(
            ">>>>>>>>>>> Step0 Enc Table Mail Status Code Check time={}, batchIds={}",
            jobParameter.getTime(),
            jobParameter.getBatchIds()
        );

        TaxEmailBillInfoMailStatusCode99Reader dataReader = new TaxEmailBillInfoMailStatusCode99Reader(jobParameter.getBatchIds());
        dataReader.setDataSource(this.etaxDataSource);

        return dataReader.getPagingReader();
    }

    @Bean
    @StepScope
    public JdbcPagingItemReader<TaxEmailItemListVO> pagingTaxEmailItemListItemReader() {
        TaxEmailItemListDataReader dataReader = new TaxEmailItemListDataReader();
        dataReader.setDataSource(this.etaxDataSource);

        return dataReader.getPagingReader();
    }

    ///////////////////////////////////////////////
    // TB_TAX_BILL_INFO_ENC
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> tbTaxBillInfoEncWriter() {
        TbTaxBillInfoEncTableWriter writer = new TbTaxBillInfoEncTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        System.out.println("DB_ENC:--------------------------------- " + dbencConfig);

        //

        if (dbencConfig == null) {
            dbencConfig = "1";
        }

        databaseItemWriter.setSql(writer.getWriteSQL(dbencConfig));

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new TbTaxBillInfoEncSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // IF_TAX_BILL_RESULT_INFO
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> ifTaxBillResultInfoWriter() {
        IfTaxBillResultInfoTableWriter writer = new IfTaxBillResultInfoTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new IfTaxBillResultInfoSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // TB_STATUS_HIST
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> tbStatusHistWriter() {
        TbStatusHistTableWriter writer = new TbStatusHistTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new TbStatusHistSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // ETS_TAX_META_INFO_TB
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> etsTaxMetaInfoTbWriter() {
        EtsTaxMetaInfoTableWriter writer = new EtsTaxMetaInfoTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new EtsTaxMetaInfoTbSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // ETS_TAX_MAIN_INFO_TB
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> etsTaxMainInfoTbWriter() {
        EtsTaxMainInfoTableWriter writer = new EtsTaxMainInfoTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new EtsTaxMainInfoTbSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // IF_TAX_BILL_INFO
    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> ifTaxBillInfoWriter() {
        IfTaxBillInfoTableWriter writer = new IfTaxBillInfoTableWriter();
        JdbcBatchItemWriter<TbTaxBillInfoEncVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TbTaxBillInfoEncVO> valueSetter = new IfTaxBillInfoSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    ///////////////////////////////////////////////
    // TB_TRADE_ITEM_LIST
    @Bean
    JdbcBatchItemWriter<TaxEmailItemListVO> tbTradeItemListWriter() {
        TbTradeItemListTableWriter writer = new TbTradeItemListTableWriter();
        JdbcBatchItemWriter<TaxEmailItemListVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TaxEmailItemListVO> valueSetter = new TbTradeItemListSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // ETS_TAX_LINE_INFO_TB
    @Bean
    JdbcBatchItemWriter<TaxEmailItemListVO> etsTaxLineInfoTbWriter() {
        EtsTaxLineInfoTableWriter writer = new EtsTaxLineInfoTableWriter();
        JdbcBatchItemWriter<TaxEmailItemListVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TaxEmailItemListVO> valueSetter = new EtsTaxLineInfoTbSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    // IF_TAX_BILL_ITEM_LIST
    @Bean
    JdbcBatchItemWriter<TaxEmailItemListVO> ifTaxBillItemListWriter() {
        IfTaxBillItemListTableWriter writer = new IfTaxBillItemListTableWriter();
        JdbcBatchItemWriter<TaxEmailItemListVO> databaseItemWriter = new JdbcBatchItemWriter<>();
        databaseItemWriter.setDataSource(this.exediDataSource);

        databaseItemWriter.setSql(writer.getWriteSQL());

        ItemPreparedStatementSetter<TaxEmailItemListVO> valueSetter = new IfTaxBillItemSetter(this.exediDataSource);
        databaseItemWriter.setItemPreparedStatementSetter(valueSetter);

        return databaseItemWriter;
    }

    ///////////////////////////////////////////////

    @Bean
    JdbcBatchItemWriter<TbTaxBillInfoEncVO> taxEmailBillInfoEndingUpdate() {
        return new JdbcBatchItemWriterBuilder<TbTaxBillInfoEncVO>()
            .dataSource(etaxDataSource)
            .beanMapped()
            .sql("UPDATE TAX_EMAIL_BILL_INFO SET MAIL_STATUS_CODE = '99' WHERE ISSUE_ID = :eseroIssueId")
            .build();
    }

    // 배치처리 스텝1 99에서 스탭2 01(배치 완료)로 변경되지 않고 남은 데이터에 대해 mail_status_code를 55로 변경하여 배치 제외
    @Bean
    JdbcBatchItemWriter<TaxEmailBillInfoVO> taxEmailBillInfoErrorCodeChangeUpdate() {
        return new JdbcBatchItemWriterBuilder<TaxEmailBillInfoVO>()
            .dataSource(etaxDataSource)
            .beanMapped()
            .sql("UPDATE TAX_EMAIL_BILL_INFO SET MAIL_STATUS_CODE = '55' WHERE MAIL_STATUS_CODE = :mailStatusCode")
            .build();
    }

    // TB_TAX_BILL_INFO_ENC 테이블에 ISERO_ISSUE_ID와 TAX_EMAIL_BILL_INFO ISSUE_ID 값이 같은 경우 배치처리에서 제외
    // 기존 수기로 등록하거나 봇에서 등록 처리한 건이 이메일로 다시 와서 중복 처리하는 경우를 방지함.
    @Bean
    JdbcBatchItemWriter<TaxEmailBillInfoVO> taxEmailBillInfoEncCheckUpdate() {
        return new JdbcBatchItemWriterBuilder<TaxEmailBillInfoVO>()
            .dataSource(etaxDataSource)
            .beanMapped()
            .sql("UPDATE TAX_EMAIL_BILL_INFO SET MAIL_STATUS_CODE = '88' WHERE ISSUE_ID = :issueId")
            .build();
    }

    @Bean
    JdbcBatchItemWriter<TaxEmailItemListVO> taxEmailItemListEndingUpdate() {
        return new JdbcBatchItemWriterBuilder<TaxEmailItemListVO>()
            .dataSource(etaxDataSource)
            .beanMapped()
            .sql("UPDATE TAX_EMAIL_BILL_INFO SET MAIL_STATUS_CODE = '01' WHERE ISSUE_ID = :issueId")
            .build();
    }

    @Bean
    JdbcBatchItemWriter<TaxEmailItemListVO> ppaBatchStatusInsert() {
        return new JdbcBatchItemWriterBuilder<TaxEmailItemListVO>()
            .dataSource(etaxDataSource)
            .beanMapped()
            .sql(
                "INSERT INTO PPA_BATCH_STATUS (ISSUE_ID, CREATED, STATUS) VALUES ( :issueId, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI'),  '1' )"
            )
            .build();
    }

    //PPA 배치 시작 전 이전 배치처리에서 99 에러 코드를 55로 변경 처리 및 기존 중복처리 코드 변경 88
    @Bean
    public CompositeItemWriter<TaxEmailBillInfoVO> compositeCheckWriter() {
        CompositeItemWriter<TaxEmailBillInfoVO> compositeItemWriter = new CompositeItemWriter<>();

        compositeItemWriter.setDelegates(Arrays.asList(taxEmailBillInfoErrorCodeChangeUpdate(), taxEmailBillInfoEncCheckUpdate()));

        return compositeItemWriter;
    }

    //PPA 배치처리를 위한 6개 테이블 Insert 및 Update
    @Bean
    public CompositeItemWriter<TbTaxBillInfoEncVO> compositeItemWriter() {
        CompositeItemWriter<TbTaxBillInfoEncVO> compositeItemWriter = new CompositeItemWriter<>();

        compositeItemWriter.setDelegates(
            Arrays.asList(
                tbTaxBillInfoEncWriter(),
                ifTaxBillResultInfoWriter(),
                tbStatusHistWriter(),
                etsTaxMetaInfoTbWriter(),
                etsTaxMainInfoTbWriter(),
                ifTaxBillInfoWriter(),
                taxEmailBillInfoEndingUpdate()
            )
        );

        return compositeItemWriter;
    }

    //PPA 배치처리를 위한 3개 테이블 Insert 및 Update
    @Bean
    public CompositeItemWriter<TaxEmailItemListVO> compositeStep2ItemWriter() {
        CompositeItemWriter<TaxEmailItemListVO> compositeItemWriter = new CompositeItemWriter<>();

        compositeItemWriter.setDelegates(
            Arrays.asList(
                tbTradeItemListWriter(),
                etsTaxLineInfoTbWriter(),
                ifTaxBillItemListWriter(),
                taxEmailItemListEndingUpdate(),
                ppaBatchStatusInsert()
            )
        );

        return compositeItemWriter;
    }

    @Bean // 운영 환경에서 (반영될 부분)
    public ItemProcessorAdapter<TaxEmailBillInfoVO, TbTaxBillInfoEncVO> tbTaxBillInfoEncItemProcessor(TbTaxBillInfoEncInitial service) {
        ItemProcessorAdapter<TaxEmailBillInfoVO, TbTaxBillInfoEncVO> adapter = new ItemProcessorAdapter<>();

        adapter.setTargetObject(service);
        adapter.setTargetMethod("tbTaxBillInfoEncInitialize");

        return adapter;
    }

    @JobScope
    @Bean
    public Step stepErrorCheck() {
        log.info("STEP-ErrorCheck 시작...에러코드 변경 (99 - > 55)");

        return stepBuilderFactory
            .get("stepErrorCheck")
            .<TaxEmailBillInfoVO, TaxEmailBillInfoVO>chunk(20)
            .reader(pagingTaxEmailBillInfoMailStatusCodeCheckItemReader())
            .writer(taxEmailBillInfoErrorCodeChangeUpdate())
            .listener(new ErrorCheckLoggingStepStartStopListener(this.alarmReceiver))
            .build();
    }

    @JobScope
    @Bean
    public Step step0() {
        log.info("STEP-0 시작...중복체크(null -> 88)");

        return stepBuilderFactory
            .get("step0")
            .<TaxEmailBillInfoVO, TaxEmailBillInfoVO>chunk(20)
            .reader(pagingTaxEmailBillInfoEncCheckItemReader())
            .writer(taxEmailBillInfoEncCheckUpdate())
            .listener(new LoggingStepStartStopListener())
            .build();
    }

    @JobScope
    @Bean
    public Step step1() {
        log.info("STEP-1 시작...(6개 테이블 생성 작업)");

        return stepBuilderFactory
            .get("step1")
            .<TaxEmailBillInfoVO, TbTaxBillInfoEncVO>chunk(20)
            .reader(pagingTaxEmailBillInfoItemReader())
            .processor(tbTaxBillInfoEncItemProcessor(null))
            .writer(compositeItemWriter())
            .listener(new LoggingStepStartStopListener())
            .build();
    }

    @JobScope
    @Bean
    public Step step2() {
        log.info("STEP-2 시작...(3개 테이블 생성 작업)");
        return stepBuilderFactory
            .get("step2")
            .<TaxEmailItemListVO, TaxEmailItemListVO>chunk(20)
            .reader(pagingTaxEmailItemListItemReader())
            .writer(compositeStep2ItemWriter())
            .listener(new LoggingStepStartStopListener())
            .build();
    }

    //    @Bean(name = "ppaBatchJob")
    //    public Job ppaBatchJob() {
    //        return jobBuilderFactory
    //            .get("ppaBatchJob")
    //            .preventRestart()
    //            .incrementer(new RunIdIncrementer())
    //            .listener(JsrJobListenerFactoryBean.getListener(new JobLoggerListener()))
    //            .start(step1())
    //            .next(step2())
    //            .build();
    //    }

    //    @Bean(name = "ppaBatchJob")
    //    public Job ppaBatchJob() {
    //        return jobBuilderFactory
    //            .get("ppaBatchJob")
    //            .preventRestart()
    //            .incrementer(new RunIdIncrementer())
    //            .listener(JsrJobListenerFactoryBean.getListener(new JobLoggerListener()))
    //            .start(step1())
    //            .on("FAILED")
    //            .end()
    //            .from(step1())
    //            .on("*")
    //            .to(step2())
    //            .end()
    //            .build();
    //    }

    @Bean(name = "ppaBatchJob")
    public Job ppaBatchJob() {
        return jobBuilderFactory
            .get("ppaBatchJob")
            .preventRestart()
            .incrementer(new RunIdIncrementer())
            .listener(JsrJobListenerFactoryBean.getListener(new JobLoggerListener()))
            .start(stepErrorCheck())
            .next(step0())
            .next(step1())
            .next(step2())
            .build();
    }
}
