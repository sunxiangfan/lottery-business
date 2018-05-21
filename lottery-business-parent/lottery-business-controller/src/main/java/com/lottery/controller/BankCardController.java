package com.lottery.controller;

import com.lottery.common.UUIDUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.BankCardDTO;
import com.lottery.entity.BankCardBean;
import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.BankCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bankCard")
public class BankCardController {
    @Autowired
    private BankCardService bankCardService;

    @PostMapping("/insert")
    public Results insertSelective(@RequestBody BankCardDTO body) {
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                BankCardBean bankCardBean = new BankCardBean();
                bankCardBean.setId(UUIDUtils.getUUID());
                bankCardBean.setCardHolder(body.getCardHolder());
                bankCardBean.setCardNum(body.getCardNum());
                bankCardBean.setUserId(body.getUserId());
                int count = bankCardService.insertSelective(bankCardBean);
            } catch (Exception e) {
                log.error("添加银行卡信息失败！", e);
                results = Results.fail("添加银行卡信息失败！");
            }
        }
        return results;
    }
    @PostMapping("/update")
    public Results updateByPrimaryKeySelective(@RequestBody BankCardDTO body){
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                BankCardBean bankCardBean = new BankCardBean();
                bankCardBean.setId(body.getId());
                bankCardBean.setCardHolder(body.getCardHolder());
                bankCardBean.setCardNum(body.getCardNum());
                bankCardBean.setUserId(body.getUserId());
                int count = bankCardService.updateByPrimaryKeySelective(bankCardBean);
            } catch (Exception e) {
                log.error("修改银行卡信息失败！", e);
                results = Results.fail("修改银行卡信息失败！");
            }
        }
        return results;
    }
    @PostMapping("/findByEntity")
    public Results findByEntity(@RequestBody BankCardDTO body){
        Results results;
        try {
            BankCardBean bankCardBean = new BankCardBean();
            bankCardBean.setId(body.getId());
            bankCardBean.setCardHolder(body.getCardHolder());
            bankCardBean.setCardNum(body.getCardNum());
            bankCardBean.setUserId(body.getUserId());
            List<BankCardBean> list = bankCardService.findByEntity(bankCardBean);
            results = Results.success(list);
        } catch (Exception e) {
            log.error("查询银行卡信息失败！", e);
            results = Results.fail("查询银行卡信息失败！");
        }
        return results;
    }
    @PostMapping("/findByPrimaryKey")
    public Results findByPrimaryKey(@RequestBody BankCardDTO body){
        Results results;
        try {
            BankCardBean bank = bankCardService.findByPrimaryKey(body.getId());
            results = Results.success(bank);
        } catch (Exception e) {
            log.error("查询银行卡信息失败！", e);
            results = Results.fail("查询银行卡信息失败！");
        }
        return results;
    }

}
