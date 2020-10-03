package com.example.demo.mq;

import com.example.demo.config.MQConfig;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/22.
 */
public class Consumer {
    private DefaultMQPushConsumer consumer;
    private String consumerGroup = "consumerGroup";
    public Consumer() throws MQClientException{
        this.consumer = new DefaultMQPushConsumer();
        this.consumer.setConsumerGroup(consumerGroup);
        this.consumer.setNamesrvAddr(MQConfig.NAME_SERVER);
        this.consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        this.consumer.subscribe(MQConfig.TOPIC_NAME,"*");
        this.consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try{
                    for (MessageExt msg:msgs){
                        String body = new String(msg.getBody(),"utf-8");
                        System.out.println("客户端接受消息:"+body+"主题为:"+msg.getTopic());
                    }
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.println("消费者启动！");
    }
}
