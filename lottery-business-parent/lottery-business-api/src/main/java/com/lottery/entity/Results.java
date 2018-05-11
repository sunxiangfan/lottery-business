package com.lottery.entity;


import com.lottery.eum.ResultStatusEnum;
import lombok.Data;

@Data
public class Results {

    private String code;
    private Object data;
    private String message;

    public static Results success(Object data){
        Results result = new Results();
        result.setCode(ResultStatusEnum.SUCCESS.getCode());
        result.setMessage(ResultStatusEnum.SUCCESS.getName());
        result.setData(data);
        return result;
    }

    public static Results fail(String message,Object data){
        Results result = new Results();
        result.setCode(ResultStatusEnum.SUCCESS.getCode());
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
