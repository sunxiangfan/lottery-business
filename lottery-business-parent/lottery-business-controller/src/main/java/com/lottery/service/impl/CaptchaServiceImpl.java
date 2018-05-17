package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.common.CookieUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.RegisterDTO;
import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;

@Service(version = "1.0.0")
public class CaptchaServiceImpl implements CaptchaService {

    @Value("${cookie.name}")
    private String cookieName;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public Results checkCaptcha(RegisterDTO body, HttpServletRequest request) {
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            String captchaCode = CookieUtils.getCookie(request, cookieName).getValue();
            //redis中查询验证码
            String captchaValue = redisTemplate.opsForValue().get(captchaCode);
            if (captchaValue == null) {
                return Results.fail("验证码不正确！");
            }
            if (captchaValue.compareToIgnoreCase(body.getCaptcha()) != 0) {
                return Results.fail("验证码不正确！");
            }
            //验证码匹配成功，redis则删除对应的验证码
            redisTemplate.delete(captchaCode);
            results = Results.success("");
        }
        return results;
    }
}
