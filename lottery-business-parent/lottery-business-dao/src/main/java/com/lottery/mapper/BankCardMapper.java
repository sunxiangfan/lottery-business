package com.lottery.mapper;

import com.lottery.entity.BankCardBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BankCardMapper {

    int insertSelective(BankCardBean bank);

    int updateByPrimaryKeySelective(BankCardBean bank);

    List<BankCardBean> findByEntity(BankCardBean bank);

    BankCardBean findByPrimaryKey(String id);
}
