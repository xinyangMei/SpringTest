package com.mxy.example.publish;

import com.mxy.example.event.AnnotationEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/5/1
 * @description
 */
@Component
public class AnnotationPublish implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publish(AnnotationEvent event){
        applicationEventPublisher.publishEvent(event);
    }

}
