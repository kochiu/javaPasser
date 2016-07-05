package com.kochiu.javaPasser.core.mq;

import com.kochiu.se.core.mq.consumer.MqMessageListener;

/**
 * @author zhihongp
 */
public class DemoMqMessageListener extends MqMessageListener {

    @Override
    public Object handleMessage(String messageId, String messageContent, String queue) {
        System.out.println("get mq message success " + messageContent);
        return "success";
    }

}
