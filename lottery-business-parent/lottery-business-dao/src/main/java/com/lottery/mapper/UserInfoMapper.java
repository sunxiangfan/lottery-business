package com.lottery.mapper;

import com.lottery.entity.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {

    UserInfoBean findUserInfoById(@Param("id") String id);

    UserInfoBean findUserInfo(UserInfoBean bean);

    void insertUserInfo(UserInfoBean bean);
}
