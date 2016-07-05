package com.kochiu.javaPasser.dataaccess.dao.redis;

import com.kochiu.se.dataaccess.redis.BaseRedisDAO;


/**
 * @author zhihongp
 */
public interface TokenRedisDAO extends BaseRedisDAO {

    boolean addToken(final String token, final long timeout);

    String getToken(final String tokenKey);

    boolean removeToken(final String tokenKey);

}
