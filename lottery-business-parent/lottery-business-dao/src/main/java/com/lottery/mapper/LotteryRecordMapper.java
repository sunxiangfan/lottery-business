package com.lottery.mapper;

import com.lottery.entity.LotteryRecordBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LotteryRecordMapper {

    int insertSelective(LotteryRecordBean record);

    int updateByPrimaryKeySelective(LotteryRecordBean record);

    List<LotteryRecordBean> findByEntity(LotteryRecordBean record);

    LotteryRecordBean findByPrimaryKey(String id);
}
