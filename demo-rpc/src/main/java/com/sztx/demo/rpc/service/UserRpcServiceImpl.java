package com.sztx.demo.rpc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sztx.demo.core.service.UserService;
import com.sztx.demo.dataaccess.domain.UserDO;
import com.sztx.demo.rpc.api.domain.User;
import com.sztx.demo.rpc.api.service.UserRpcService;
import com.sztx.se.core.service.impl.BaseServiceImpl;

@Service("userRpcServiceImpl")
public class UserRpcServiceImpl extends BaseServiceImpl implements UserRpcService {

	@Autowired
	private UserService userService;

	@Override
	public User findUser(String username) {
		UserDO userDO = userService.findByUsername(username);
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
