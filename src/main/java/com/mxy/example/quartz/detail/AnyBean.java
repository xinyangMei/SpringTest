package com.mxy.example.quartz.detail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description
 */
@Component
public class AnyBean {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    public void changeStatus(){
        logger.info("#####{}###修改活动状态", this.getClass().getName());
    }
}
