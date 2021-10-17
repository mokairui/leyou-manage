package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
public class LyException extends RuntimeException{

    private ExceptionEnum exceptionEnum;

    public LyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }
}
