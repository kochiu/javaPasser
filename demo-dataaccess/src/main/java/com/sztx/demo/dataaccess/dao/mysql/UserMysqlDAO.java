package com.sztx.demo.dataaccess.dao.mysql;

import org.apache.ibatis.annotations.Param;

import com.sztx.demo.dataaccess.domain.UserDO;
import com.sztx.se.dataaccess.mysql.BaseMysqlDAO;

public interface UserMysqlDAO extends BaseMysqlDAO<UserDO> {

	UserDO findByUsername(@Param("username") String username);

}
