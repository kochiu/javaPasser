package com.kochiu.javaPasser.rpc.service;

import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.dataaccess.domain.UserDO;
import com.kochiu.javaPasser.rpc.api.domain.User;
import com.kochiu.javaPasser.rpc.api.service.UserRpcService;
import com.kochiu.se.core.service.impl.BaseServiceImpl;

@Service("userRpcServiceImpl")
public class UserRpcServiceImpl extends BaseServiceImpl implements UserRpcService {


    @Override
    public User findUser(String username) {
        UserDO userDO = new UserDO();
        User user = null;

        if (userDO != null) {
            user = new User();
            user.setId(userDO.getId());
            user.setUsername(userDO.getUsername());
            user.setPassword(userDO.getPassword());
            user.setNick(userDO.getNick());
            user.setAge(userDO.getAge());
            user.setSex(userDO.getSex());
        }

        return user;
    }

}
