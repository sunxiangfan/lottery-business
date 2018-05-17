package com.lottery.service;

import com.lottery.dto.RegisterDTO;
import com.lottery.entity.Results;

import javax.servlet.http.HttpServletRequest;

public interface CaptchaService {

    /*
     * 说明：
     *    1.captchaCode来自客户端的Cookie，在访问时，通过服务端设置
     *    2.captcha是用户填写的验证码，将用户填写的验证码和通过captchaCode从redis中获取的验证码进行对比即可
     *
     */
    Results checkCaptcha(RegisterDTO body, HttpServletRequest request);
}
