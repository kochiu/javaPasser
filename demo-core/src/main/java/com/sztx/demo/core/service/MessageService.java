package com.sztx.demo.core.service;

import com.sztx.se.core.service.BaseService;

public interface MessageService extends BaseService {
	
	boolean sendCommentMsg(String message);
}
