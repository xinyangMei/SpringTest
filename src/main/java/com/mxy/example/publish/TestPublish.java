package com.mxy.example.publish;

import com.mxy.example.event.TestEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/12
 * @description
 */
@Component
public class TestPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void publish(TestEvent event) {
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
