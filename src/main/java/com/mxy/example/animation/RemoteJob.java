package com.mxy.example.animation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/25
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RemoteJob {
}