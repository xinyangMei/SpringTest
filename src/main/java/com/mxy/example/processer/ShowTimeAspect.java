package com.mxy.example.processer;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/2/13
 * @description
 */
@Aspect
@Component
public class ShowTimeAspect {
    private long startTime;

    @Pointcut("@annotation(com.mxy.example.animation.ShowTime)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        startTime = System.currentTimeMillis();
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature + "####cost time" + (System.currentTimeMillis() - startTime));
    }
}
