package com.lottery.controller;

import com.lottery.common.MD5Utils;
import com.lottery.common.ValidationUtils;
import com.lottery.config.JwtHelper;
import com.lottery.dto.LoginDTO;
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
import org.springframework.web.servlet.ModelAndView;

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
                if(!MD5Utils.EncoderByMd5(body.getLoginPswd()).equals(userInfo.getLoginPswd())){
                    results = Results.fail("密码不正确！");
                    return results;
                }
                String token = JwtHelper.createJWT(bean.getUserId(),body.getLoginName(),jwtSecretKey);
                System.out.println(token+"-----------------------");
                results = Results.success(token);
            } catch (Exception e) {
                log.error("登录失败！", e);
                results = Results.fail("登录失败！");
            }
        }
        return results;
    }
}
