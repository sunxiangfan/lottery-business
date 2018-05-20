package com.lottery.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class LotteryNumBean implements Serializable {
    private String id;
    private String lotteryCode;
    private String lotteryNum;
    private String lotteryPeriods;
    private Date time;
}