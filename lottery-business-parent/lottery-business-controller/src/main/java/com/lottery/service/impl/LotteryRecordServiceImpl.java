package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.entity.LotteryRecordBean;
import com.lottery.mapper.LotteryRecordMapper;
import com.lottery.service.LotteryRecordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0.0")
public class LotteryRecordServiceImpl implements LotteryRecordService{
    @Autowired
    private LotteryRecordMapper lotteryRecordMapper;

    @Override
    public int insertSelective(LotteryRecordBean record) {
        return lotteryRecordMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(LotteryRecordBean record) {
        return lotteryRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<LotteryRecordBean> findByEntity(LotteryRecordBean record) {
        return lotteryRecordMapper.findByEntity(record);
    }

    @Override
    public LotteryRecordBean findByPrimaryKey(String id) {
        return lotteryRecordMapper.findByPrimaryKey(id);
    }
}
