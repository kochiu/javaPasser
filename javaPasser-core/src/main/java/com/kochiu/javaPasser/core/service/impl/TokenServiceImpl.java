package com.kochiu.javaPasser.core.service.impl;

import com.kochiu.javaPasser.core.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.dataaccess.dao.redis.TokenRedisDAO;
import com.kochiu.se.common.exception.BusinessException;
import com.kochiu.se.common.util.UUIDUtil;
import com.kochiu.se.common.util.validate.ValidateUtil;
import com.kochiu.se.core.service.impl.BaseServiceImpl;

@Service("tokenService")
public class TokenServiceImpl extends BaseServiceImpl implements TokenService {

    @Autowired
    private TokenRedisDAO tokenRedisDAO;

    @Override
    public String generateToken(long timeout) {
        ValidateUtil.notNull(timeout, "token超时时间timeout不允许为空");
        String token = UUIDUtil.getUUID();
        tokenRedisDAO.addToken(token, timeout);
        return token;
    }

    @Override
    public boolean validToken(String inputToken) {
        ValidateUtil.isNotBlank(inputToken, "inputToken不允许为空");
        String tokenKey = inputToken;
        String token = tokenRedisDAO.getToken(tokenKey);

        if (!inputToken.equals(token)) {
            throw new BusinessException("token两次输入不一致");
        }

        return tokenRedisDAO.removeToken(tokenKey);
    }

}
