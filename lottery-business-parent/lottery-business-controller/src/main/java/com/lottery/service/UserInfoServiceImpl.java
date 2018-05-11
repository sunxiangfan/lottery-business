package com.lottery.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.entity.UserInfoBean;
import com.lottery.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public UserInfoBean findUserInfoById(String id) {
        return userInfoMapper.findUserInfoById(id);
    }
}