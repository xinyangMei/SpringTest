package com.mxy.example.job;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/31
 * @description
 */
@Component
public class ScheduleTest implements InitializingBean{
    @Autowired
    private Scheduler scheduler;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public ScheduleTest(){
        logger.info("###### ScheduleTest构造器初始化 ###" );
    }

    @Scheduled(cron = "0/30 * * * * ? ")
    public void changeStatus(){
        logger.info("Scheduled>>>>>>{}修改促销状态--->", new Date());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        scheduler.start();
        logger.info("ScheduleTest属性设置完毕");
    }
}
