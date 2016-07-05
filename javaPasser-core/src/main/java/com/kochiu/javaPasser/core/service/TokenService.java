package com.kochiu.javaPasser.core.service;

import com.kochiu.se.core.service.BaseService;


public interface TokenService extends BaseService {

    String generateToken(long timeout);

    boolean validToken(String inputToken);
}
