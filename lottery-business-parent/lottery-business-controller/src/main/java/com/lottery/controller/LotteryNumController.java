package com.lottery.controller;

import com.lottery.common.UUIDUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.BankCardDTO;
import com.lottery.dto.LotteryNumDTO;
import com.lottery.entity.LotteryNumBean;
import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.LotteryNumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lotteryNum")
public class LotteryNumController {
    @Autowired
    private LotteryNumService lotteryNumService;

    @PostMapping("/insert")
    public Results insertSelective(@RequestBody LotteryNumDTO body){
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                LotteryNumBean lotteryNumBean = new LotteryNumBean();
                lotteryNumBean.setId(UUIDUtils.getUUID());
                lotteryNumBean.setLotteryCode(body.getLotteryCode());
                lotteryNumBean.setLotteryNum(body.getLotteryNum());
                lotteryNumBean.setLotteryPeriods(body.getLotteryPeriods());
                lotteryNumService.insertSelective(lotteryNumBean);
            } catch (Exception e) {
                log.error("开奖信息添加失败",e);
                results = Results.fail("开奖信息添加失败");
            }
        }
        return results;
    }

    @PostMapping("/update")
    public Results updateByPrimaryKeySelective(@RequestBody LotteryNumDTO body){
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                LotteryNumBean lotteryNumBean = new LotteryNumBean();
                lotteryNumBean.setId(body.getId());
                lotteryNumBean.setLotteryCode(body.getLotteryCode());
                lotteryNumBean.setLotteryNum(body.getLotteryNum());
                lotteryNumBean.setLotteryPeriods(body.getLotteryPeriods());
                lotteryNumService.updateByPrimaryKeySelective(lotteryNumBean);
            } catch (Exception e) {
                log.error("修改开奖信息失败",e);
                results = Results.fail("修改开奖信息失败");
            }
        }
        return results;
    }

    @PostMapping("/findByEntity")
    public Results findByEntity(@RequestBody LotteryNumDTO body){
        Results results;
        try {
            LotteryNumBean lotteryNumBean = new LotteryNumBean();
            lotteryNumBean.setId(body.getId());
            lotteryNumBean.setLotteryCode(body.getLotteryCode());
            lotteryNumBean.setLotteryNum(body.getLotteryNum());
            lotteryNumBean.setLotteryPeriods(body.getLotteryPeriods());
            lotteryNumService.updateByPrimaryKeySelective(lotteryNumBean);
            List<LotteryNumBean> list = lotteryNumService.findByEntity(lotteryNumBean);
            results = Results.success(list);
        } catch (Exception e) {
            log.error("查询开奖信息失败！", e);
            results = Results.fail("查询开奖信息失败！");
        }
        return results;
    }
    @PostMapping("/findByPrimaryKey")
    public Results findByPrimaryKey(@RequestBody BankCardDTO body){
        Results results;
        try {
            LotteryNumBean num = lotteryNumService.findByPrimaryKey(body.getId());
            results = Results.success(num);
        } catch (Exception e) {
            log.error("查询开奖信息失败！", e);
            results = Results.fail("查询开奖信息失败！");
        }
        return results;
    }
}
