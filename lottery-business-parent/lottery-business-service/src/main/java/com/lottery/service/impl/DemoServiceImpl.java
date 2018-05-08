package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.service.DemoService;


@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    /**
     *
     */
    private static final long serialVersionUID = -6591900875272367270L;


    @Override
    public String SayHi(String name) {
        return "hi,provider:"+name;
    }  
} 