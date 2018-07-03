package com.mxy.example.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/4/3
 * @description
 */
public class TriggerListener implements org.quartz.TriggerListener{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    @Override
    public void triggerMisfired(Trigger trigger) {

    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {

    }
}
