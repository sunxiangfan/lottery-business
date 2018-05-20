package com.lottery.service;

import com.lottery.entity.BankCardBean;

import java.util.List;

public interface BankCardService {
    int insertSelective(BankCardBean bank);

    int updateByPrimaryKeySelective(BankCardBean bank);

    List<BankCardBean> findByEntity(BankCardBean bank);

    BankCardBean findByPrimaryKey(String id);
}
