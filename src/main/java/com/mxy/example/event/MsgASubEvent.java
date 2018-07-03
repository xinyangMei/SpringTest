package com.mxy.example.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/5/1
 * @description
 */
public class MsgASubEvent extends MsgAEvent{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MsgASubEvent(Object source) {
        super(source);
    }
}
