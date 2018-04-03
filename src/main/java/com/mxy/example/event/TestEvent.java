package com.mxy.example.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/12
 * @description
 */
public class TestEvent extends ApplicationEvent implements Serializable {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String msg;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TestEvent(Object source) {
        super(source);
        msg = source.toString();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{\"TestEvent\":{"
                + "                        \"msg\":\"" + msg + "\""
                + "}}";
    }
}
