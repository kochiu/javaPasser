package com.kochiu.javaPasser.rpc.api.service;

import com.kochiu.javaPasser.rpc.api.domain.User;

public interface UserRpcService {

    User findUser(String username);

}
