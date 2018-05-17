package com.lottery.service;


import com.lottery.entity.UserInfoBean;

public interface UserInfoService{

    UserInfoBean findUserInfoById(String id);

    UserInfoBean findUserInfo(UserInfoBean bean);

    void insertUserInfo(UserInfoBean bean);
}
