package com.lottery.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class SecureUtil {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 算法常量： MD5
     */
    private static final String ALGORITHM_MD5 = "MD5";

    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws Exception{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance(ALGORITHM_MD5);
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    /**
     * 判断用户密码是否正确
     * newpasswd 用户输入的密码
     * oldpasswd 正确密码
     */
    public static boolean checkpassword(String newpasswd,String oldpasswd) throws Exception{
        if(EncoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }

}
