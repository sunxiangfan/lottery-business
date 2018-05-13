package com.lottery.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ValidateCodeDTO  implements Serializable {
    // 图片的宽度。
    private int width;
    // 图片的高度。
    private int height;
    // 验证码字符个数
    private int codeCount;
    // 验证码干扰线数
    private int lineCount;
}
