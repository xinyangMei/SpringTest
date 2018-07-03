package com.mxy.example.listerer;

import com.mxy.example.event.AnnotationEvent;
import com.mxy.example.event.MsgAEvent;
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

    @EventListener(classes = AnnotationEvent.class, condition = "#event.eventType=='typeA'")
    @Async
    public void dealEventA(AnnotationEvent event) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("# annotation接收到事件{}", event.getMsg());
    }

    @EventListener(classes = AnnotationEvent.class, condition = "#event.eventType=='typeB'")
    @Async
    public void dealEventB(AnnotationEvent event)  {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("# annotation接收到事件{}", event.getMsg());
    }

    @EventListener(classes = {AnnotationEvent.class,MsgAEvent.class})
    public void dealMultipEvent()  {
        logger.info("# annotation接收到事件");
    }



}
