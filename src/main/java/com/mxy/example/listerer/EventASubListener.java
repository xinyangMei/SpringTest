package com.mxy.example.listerer;

import com.mxy.example.event.MsgASubEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/5/1
 * @description
 */
@Component
public class EventASubListener implements ApplicationListener<MsgASubEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(MsgASubEvent event) {
        logger.info("# 子类监听器收到事件信息" );
    }
}
