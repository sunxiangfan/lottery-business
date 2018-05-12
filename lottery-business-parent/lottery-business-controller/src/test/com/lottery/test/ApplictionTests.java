package com.lottery.test;

import com.lottery.entity.UserInfoBean;
import com.lottery.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplictionTests {

    @Autowired
    private RedisService service;

    @Test
    public void contextLoads() {
        UserInfoBean user = new UserInfoBean();
        user.setId("1");
        user.setLoginName("sxf");
        service.add("123456", user, (long) 5000);
        log.info("RedisTest执行完成，return {}", service.get("123456"));
    }
}