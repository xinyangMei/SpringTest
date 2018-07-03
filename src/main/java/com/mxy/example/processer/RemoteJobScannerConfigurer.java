package com.mxy.example.processer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/2/26
 * @description
 */
public class RemoteJobScannerConfigurer implements BeanDefinitionRegistryPostProcessor, InitializingBean, ApplicationContextAware {
    private String basePackage;
    private ApplicationContext applicationContext;

    public RemoteJobScannerConfigurer() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        JobClassPathClientScanner scanner = new JobClassPathClientScanner(beanDefinitionRegistry, this.applicationContext);
        scanner.setResourceLoader(this.applicationContext);
        int scan = scanner.scan(StringUtils.tokenizeToStringArray(this.basePackage, ","));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}

