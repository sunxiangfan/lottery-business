package com.lottery.service;

//import com.lottery.common.ValidateCode;
import com.lottery.dto.UserInfoDTO;
import com.lottery.dto.ValidateCodeDTO;

import java.util.Map;


/**
 * 注册
 * 1.生成图片验证码
 * 2.验证用户名是否为手机号
 * 3.验证用户名是否重复  用注解
 * 4.验证验证码是否正确
 * 5.密码用MD5加密,16位以内
 * 6.添加
 * 7.找回密码?
 */
public interface RegisterService {

    //生成验证码
    //ValidateCode createValidateCode(ValidateCodeDTO v);
    //验证用户名是否重复
    Boolean verifyUserNameRepeat(String s);
    //验证验证码是否正确
    Boolean verifyValidateCode(String s);
    //添加用户
    int insertUserInfo(UserInfoDTO u) throws Exception;

}
