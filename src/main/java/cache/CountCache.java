package cache;

import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xinyang.Mei
 * @version V1.0
 * @date 2018/6/13
 * @description
 */
@Component
public class CountCache {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoadingCache<String,AtomicLong> loadingCache;

    private AtomicLong getByKey(String key){
        AtomicLong atomicLong = null;
        try {
            atomicLong = loadingCache.get(key);
        } catch (ExecutionException e) {
            logger.error("获取缓存异常",e);
        }

        return atomicLong;
    }



}
