package com.kochiu.javaPasser.common.util.mail;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA.
 * User: gaochao
 * Date: 2016/7/11.
 * Time: 11:06.
 */
public class MailConvert {

    public static final int KEY_PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT = 1;
    public static final int KEY_PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT = 1;

    public static String convertSubject(int key) {
        switch (key) {
            case KEY_PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT:
                return PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT;
            default:
                return "通行银行适配器系统邮件";
        }
    }

    public static String convertContent(int key) {

        switch (key) {
            case KEY_PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT:
                return PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT;
            default:
                return "系统设定错误，请联系管理员，key：" + key;
        }
    }

    private static final String PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT;
    private static final String PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT;

    static {

        try {
            Configuration configuration = new PropertiesConfiguration("mail/config.properties");
            PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT = new String(configuration.getString("PRODUCT_PUTAWAY_RETRY_TIME_OUT_SUBJECT").getBytes("ISO-8859-1"), "UTF-8");
            PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT = new String(configuration.getString("PRODUCT_PUTAWAY_RETRY_TIME_OUT_CONTENT").getBytes("ISO-8859-1"), "UTF-8");
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
