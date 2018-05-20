package com.lottery.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class LotteryRecordBean implements Serializable {
    private String id;
    private String userId;
    private String lotteryCode;
    private String purchaseNum;
    private String lotteryPeriods;
    private Integer multiple;
    private BigDecimal lotteryAmount;
    private String status;
    private String prizeStatus;
    private Date time;
}