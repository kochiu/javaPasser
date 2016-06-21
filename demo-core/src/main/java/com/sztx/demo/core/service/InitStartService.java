package com.sztx.demo.core.service;

import org.springframework.stereotype.Service;

import com.sztx.se.core.service.StartupCallback;

@Service("startupCallback")
public class InitStartService implements StartupCallback {

	@Override
	public void businessHandle() {
		System.out.println("demo startupCallback");
	}
}
