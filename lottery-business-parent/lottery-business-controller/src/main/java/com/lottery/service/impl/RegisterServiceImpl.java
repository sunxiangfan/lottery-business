package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.common.SecureUtil;
import com.lottery.common.ValidateCode;
import com.lottery.dto.UserInfoDTO;
import com.lottery.dto.ValidateCodeDTO;
import com.lottery.mapper.UserInfoMapper;
import com.lottery.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserInfoMapper userInfoMapper;

    //生成验证码
//    @Override
//    public ValidateCode createValidateCode(ValidateCodeDTO v) {
//        ValidateCode validateCode = new ValidateCode(v.getWidth(), v.getHeight(), v.getCodeCount(), v.getLineCount());
//        //获取jwt放入redis中,用于验证码验证
//        return validateCode;
//    }

    //验证用户名是否重复
    @Override
    public Boolean verifyUserNameRepeat(String s) {
        Long c = userInfoMapper.verifyUserNameRepeat(s);
        if (0l == c) {
            return true;
        } else {
            return false;
        }
    }

    //验证验证码
    @Override
    public Boolean verifyValidateCode(String s) {
        //从redis中或去jwt比较验证码
        //if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {}  //忽略验证码大小写
        return null;
    }

    //添加用户
    @Override
    public int insertUserInfo(UserInfoDTO u) throws Exception {
        //md5加密
        u.setLoginPswd(SecureUtil.EncoderByMd5(u.getLoginPswd()));
        int count = userInfoMapper.insertUserInfo(u);
        /**
         * 添加成功redis中注销jwt
         */
        return count;
    }
}
