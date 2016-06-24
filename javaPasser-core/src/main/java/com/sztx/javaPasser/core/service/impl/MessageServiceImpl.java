package com.sztx.javaPasser.core.service.impl;

import com.sztx.javaPasser.core.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
