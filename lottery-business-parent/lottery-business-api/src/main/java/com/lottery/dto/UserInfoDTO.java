package com.lottery.dto;

import com.lottery.entity.UserInfoBean;
import lombok.Data;
import org.hibernate.validator.constraints.Mod11Check;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;


@Data
public class UserInfoDTO extends UserInfoBean {

    @Mod11Check(message = "loginName不合法!")
    private String loginName;
    @NotEmpty(message = "loginPswd不能为空!")
    private String loginPswd;
    @NotEmpty(message = "pUserId不能为空!")
    private String pUserId;
}
