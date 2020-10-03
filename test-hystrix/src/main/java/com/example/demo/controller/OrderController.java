package com.example.demo.controller;

import com.example.demo.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/order/find")
    public String findOrderById(@RequestParam("id") String id){
        String result = "";
        try {
            result = orderService.findOrderById(id);
        }catch (Exception e){
            if(e instanceof HystrixRuntimeException){
                System.out.println(e.getClass());
                return "服务繁忙，请稍后再试";
            }else {
                return e.getMessage();
            }
        }
        return result;
    }
    @GetMapping("/skill")
    public String skill(@RequestParam("id") String id){
        return orderService.skill(id);
    }
}
