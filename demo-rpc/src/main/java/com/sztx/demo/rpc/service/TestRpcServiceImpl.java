package com.sztx.demo.rpc.service;

import org.springframework.stereotype.Service;

import com.sztx.demo.rpc.api.service.TestRpcService;
import com.sztx.se.common.exception.BusinessException;

@Service("testRpcServiceImpl")
public class TestRpcServiceImpl implements TestRpcService {

	@Override
	public String test() {
		throw new BusinessException("AAAAAA");
//		System.out.println("test");
//		return "test";
	}

}
