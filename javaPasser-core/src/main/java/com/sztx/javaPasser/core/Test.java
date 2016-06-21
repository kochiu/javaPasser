package com.sztx.javaPasser.core;

import com.sztx.se.common.util.http.HttpClientUtil;

public class Test {

	public static void main(String[] args) {
		String url = "http://127.0.0.1:8085/example/testRedis?format=json";
		String r = HttpClientUtil.get(url);
		System.out.println(r);
	}
}
