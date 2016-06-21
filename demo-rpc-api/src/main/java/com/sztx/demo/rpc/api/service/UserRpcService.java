package com.sztx.demo.rpc.api.service;

import com.sztx.demo.rpc.api.domain.User;

public interface UserRpcService {

	User findUser(String username);

}
