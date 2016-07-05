package com.kochiu.javaPasser.core.service;

import com.kochiu.se.core.service.BaseService;

public interface MessageService extends BaseService {

    boolean sendCommentMsg(String message);
}
