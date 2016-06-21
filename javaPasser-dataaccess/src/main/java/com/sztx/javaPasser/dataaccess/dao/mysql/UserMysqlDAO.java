package com.sztx.javaPasser.dataaccess.dao.mysql;

import org.apache.ibatis.annotations.Param;

import com.sztx.javaPasser.dataaccess.domain.UserDO;
import com.sztx.se.dataaccess.mysql.BaseMysqlDAO;

public interface UserMysqlDAO extends BaseMysqlDAO<UserDO> {

	UserDO findByUsername(@Param("username") String username);

}
