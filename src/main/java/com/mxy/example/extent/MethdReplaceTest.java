package com.mxy.example.extent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/12
 * @description
 */
@Component
public class MethdReplaceTest implements MethodReplacer,BeanFactoryPostProcessor{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return null;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
