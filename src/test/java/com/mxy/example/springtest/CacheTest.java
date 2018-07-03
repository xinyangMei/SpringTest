package com.mxy.example.springtest;

import com.google.common.cache.LoadingCache;
import com.mxy.example.SpringtestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/6/14
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringtestApplication.class)
public class CacheTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static int LIMIT_12_SEC = 30;

    private final static String COUNT_KEY = "COUNT_KEY";

    @Autowired
    private LoadingCache<String, AtomicLong> longLoadingCache;

    @Test
    public void cacheTest() throws ExecutionException {
        for (int i = 0; i < 400; i++) {
            AtomicLong atomicLong = longLoadingCache.get(COUNT_KEY);

            if (atomicLong.incrementAndGet() > LIMIT_12_SEC) {
                logger.info("最大请求量超过12秒内限制限制，限制量为{}",LIMIT_12_SEC );
                continue;
            }
//            logger.info("请求处理完成，当前请求量为{}",atomicLong.decrementAndGet());
        }
    }

    @Test
    public void testExpire() throws ExecutionException, InterruptedException {
        AtomicLong atomicLong = longLoadingCache.get(COUNT_KEY);
        atomicLong.addAndGet(12);
        logger.info("缓存值为{}",longLoadingCache.get(COUNT_KEY) );
        Thread.sleep(4*1000);
        logger.info("3秒后缓存过期{}",atomicLong );
        logger.info("3秒后缓存过期{}",longLoadingCache.get(COUNT_KEY) );
    }



}
