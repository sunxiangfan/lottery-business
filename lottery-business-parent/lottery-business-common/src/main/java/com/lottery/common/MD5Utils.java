package com.lottery.common;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5Utils {

    /**
     * 算法常量： MD5
     */
    private static final String ALGORITHM_MD5 = "MD5";

    /**
     * 利用MD5进行加密
     */
    public static String EncoderByMd5(String str) throws Exception {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance(ALGORITHM_MD5);
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newStr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}
