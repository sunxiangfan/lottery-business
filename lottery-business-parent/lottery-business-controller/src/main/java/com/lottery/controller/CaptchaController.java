package com.lottery.controller;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;
import cn.apiclub.captcha.gimpy.RippleGimpyRenderer;
import cn.apiclub.captcha.text.producer.DefaultTextProducer;
import cn.apiclub.captcha.text.renderer.DefaultWordRenderer;
import cn.apiclub.captcha.text.renderer.WordRenderer;
import com.lottery.common.CookieUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.RegisterDTO;
import com.lottery.entity.Results;

import com.lottery.eum.ResultStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Value("${cookie.name}")
    private String cookieName;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private static int captchaExpires = 5 * 60; // 超时时间5分钟
    private static int captchaW = 65;
    private static int captchaH = 40;
    //private static String cookieName = "CaptchaCode";
    private static int codeCount = 4;   //值得位数
    private static char[] codeNumber = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};     //生成验证码的取值范围

    @RequestMapping(value = "/getCaptcha", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getCaptcha(HttpServletResponse response) {
        String uuid = UUID.randomUUID().toString();
        List<Font> fonts = new ArrayList<Font>();
        List<Color> colors = new ArrayList<Color>();
        fonts.add(new Font("Arial", Font.BOLD, 30));
        colors.add(Color.RED);
        WordRenderer wr = new DefaultWordRenderer(colors, fonts);
        Captcha captcha = new Captcha.Builder(captchaW, captchaH).addText(new DefaultTextProducer(codeCount, codeNumber), wr).
                addBackground(new GradiatedBackgroundProducer()).build();

        // 将验证码以<key,value>形式缓存到redis  
        redisTemplate.opsForValue().set(uuid, captcha.getAnswer(), captchaExpires, TimeUnit.SECONDS);

        // 将验证码key，及验证码的图片返回  
        Cookie cookie = new Cookie(cookieName, uuid);
        response.addCookie(cookie);
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            ImageIO.write(captcha.getImage(), "png", bao);
            return bao.toByteArray();
        } catch (IOException e) {
            log.error("生成验证码失败！", e);
            return null;
        }
    }
}  