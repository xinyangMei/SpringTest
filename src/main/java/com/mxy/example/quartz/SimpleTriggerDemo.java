package com.mxy.example.quartz;

import com.google.common.collect.Sets;
import com.mxy.example.quartz.detail.ChangeStatusJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description
 */
public class SimpleTriggerDemo {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        try {
            //创建scheduler
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            //定义一个Trigger
            Trigger trigger1 = TriggerBuilder.newTrigger()
                    //定义name/group
                    .withIdentity("trigger1", "group1")
                    //一旦加入scheduler，立即生效
                    .startNow()
                    //配置一个简单调度器,10秒执行一次,重复3次
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            //执行周期,一秒执行一次
                            .withIntervalInSeconds(5)
                            //设置重复次数
                            .withRepeatCount(10))
                    .build();
            //定义一个Trigger
            Trigger trigger2 = TriggerBuilder.newTrigger()
                    //定义name/group
                    .withIdentity("trigger2", "group2")
                    //一旦加入scheduler，立即生效
                    .startNow()
                    //配置一个简单调度器,10秒执行一次,重复3次
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            //执行周期,一秒执行一次
                            .withIntervalInSeconds(6)
                            //设置重复次数
                            .withRepeatCount(10))
                    .build();
            //定义一个JobDetail
            //配置任务执行类
            JobDetail job = JobBuilder.newJob(ChangeStatusJob.class)
                    //配置Job名称分组
                    .withIdentity("jobName--test", "jobGroup--testGroup")
                    .withDescription("quartz测试")
                    //配置Job执行时会用到的参数,键值对String-->基本数据类型的包装类.也可直接传入一个JobDataMap
                    .usingJobData("msg", "更新状态为已失效")
                    .build();

            //加入这个调度
            Map<JobDetail,Set<? extends Trigger>> jobDetailTriggerMap = new HashMap<>();
            Set<Trigger> triggers = Sets.newHashSet(trigger1,trigger2);
            jobDetailTriggerMap.put(job, triggers);
            scheduler.scheduleJobs(jobDetailTriggerMap,true);

            //启动之
            scheduler.start();

            //运行一段时间后关闭
            Thread.sleep(100000);
            scheduler.shutdown(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
