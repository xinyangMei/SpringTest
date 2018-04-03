package com.mxy.example.quartz;

import com.mxy.example.quartz.detail.ChangeStatusJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description
 */
@Configuration
@EnableScheduling
public class QuartzConfig {

    @Bean
    public SchedulerFactoryBean scheduler(Trigger cronJobTrigger,Trigger anyDetailTrigger){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
        bean.setOverwriteExistingJobs(true);
        // 延时启动，应用启动1秒后
        bean.setStartupDelay(100);
        // 注册触发器
        bean.setTriggers(cronJobTrigger,anyDetailTrigger);
        bean.start();
        return bean;
    }

    @Bean
    public CronTriggerFactoryBean cronJobTrigger(JobDetail changeStatusDetail){
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setCronExpression("0/10 * * * * ? ");
        triggerFactoryBean.setName("cronTrigger");
        triggerFactoryBean.setGroup("cronGroup");
        triggerFactoryBean.setJobDetail(changeStatusDetail);
        return triggerFactoryBean;
    }
    @Bean
    public CronTriggerFactoryBean anyDetailTrigger(JobDetail anyDetail){
        CronTriggerFactoryBean triggerFactoryBean = new CronTriggerFactoryBean();
        triggerFactoryBean.setCronExpression("0/10 * * * * ? ");
        triggerFactoryBean.setName("cronAnyDetailTrigger");
        triggerFactoryBean.setGroup("cronGroup");
        triggerFactoryBean.setJobDetail(anyDetail);
        return triggerFactoryBean;
    }


    @Bean
    public JobDetailFactoryBean changeStatusDetail(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(ChangeStatusJob.class);
        jobDetailFactoryBean.setGroup("group");
        jobDetailFactoryBean.setName("changStatus");
        return jobDetailFactoryBean;
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean anyDetail(){
        MethodInvokingJobDetailFactoryBean jobDetailFactoryBean = new MethodInvokingJobDetailFactoryBean();
        jobDetailFactoryBean.setName("AnyBeanTest");
        jobDetailFactoryBean.setName("group");
        jobDetailFactoryBean.setTargetBeanName("anyBean");
        jobDetailFactoryBean.setTargetMethod("changeStatus");
        return jobDetailFactoryBean;
    }
}
