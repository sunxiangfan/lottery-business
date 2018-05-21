package com.lottery.controller;

import com.lottery.common.UUIDUtils;
import com.lottery.common.ValidationUtils;
import com.lottery.dto.LotteryRecordDTO;
import com.lottery.entity.LotteryRecordBean;
import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import com.lottery.service.LotteryRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/lotteryRecord")
public class LotteryRecordController {
    @Autowired
    private LotteryRecordService lotteryRecordService;

    @PostMapping("/insert")
    public Results insertSelective(@RequestBody LotteryRecordDTO body) {
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                LotteryRecordBean lotteryRecordBean = new LotteryRecordBean();
                BeanUtils.copyProperties(body,lotteryRecordBean);
                lotteryRecordBean.setId(UUIDUtils.getUUID());
                int count = lotteryRecordService.insertSelective(lotteryRecordBean);
            } catch (Exception e) {
                log.error("添加购彩记录失败！", e);
                results = Results.fail("添加购彩记录失败！");
            }
        }
        return results;
    }
    @PostMapping("/update")
    public Results updateByPrimaryKeySelective(@RequestBody LotteryRecordDTO body){
        Results results = ValidationUtils.validateEntity(body);
        if (results.getCode().equals(ResultStatusEnum.SUCCESS.getCode())) {
            try {
                LotteryRecordBean lotteryRecordBean = new LotteryRecordBean();
                BeanUtils.copyProperties(body,lotteryRecordBean);
                int count = lotteryRecordService.updateByPrimaryKeySelective(lotteryRecordBean);
            } catch (Exception e) {
                log.error("修改购彩记录失败！", e);
                results = Results.fail("修改购彩记录失败！");
            }
        }
        return results;
    }
    @PostMapping("/findByEntity")
    public Results findByEntity(@RequestBody LotteryRecordDTO body){
        Results results;
        try {
            LotteryRecordBean lotteryRecordBean = new LotteryRecordBean();
            BeanUtils.copyProperties(body,lotteryRecordBean);
            List<LotteryRecordBean> list = lotteryRecordService.findByEntity(lotteryRecordBean);
            results = Results.success(list);
        } catch (Exception e) {
            log.error("查询购彩记录失败！", e);
            results = Results.fail("查询购彩记录失败！");
        }
        return results;
    }

    @PostMapping("/findByPrimaryKey")
    public Results findByPrimaryKey(@RequestBody LotteryRecordDTO body){
        Results results;
        try {
            LotteryRecordBean bank = lotteryRecordService.findByPrimaryKey(body.getId());
            results = Results.success(bank);
        } catch (Exception e) {
            log.error("查询购彩记录失败！", e);
            results = Results.fail("查询购彩记录失败！");
        }
        return results;
    }
}
