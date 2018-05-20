package com.lottery.service;

import com.lottery.entity.BankCardBean;
import com.lottery.entity.LotteryNumBean;

import java.util.List;

public interface LotteryNumService {
    int insertSelective(LotteryNumBean num);

    int updateByPrimaryKeySelective(LotteryNumBean num);

    List<LotteryNumBean> findByEntity(LotteryNumBean num);

    LotteryNumBean findByPrimaryKey(String id);
}
