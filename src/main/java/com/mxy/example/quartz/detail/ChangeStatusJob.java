package com.mxy.example.quartz.detail;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description Job 执行实例
 */
@DisallowConcurrentExecution
public class ChangeStatusJob implements Job{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String msg;
    /**
     * 由调度器调用的方法
     * @param jobExecutionContext job上下文信息
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取Job配置时传入的参数
//        logger.info("开始>>>>quartz>>>TriggerName>>>>{}",this);
//        JobDetail jobDetail = jobExecutionContext.getJobDetail();
//        JobDataMap jobDataMap = jobDetail.getJobDataMap();
//        String msg = jobDataMap.getString("msg");
//        Trigger trigger = jobExecutionContext.getTrigger();
//        logger.info("结束{}>>>>quartz>>>TriggerName>>>>{}",this, ((JSONObject)JSON.toJSON(trigger)).getString("fullName"));
        logger.info("#########msg{}", msg);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
