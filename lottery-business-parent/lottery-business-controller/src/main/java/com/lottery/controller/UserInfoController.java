package com.lottery.controller;

import com.lottery.service.UserInfoService;
import com.lottery.dto.UserInfoDTO;
import com.lottery.entity.Results;
import com.lottery.entity.UserInfoBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/user/findUserInfoById", method = {RequestMethod.POST})
    public Results findUserInfoById(@RequestBody UserInfoDTO body) {
        Results results = null;
        try {
            UserInfoBean userInfo = userInfoService.findUserInfoById(body.getUserId());
            results = Results.success(userInfo);
        }catch (Exception e){
            log.error("查询用户信息失败！",e);
            results = Results.fail("查询用户信息失败！");
        }
        return results;
    }
}
