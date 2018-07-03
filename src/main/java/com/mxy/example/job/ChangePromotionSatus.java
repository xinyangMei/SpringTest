package com.mxy.example.job;

import com.mxy.example.pojo.SimpleMessagePojo;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/3/31
 * @description
 */
@Component
@ConditionalOnProperty(name = "enableBaseJob" ,havingValue = "true")
public class ChangePromotionSatus extends BaseJob {

    public ChangePromotionSatus() {
        super(12,30,TimeUnit.SECONDS);
    }

    public ChangePromotionSatus(int initialDelay, int period, TimeUnit timeUnit) {
        super(initialDelay, period, timeUnit);
    }

    @Override
    public SimpleMessagePojo doExecute() {
        logger.info("######{} 查看促销状态并更新", new Date());
        return null;
    }
}
