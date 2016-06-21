package com.sztx.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.demo.core.service.MessageService;
import com.sztx.se.core.mq.producer.MqMessageSender;
import com.sztx.se.core.service.impl.BaseServiceImpl;

@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl implements MessageService {
	
	@Autowired(required = false)
	private MqMessageSender mqMessageSender;
	
	@Override
	public boolean sendCommentMsg(String message) {
		mqMessageSender.sendMessage(message);
		return true;
	}

}
