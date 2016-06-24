package com.sztx.javaPasser.core.service.impl;

import com.sztx.javaPasser.core.service.RpcTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.javaPasser.rpc.api.domain.User;
import com.sztx.javaPasser.rpc.api.service.DemoRpcService;
import com.sztx.javaPasser.rpc.api.service.TestRpcService;
import com.sztx.javaPasser.rpc.api.service.UserRpcService;
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
