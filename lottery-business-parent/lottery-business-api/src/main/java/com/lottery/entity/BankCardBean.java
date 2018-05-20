package com.lottery.entity;

import lombok.Data;
import java.io.Serializable;
@Data
public class BankCardBean implements Serializable {
    private String id;
    private String userId;
    private String cardNum;
    private String cardHolder;
}