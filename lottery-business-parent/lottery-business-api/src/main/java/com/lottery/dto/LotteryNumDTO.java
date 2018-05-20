package com.lottery.dto;

import com.lottery.entity.LotteryNumBean;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
@Data
public class LotteryNumDTO implements Serializable {
    private String id;
    @NotEmpty(message = "彩种不能为空!")
    private String lotteryCode;
    @NotEmpty(message = "开奖号码不能为空!")
    private String lotteryNum;
    @NotEmpty(message = "开奖期数不能为空!")
    private String lotteryPeriods;
    private Date time;
}
