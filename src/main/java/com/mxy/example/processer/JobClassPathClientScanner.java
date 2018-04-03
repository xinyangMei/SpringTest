package com.mxy.example.processer;

import com.spring.test.springdemo.animation.ShowTime;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/2/26
 * @description
 */
public class JobClassPathClientScanner extends ClassPathBeanDefinitionScanner {
    private ApplicationContext applicationContext;

    public JobClassPathClientScanner(BeanDefinitionRegistry registry, ApplicationContext applicationContext) {
        super(registry);
        this.applicationContext = applicationContext;
    }



    //    @Override
//    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
//        return beanDefinition.getMetadata().getInterfaceNames().contains(ShowTime.class.getCanonicalName());
//    }

    @Override
    public void registerDefaultFilters() {
        super.registerDefaultFilters();
        this.addIncludeFilter(new AnnotationTypeFilter(ShowTime.class));
        this.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                String className = metadataReader.getClassMetadata().getClassName();

                String superClassName = metadataReader.getClassMetadata().getSuperClassName();
                System.out.println(superClassName);
                if ("com.spring.test.springdemo.service.Test".equals(className)) {
                    return true;
                }
                return false;
            }
        });
    }

    private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) throws ClassNotFoundException {
        Iterator ite = beanDefinitions.iterator();
        ArrayList jobClasses = new ArrayList();

        while (ite.hasNext()) {
            BeanDefinitionHolder holder = (BeanDefinitionHolder) ite.next();
            GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
            Class<?> jobClass = Class.forName(definition.getBeanClassName());
            definition.setBeanClass(jobClass);
            definition.setAutowireMode(2);
            jobClasses.add(jobClass);
        }

    }
}

