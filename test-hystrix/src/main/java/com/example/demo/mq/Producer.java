package com.example.demo.mq;

import com.example.demo.config.MQConfig;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
@Component
public class Producer {
    @Autowired
    private String producerGroup = "producerGroup";
    private DefaultMQProducer producer;
    public Producer(){
        producer = new DefaultMQProducer();
        producer.setVipChannelEnabled(false);
        producer.setProducerGroup(producerGroup);
        producer.setNamesrvAddr(MQConfig.NAME_SERVER);
        start();
    }
    public void start(){
        try{
            this.producer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public DefaultMQProducer getProducer(){
        return this.producer;
    }
    public void shutdown(){
        this.producer.shutdown();
    }
}
