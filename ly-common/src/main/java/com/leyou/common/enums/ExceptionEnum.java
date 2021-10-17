package com.leyou.common.enums;

import lombok.Getter;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
@Getter
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400, "价格不能为空!");

    private int code;
    private String message;

    ExceptionEnum() {
    }

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
