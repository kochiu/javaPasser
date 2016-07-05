package com.kochiu.javaPasser.dataaccess.dao.mysql;

import org.apache.ibatis.annotations.Param;

import com.kochiu.javaPasser.dataaccess.domain.UserDO;
import com.kochiu.se.dataaccess.mysql.BaseMysqlDAO;

public interface UserMysqlDAO extends BaseMysqlDAO<UserDO> {

    UserDO findByUsername(@Param("username") String username);

}
