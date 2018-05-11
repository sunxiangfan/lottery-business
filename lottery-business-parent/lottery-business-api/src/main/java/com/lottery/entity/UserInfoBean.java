package com.lottery.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserInfoBean implements Serializable {

    private String id;
    private String loginName;
}
