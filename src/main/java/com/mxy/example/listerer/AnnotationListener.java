package com.mxy.example.listerer;

import com.mxy.example.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/12
 * @description
 */
@Component
public class AnnotationListener {

    private String tag;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @EventListener(classes = TestEvent.class,condition = "#event.msg=='tag'")
    @Async
    public void dealTestEvent(TestEvent event) throws InterruptedException {
        asyncTest();
        logger.info("annotation接收到事件{}", event.getMsg());
    }

    public void asyncTest() throws InterruptedException {
        logger.info("thread sleep{}",4000 );
        Thread.sleep(3000);

    }



}
