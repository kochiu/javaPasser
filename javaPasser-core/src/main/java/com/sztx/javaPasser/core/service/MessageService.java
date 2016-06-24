package com.sztx.javaPasser.core.service;

import com.sztx.se.core.service.BaseService;

public interface MessageService extends BaseService {

    boolean sendCommentMsg(String message);
}
