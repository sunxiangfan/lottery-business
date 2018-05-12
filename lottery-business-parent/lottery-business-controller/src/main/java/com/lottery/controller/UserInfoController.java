package com.lottery.controller;

import com.lottery.service.UserInfoService;
import com.lottery.dto.UserInfoDTO;
import com.lottery.entity.Results;
import com.lottery.entity.UserInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/user/userInfo", method = {RequestMethod.POST})
    public Results submitOrder(@RequestBody UserInfoDTO body) {
        UserInfoBean userInfo = userInfoService.findUserInfoById(body.getId());
        return Results.success(userInfo);
    }
}
