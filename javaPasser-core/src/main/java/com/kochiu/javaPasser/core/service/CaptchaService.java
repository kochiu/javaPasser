package com.kochiu.javaPasser.core.service;

import com.kochiu.se.core.service.BaseService;

/**
 * @author zhihongp
 */
public interface CaptchaService extends BaseService {

    String generateCaptcha(String username, int timeout);

    boolean validCaptcha(String username, String inputCaptcha);
}
