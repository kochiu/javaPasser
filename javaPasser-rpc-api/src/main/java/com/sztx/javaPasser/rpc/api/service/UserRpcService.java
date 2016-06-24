package com.sztx.javaPasser.rpc.api.service;

import com.sztx.javaPasser.rpc.api.domain.User;

public interface UserRpcService {

    User findUser(String username);

}
