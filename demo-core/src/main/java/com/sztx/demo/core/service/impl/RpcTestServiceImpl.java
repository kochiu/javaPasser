package com.sztx.demo.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.demo.core.service.RpcTestService;
import com.sztx.demo.rpc.api.domain.User;
import com.sztx.demo.rpc.api.service.DemoRpcService;
import com.sztx.demo.rpc.api.service.TestRpcService;
import com.sztx.demo.rpc.api.service.UserRpcService;
import com.sztx.se.rpc.dubbo.client.DubboClientFactory;

@Service("rpcTestService")
public class RpcTestServiceImpl implements RpcTestService {
	
	@Autowired(required = false)
	private DubboClientFactory dubboClientFactory;

	@Override
	public String testRpc() {
		DemoRpcService demoRpcService = dubboClientFactory.getDubboClient("demoRpcService");
		TestRpcService testRpcService = dubboClientFactory.getDubboClient("testRpcService");
		UserRpcService userRpcService = dubboClientFactory.getDubboClient("userRpcService");
		String m = demoRpcService.say("haha");
		User user = userRpcService.findUser("xiaxiaB");
		System.out.println(user);
		testRpcService.test();
		return m;
	}

}
