package com.kochiu.javaPasser.core.service.impl;

import com.kochiu.javaPasser.core.service.RpcTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.rpc.api.domain.User;
import com.kochiu.javaPasser.rpc.api.service.DemoRpcService;
import com.kochiu.javaPasser.rpc.api.service.TestRpcService;
import com.kochiu.javaPasser.rpc.api.service.UserRpcService;
import com.kochiu.se.rpc.dubbo.client.DubboClientFactory;

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
