package com.lottery.entity;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;

import java.io.Serializable;


@Data
public class UserInfoBean implements Serializable {

    private String id;
    private String loginName;
}
