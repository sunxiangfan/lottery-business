package com.lottery.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lottery.common.UUIDUtils;
import com.lottery.entity.BankCardBean;
import com.lottery.mapper.BankCardMapper;
import com.lottery.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
@Service(version = "1.0.0")
public class BankCardServiceImpl implements BankCardService{
    @Autowired
    private BankCardMapper bankCardMapper;
    @Override
    public int insertSelective(BankCardBean record) {
        return bankCardMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(BankCardBean bank) {
        return bankCardMapper.updateByPrimaryKeySelective(bank);
    }

    @Override
    public List<BankCardBean> findByEntity(BankCardBean bank) {
        return bankCardMapper.findByEntity(bank);
    }

    @Override
    public BankCardBean findByPrimaryKey(String id) {
        return bankCardMapper.findByPrimaryKey(id);
    }
}
