package com.mxy.example.listerer;

import com.mxy.example.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/12
 * @description
 */
@Component
public class TestListener implements ApplicationListener<TestEvent> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(TestEvent applicationEvent) {
        applicationEvent.setMsg("tag");
        logger.info("接收到事件{}", applicationEvent.getMsg());
    }
}
