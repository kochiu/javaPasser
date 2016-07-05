package com.kochiu.javaPasser.rpc.service;

import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.rpc.api.service.TestRpcService;

@Service("testRpcServiceImpl")
public class TestRpcServiceImpl implements TestRpcService {

    @Override
    public String test() {
//        throw new BusinessException("AAAAAA");
		System.out.println("test");
		return "test";
    }

}
