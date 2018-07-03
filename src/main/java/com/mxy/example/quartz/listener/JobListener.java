package com.mxy.example.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/3
 * @description
 */
@Component
public class JobListener implements org.quartz.JobListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return this.getClass().getName();
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.info("############Job即将执行");
    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.info("############Job执行停止");

    }

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.info("############Job完成");
        if(null!=jobException){
            logger.error("#########执行异常",jobException );
        }
    }
}
