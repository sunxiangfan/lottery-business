package com.lottery.controller;

import com.lottery.common.ValidationUtils;
import com.lottery.dto.UserInfoDTO;
import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册
 * 1.生成图片验证码
 * 2.验证用户名是否为手机号
 * 3.验证用户名是否重复  用注解
 * 4.验证验证码是否正确
 * 5.密码用MD5加密,16位以内
 * 6.找回密码?
 */
@RestController
public class RegisterController {


    @RequestMapping(value = "/user/register", method = {RequestMethod.POST})
    public Results submitOrder(@RequestBody UserInfoDTO body) {
        Results reuslt = ValidationUtils.validateEntity(body);
        if (reuslt.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {


            return Results.success("");
        }
        return reuslt;
    }
}
