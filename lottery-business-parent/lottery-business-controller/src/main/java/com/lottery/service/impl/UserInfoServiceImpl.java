package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.entity.UserInfoBean;
import com.lottery.mapper.UserInfoMapper;
import com.lottery.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfoBean findUserInfoById(String id) {
        return userInfoMapper.findUserInfoById(id);
    }

    @Override
    public UserInfoBean findUserInfo(UserInfoBean bean) {
        return userInfoMapper.findUserInfo(bean);
    }

    @Override

    public void insertUserInfo(UserInfoBean bean) {
        userInfoMapper.insertUserInfo(bean);
    }
}