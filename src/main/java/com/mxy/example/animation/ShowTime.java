package com.mxy.example.animation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/2/13
 * @description 切面注解
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ShowTime {
}
