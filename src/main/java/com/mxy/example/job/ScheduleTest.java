package com.mxy.example.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/31
 * @description
 */
@Component
public class ScheduleTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Scheduled(cron = "0/30 * * * * ? ")
    public void changeStatus(){
        logger.info("Scheduled>>>>>>{}修改促销状态--->", new Date());
    }
}
