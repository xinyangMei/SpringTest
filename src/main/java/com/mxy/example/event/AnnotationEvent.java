package com.mxy.example.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/5/1
 * @description
 */
public class AnnotationEvent extends ApplicationEvent {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //逻辑上区分不同的Event
    private String eventType;
    //Event中包含的业务逻辑信息
    private String msg;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public AnnotationEvent(Object source) {
        super(source);
    }

    public AnnotationEvent(Object source, String eventType, String msg) {
        super(source);
        this.eventType = eventType;
        this.msg = msg;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
