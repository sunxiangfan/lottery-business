package com.lottery.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class UserInfoBean implements Serializable {
    private String userId;
    private String loginName;
    private String loginPswd;
    private String pUserId;
    private String isLock;
    private Date lockTime;
    private Date createTime;
}
