package com.mxy.example.quartz;

import com.mxy.example.quartz.detail.ChangeStatusJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description 测试CronTrigger
 */
public class CronTriggerDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        try {
            Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

            Trigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger", "cronTrigger")
                    .startNow()
                    .usingJobData("msg","cronTrigger测试实例" )
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ? "))
                    .build();

            JobDetail jobDetail = JobBuilder.newJob(ChangeStatusJob.class)
                    .withIdentity("cronJob", "cronGroup")
                    .build();

            defaultScheduler.scheduleJob(jobDetail,cronTrigger );

            defaultScheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
