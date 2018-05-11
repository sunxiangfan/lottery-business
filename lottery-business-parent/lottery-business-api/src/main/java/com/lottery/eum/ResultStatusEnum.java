package com.lottery.eum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum ResultStatusEnum {

    SUCCESS("200", "成功"),
    FAIL("9999", "失败");

    private String code;

    private String name;

    private static Map<String, ResultStatusEnum> map = new HashMap<>();

    static {
        Arrays.stream(ResultStatusEnum.values()).forEach(status -> map.put(status.getCode(), status));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ResultStatusEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ResultStatusEnum getByCode(String code) {
        return map.get(code);
    }

}
