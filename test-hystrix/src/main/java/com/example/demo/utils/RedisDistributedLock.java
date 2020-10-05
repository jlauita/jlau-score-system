package com.example.demo.utils;

import io.lettuce.core.RedisException;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
public class RedisDistributedLock {
    private RedisTemplate redisTemplate;
    public RedisDistributedLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public String lockWithExpire(String keyName,long acquiredTimeout,long expire){
        String identifier = UUID.randomUUID().toString();
        String lockName = "lock: "+keyName;
        long timeout = System.currentTimeMillis()+acquiredTimeout;
        String acquiredLock = null;
        while(System.currentTimeMillis() < timeout){
            if(redisTemplate.opsForValue().setIfAbsent(lockName,identifier,expire,TimeUnit.MILLISECONDS)){
                acquiredLock = identifier;
                return acquiredLock;
            }
            if(redisTemplate.getExpire(lockName) == -1){
                redisTemplate.expire(lockName,expire,TimeUnit.MILLISECONDS);
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return acquiredLock;
    }

    public boolean releaseLock(String keyName,String identifier){
        boolean releases = false;
        String lockName = "lock: "+keyName;
        try {
            while (true) {
                redisTemplate.watch(lockName);
                if (redisTemplate.opsForValue().get(lockName).equals(identifier)) {
                    redisTemplate.multi();
                    redisTemplate.delete(lockName);
                    List<Object> results = redisTemplate.exec();
                    if (results == null) {
                        //事务失败，重试
                        continue;
                    }
                    releases = true;
                }
                redisTemplate.unwatch();
                break;
            }
        }catch (RedisException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return releases;
    }
}
