package com.example.demo.service;

import com.example.demo.utils.RedisDistributedLock;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
@Service
public class OrderService {
    private int n = 20;
    @Autowired
    private RedisTemplate redisTemplate;
    @HystrixCommand(commandKey = "findOrderByI",fallbackMethod = "fallback",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "20"),
            @HystrixProperty(name = "maxQueueSize",value = "30")
    },commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String findOrderById(String id) throws InterruptedException{
        long timemills = 3000;
        return "淘宝订单Id:2109jr09f8h2r1";
    }
    /*@HystrixCommand(commandKey = "skill",fallbackMethod = "fallback",threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "100"),
            @HystrixProperty(name = "maxQueueSize",value = "300")
    },commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "100"),
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    public String skill(String id){
        RedisDistributedLock distributedLock = new RedisDistributedLock(redisTemplate);
        String key = "order";
        String reidentifier = distributedLock.lockWithExpire(key,5000,1000);
        if(reidentifier != null) {
            //reidentifier不为null,证明获得了分布式锁，调用服务
            System.out.println("分布式锁---调用下单服务 "+n--);
            distributedLock.releaseLock(key, reidentifier);
            return "下单成功";
        }else{
            //如果reidentifier为null,证明在尝试几秒后没有获得分布式锁，所以返回繁忙
            return "服务繁忙";
        }
    }
    public String fallback(String name,Throwable e){
        return "请求繁忙，请稍后再尝试...\n"+name+"  "+e.getMessage();
    }
}
