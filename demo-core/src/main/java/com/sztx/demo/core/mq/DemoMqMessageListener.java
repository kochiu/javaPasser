package com.sztx.demo.core.mq;

import com.sztx.se.core.mq.consumer.MqMessageListener;

/**
 * 
 * @author zhihongp
 *
 */
public class DemoMqMessageListener extends MqMessageListener {

	@Override
	public Object handleMessage(String messageId, String messageContent, String queue) {
		System.out.println(messageContent);
		return "success";
	}

}
