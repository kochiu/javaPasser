package com.sztx.demo.rpc.service;

import org.springframework.stereotype.Service;

import com.sztx.demo.rpc.api.service.DemoRpcService;

/**
 * 
 * @author zhiongp
 *
 */
@Service("demoRpcServiceImpl")
public class DemoRpcServiceImpl implements DemoRpcService {

	@Override
	public String sayHello() {
		System.out.println("demo rpc hello");
		return "demo rpc hello";
	}

	@Override
	public String say(String s) {
		System.out.println(s);
		return s;
	}
}
