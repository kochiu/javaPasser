package com.kochiu.javaPasser.core.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import java.util.Date;

/**
 * @author gaochao
 */
public class DemoKafkaMessageListener implements MessageListener<Integer, String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> record) {
        try {
            System.out.println("get kafka object : " + record);
            System.out.println("get kafka topic : " + record.topic());
            System.out.println("get kafka message : " + new Date() + "" + record.value());
        } catch (Exception e) {
            System.out.print("=================get kafka message error=================");
        }
    }

}
//public class DemoKafkaMessageListener {
//
//}