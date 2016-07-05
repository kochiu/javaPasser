package com.kochiu.javaPasser.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kochiu.javaPasser.core.service.CaptchaService;
import com.kochiu.javaPasser.dataaccess.dao.memcache.CaptchaMemcacheDAO;
import com.kochiu.se.common.exception.BusinessException;
import com.kochiu.se.common.util.captcha.CaptchaUtil;
import com.kochiu.se.common.util.validate.ValidateUtil;
import com.kochiu.se.core.service.impl.BaseServiceImpl;

/**
 * @author zhihongp
 */
@Service("captchaService")
public class CaptchaServiceImpl extends BaseServiceImpl implements CaptchaService {

    @Autowired
    private CaptchaMemcacheDAO captchaMemcacheDAO;

    @Override
    public String generateCaptcha(String username, int timeout) {
        ValidateUtil.isNotBlank(username, "用户名不允许为空");
        ValidateUtil.notNull(timeout, "验证码超时时间timeout不允许为空");
        int captchaNum = CaptchaUtil.getCaptchaNum();
        String captcha = String.valueOf(captchaNum);
        captchaMemcacheDAO.addCaptcha(username, captcha, timeout);
        return captcha;
    }

    @Override
    public boolean validCaptcha(String username, String inputCaptcha) {
        ValidateUtil.isNotBlank(username, "用户名不允许为空");
        ValidateUtil.isNotBlank(inputCaptcha, "inputCaptcha不允许为空");

        String captchaKey = inputCaptcha;
        String captcha = captchaMemcacheDAO.getCaptcha(username, captchaKey);

        if (!inputCaptcha.equals(captcha)) {
            throw new BusinessException("captcha两次输入不一致");
        }

        captchaMemcacheDAO.removeCaptcha(username, captchaKey);
        return true;
    }

}
