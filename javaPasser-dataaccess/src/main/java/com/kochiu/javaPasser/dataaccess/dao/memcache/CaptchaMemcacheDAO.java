package com.kochiu.javaPasser.dataaccess.dao.memcache;

import com.kochiu.se.dataaccess.memcache.BaseMemcacheDAO;


/**
 * @author zhihongp
 */
public interface CaptchaMemcacheDAO extends BaseMemcacheDAO {

    boolean addCaptcha(final String username, final String captcha, final int timeout);

    String getCaptcha(final String username, final String captchaKey);

    boolean removeCaptcha(final String username, final String captchaKey);

}
