package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.entity.LotteryNumBean;
import com.lottery.mapper.LotteryNumMapper;
import com.lottery.service.LotteryNumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service(version = "1.0.0")
public class LotteryNumServiceImpl implements LotteryNumService{
    @Autowired
    private LotteryNumMapper lotteryNumMapper;

    @Override
    public int insertSelective(LotteryNumBean num) {
        return lotteryNumMapper.insertSelective(num);
    }

    @Override
    public int updateByPrimaryKeySelective(LotteryNumBean num) {
        return lotteryNumMapper.updateByPrimaryKeySelective(num);
    }

    @Override
    public List<LotteryNumBean> findByEntity(LotteryNumBean num) {
        return lotteryNumMapper.findByEntity(num);
    }

    @Override
    public LotteryNumBean findByPrimaryKey(String id) {
        return lotteryNumMapper.findByPrimaryKey(id);
    }
}
