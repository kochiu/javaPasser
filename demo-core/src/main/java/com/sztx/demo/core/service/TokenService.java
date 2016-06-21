package com.sztx.demo.core.service;

import com.sztx.se.core.service.BaseService;


public interface TokenService extends BaseService {

	String generateToken(long timeout);
	
	boolean validToken(String inputToken);
}
