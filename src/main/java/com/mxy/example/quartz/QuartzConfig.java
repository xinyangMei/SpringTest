package com.mxy.example.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/1
 * @description
 */
@Configuration
@EnableScheduling
public class QuartzConfig {

   @Bean
    public SchedulerFactoryBean scheduler(){
       SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//       schedulerFactoryBean.setDataSource(dataSource);
       schedulerFactoryBean.setSchedulerName("DefaultQuartzScheduler");
       schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));
       schedulerFactoryBean.setAutoStartup(true);
//       schedulerFactoryBean.getScheduler().start();
       return schedulerFactoryBean;
   }
}
