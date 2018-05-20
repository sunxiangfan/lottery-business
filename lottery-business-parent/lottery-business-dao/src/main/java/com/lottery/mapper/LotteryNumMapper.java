package com.lottery.mapper;

import com.lottery.entity.LotteryNumBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LotteryNumMapper {
    int insertSelective(LotteryNumBean num);

    int updateByPrimaryKeySelective(LotteryNumBean num);

    List<LotteryNumBean> findByEntity(LotteryNumBean num);

    LotteryNumBean findByPrimaryKey(String id);
}
