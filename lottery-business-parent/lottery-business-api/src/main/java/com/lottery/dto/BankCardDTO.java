package com.lottery.dto;

import com.lottery.entity.BankCardBean;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
@Data
public class BankCardDTO{
    private String id;
    private String userId;
    @NotEmpty(message = "cardNum不能为空!")
    private String cardNum;
    private String cardHolder;
}
