package com.mxy.example.config;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/6/13
 * @description
 */
@Configuration
public class BeanConfig {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public LoadingCache<String,AtomicLong> buildCache(){
        return CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<String, AtomicLong>() {
                    @Override
                    public AtomicLong load(String key) {
                        return new AtomicLong(0);
                    }
                });
    }

}
