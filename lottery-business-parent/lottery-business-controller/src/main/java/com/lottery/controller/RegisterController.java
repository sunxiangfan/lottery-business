package com.lottery.controller;

import com.lottery.common.MD5Utils;
import com.lottery.common.UUIDUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.RegisterDTO;
import com.lottery.entity.Results;
import com.lottery.entity.UserInfoBean;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.CaptchaService;
import com.lottery.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class RegisterController {

    @Autowired
    CaptchaService captchaService;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/user/register", method = {RequestMethod.POST})
    public Results submitOrder(@RequestBody RegisterDTO body, HttpServletRequest request) {
        Results reuslt = ValidationUtils.validateEntity(body);
        if (reuslt.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                //校验用户是否存在
                UserInfoBean bean = new UserInfoBean();
                bean.setLoginName(body.getLoginName());
                UserInfoBean userInfo = userInfoService.findUserInfo(bean);
                if(null != userInfo){
                    return Results.fail("该用户已存在");
                }
                //校验验证码
                reuslt = captchaService.checkCaptcha(body, request);
                if(!reuslt.getCode().equals(ResultStatusEnum.SUCCESS.getCode())){
                    return reuslt;
                }
                //插入用户
                UserInfoBean userInfoBean = new UserInfoBean();
                userInfoBean.setUserId(UUIDUtils.getUUID());
                userInfoBean.setLoginName(body.getLoginName());
                userInfoBean.setLoginPswd(MD5Utils.EncoderByMd5(body.getLoginPswd()));
                userInfoBean.setPUserId(body.getPUserId());
                userInfoService.insertUserInfo(userInfoBean);
                reuslt = Results.success("");
            }catch (Exception e){
                log.error(reuslt.getMessage(),e);
                reuslt = Results.fail("注册失败");
            }
        }
        return reuslt;
    }
}
