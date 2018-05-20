package com.lottery.service;


import com.lottery.entity.LotteryRecordBean;
import java.util.List;

public interface LotteryRecordService {
    int insertSelective(LotteryRecordBean record);

    int updateByPrimaryKeySelective(LotteryRecordBean record);

    List<LotteryRecordBean> findByEntity(LotteryRecordBean record);

    LotteryRecordBean findByPrimaryKey(String id);
}
