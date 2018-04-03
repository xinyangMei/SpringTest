package com.mxy.example.processer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/2/26
 * @description
 */
@Configuration
public class RemoteJobClientConfiguration {
    public RemoteJobClientConfiguration() {
    }

    @Bean
    @Primary
    public RemoteJobScannerConfigurer remoteJobScannerConfigurer() {
        RemoteJobScannerConfigurer configurer = new RemoteJobScannerConfigurer();
        configurer.setBasePackage("com.spring,com.markor");
        return configurer;
    }
}