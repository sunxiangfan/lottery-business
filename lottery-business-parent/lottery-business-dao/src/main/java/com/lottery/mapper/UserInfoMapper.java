package com.lottery.mapper;

import com.lottery.entity.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {

    UserInfoBean findUserInfoById(@Param("id") String id);
}
