package com.example.demo.controller;

import com.example.demo.config.MQConfig;
import com.example.demo.mq.Producer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
@RestController
public class MQController {
    @Autowired
    private Producer producer;
    @GetMapping("/mq")
    public String mq() throws Exception{
        List<String> msgs = new ArrayList<>();
        msgs.add("啵啵桑");
        msgs.add("阿龙");
        msgs.add("八一");
        msgs.add("刀哥");
        msgs.add("嘉木");
        msgs.add("仔仔");
        msgs.add("任桑");
        for (String msg:msgs){
            Message message = new Message(MQConfig.TOPIC_NAME,(msg+"小小的603成员").getBytes());
            SendResult result = producer.getProducer().send(message);
            System.out.println("生产者发送了的消息"+result);
        }
        return "生产者发送消息";
    }
}
