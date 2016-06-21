package com.sztx.javaPasser.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.javaPasser.dataaccess.domain.UserDO;
import com.sztx.javaPasser.rpc.api.domain.User;
import com.sztx.javaPasser.rpc.api.service.UserRpcService;
import com.sztx.se.core.service.impl.BaseServiceImpl;

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
