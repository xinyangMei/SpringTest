package com.mxy.example.job;

import com.mxy.example.pojo.SimpleMessagePojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/31
 * @description 简易定时Job,实现继承该类,实现一个定时执行任务
 */
public abstract class BaseJob implements CommandLineRunner, Runnable {

    /**
     * 启动延时
     */
    private int initialDelay;
    /**
     * 执行时间周期
     */
    private int period;
    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    public BaseJob(int initialDelay, int period, TimeUnit timeUnit) {

        this.initialDelay = initialDelay;
        this.period = period;
        this.timeUnit = timeUnit;
    }

    /**
     * 线程run方法
     */
    @Override
    public void run() {
        doExecute();
    }

    /**
     * CommandLineRunner run方法,启动Spring后会调用该方法
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this, initialDelay, period, timeUnit);
    }

    /**
     * 抽象调用方法,由子类调用
     * @return
     */
    public abstract SimpleMessagePojo doExecute();

}
