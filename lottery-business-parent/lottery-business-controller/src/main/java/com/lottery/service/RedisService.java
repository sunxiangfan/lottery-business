package com.lottery.service;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lottery.entity.UserInfoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void add(String key, UserInfoBean user, Long time) {
        Gson gson = new Gson();
        stringRedisTemplate.opsForValue().set(key, gson.toJson(user), time, TimeUnit.MINUTES);
    }

    public void add(String key, List<UserInfoBean> users, Long time) {
        Gson gson = new Gson();
        String src = gson.toJson(users);
        stringRedisTemplate.opsForValue().set(key, src, time, TimeUnit.MINUTES);
    }

    public UserInfoBean get(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return new Gson().fromJson(source, UserInfoBean.class);
        }
        return null;
    }

    public List<UserInfoBean> getUserList(String key) {
        String source = stringRedisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(source)) {
            return new Gson().fromJson(source, new TypeToken<List<UserInfoBean>>() {
            }.getType());
        }
        return null;
    }
}