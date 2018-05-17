package com.lottery.controller;

import com.lottery.common.SecureUtil;
import com.lottery.common.ValidationUtils;
import com.lottery.config.JwtHelper;
import com.lottery.dto.LoginDTO;
import com.lottery.dto.UserInfoDTO;
import com.lottery.entity.Results;
import com.lottery.entity.UserInfoBean;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Value("${jwt.secret-key}")
    private String jwtSecretKey;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/user/login", method = {RequestMethod.POST})
    public Results findUserInfoById(@RequestBody LoginDTO body) {
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                UserInfoBean bean = new UserInfoBean();
                bean.setLoginName(body.getLoginName());
                UserInfoBean userInfo = userInfoService.findUserInfo(bean);
                if(null == userInfo){
                    results = Results.fail("用户不存在！");
                    return results;
                }
                if(!SecureUtil.checkpassword(body.getLoginPswd(),bean.getLoginPswd())){
                    results = Results.fail("密码不正确！");
                    return results;
                }
                String token = JwtHelper.createJWT(bean.getUserId(),body.getLoginName(),jwtSecretKey);
                results = Results.success(token);
            } catch (Exception e) {
                log.error("登录失败！", e);
                results = Results.fail("登录失败！");
            }
        }
        return results;
    }

    @RequestMapping(value = "/test/test", method = {RequestMethod.POST})
    public Results test(@RequestBody UserInfoDTO body) {

        return Results.success("22222222222222");
    }
}
