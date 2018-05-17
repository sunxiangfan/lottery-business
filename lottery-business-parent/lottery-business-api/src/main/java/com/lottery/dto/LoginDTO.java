package com.lottery.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Mod11Check;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class LoginDTO {

    @NotEmpty(message = "loginName不能为空!")
    private String loginName;
    @NotEmpty(message = "loginPswd不能为空!")
    private String loginPswd;
}