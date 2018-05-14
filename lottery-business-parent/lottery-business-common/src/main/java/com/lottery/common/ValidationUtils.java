package com.lottery.common;

import com.lottery.entity.Results;
import com.lottery.eum.ResultStatusEnum;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.groups.Default;
import java.util.Set;

public class ValidationUtils {

    private static javax.validation.Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> Results validateEntity(T obj) {
        Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
        if (CollectionUtils.isNotEmpty(set)) {
            for (ConstraintViolation<T> cv : set) {
                return  Results.fail(ResultStatusEnum.FAIL.getCode(),cv.getMessage());
            }
        }
        return Results.success(ResultStatusEnum.SUCCESS.getCode());
    }
}