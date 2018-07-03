package com.mxy.example.listerer;

import com.mxy.example.event.MsgAEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/5/1
 * @description
 */
@Component
@Order(2)
public class AnotherEventAListener implements ApplicationListener<MsgAEvent> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(MsgAEvent applicationEvent) {
        applicationEvent.setMsg("tag");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("# AnotherEventAListener 接收到事件{}", applicationEvent.getMsg());
    }
}
