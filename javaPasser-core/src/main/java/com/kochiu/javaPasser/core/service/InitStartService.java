package com.kochiu.javaPasser.core.service;

import org.springframework.stereotype.Service;

import com.kochiu.se.core.service.StartupCallback;

@Service("startupCallback")
public class InitStartService implements StartupCallback {

    @Override
    public void businessHandle() {
        System.out.println("JAVA PASSER startupCallback");
    }
}
