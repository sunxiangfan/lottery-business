package com.lottery.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class RegisterDTO {

    private String pUserId;
    @NotEmpty(message = "loginName不能为空!")
    private String loginName;
    @NotEmpty(message = "loginPswd不能为空!")
    private String loginPswd;
    @NotEmpty(message = "captcha不能为空!")
    private String captcha;
}