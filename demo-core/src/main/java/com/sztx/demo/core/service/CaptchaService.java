package com.sztx.demo.core.service;

import com.sztx.se.core.service.BaseService;

/**
 * 
 * @author zhihongp
 *
 */
public interface CaptchaService extends BaseService {

	String generateCaptcha(String username, int timeout);

	boolean validCaptcha(String username, String inputCaptcha);
}
