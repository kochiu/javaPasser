package com.sztx.javaPasser.dataaccess.dao.memcache;

import com.sztx.se.dataaccess.memcache.BaseMemcacheDAO;


/**
 * @author zhihongp
 */
public interface CaptchaMemcacheDAO extends BaseMemcacheDAO {

    boolean addCaptcha(final String username, final String captcha, final int timeout);

    String getCaptcha(final String username, final String captchaKey);

    boolean removeCaptcha(final String username, final String captchaKey);

}
