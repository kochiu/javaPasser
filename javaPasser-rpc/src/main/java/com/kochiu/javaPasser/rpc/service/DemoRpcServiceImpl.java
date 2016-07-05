package com.kochiu.javaPasser.rpc.service;

import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.rpc.api.service.DemoRpcService;

/**
 * @author zhiongp
 */
@Service("demoRpcServiceImpl")
public class DemoRpcServiceImpl implements DemoRpcService {

    @Override
    public String sayHello() {
        System.out.println("java passer rpc hello");
        return "java passer rpc hello";
    }

    @Override
    public String say(String s) {
        System.out.println(s);
        return s;
    }
}
