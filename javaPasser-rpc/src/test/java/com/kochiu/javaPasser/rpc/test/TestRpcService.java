package com.kochiu.javaPasser.rpc.test;

import com.kochiu.javaPasser.rpc.api.service.DemoRpcService;
import com.kochiu.se.rpc.dubbo.client.DubboClientFactory;
import com.kochiu.se.rpc.dubbo.provider.DubboService;
import com.kochiu.se.rpc.dubbo.source.DynamicCreateDubboClientManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gaochao on 16/7/1.
 */
public class TestRpcService {

    private static ClassPathXmlApplicationContext context;

    private static String configPath = "classpath*:spring-rpc-client.xml";

    @Test
    public void testRpcService() {

        context = new ClassPathXmlApplicationContext(new String[]{configPath});
        context.start();

        DubboClientFactory dubboClientFactory = (DubboClientFactory)context.getBean("dynamicDubboClient");

        DemoRpcService rpcService = dubboClientFactory.getDubboClient("demoRpcService");
        String returnString = rpcService.sayHello();
        System.out.print("-----" + returnString);

        System.out.print("=======");

    }
}
