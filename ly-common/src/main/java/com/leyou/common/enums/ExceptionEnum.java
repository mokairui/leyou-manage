package com.leyou.common.enums;

import lombok.Getter;

/**
 * @Description
 * @Author Mokairui
 * @Since 2021/10/17
 */
@Getter
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(404, "价格不能为空!"),
    BRAND_NOT_FOUND(404, "品牌未查到"),
    SPEC_GROUP_NOT_FOUND(404, "商品规格说明未查询到"),
    SPEC_PARAM_NOT_FOUND(404, "商品规格参数未查询到"),
    GOODS_NOT_FOUND(404, "商品未查询到"),
    CATEGORY_NOT_FOUND(404, "商品分类未查询到"),

    BRAND_SAVE_ERROR(500, "品牌添加失败"),
    UPLOAD_FILE_ERROR(500, "上传文件失败"),
    INVALID_FILE_TYPE(500, "无效的文件类型");

    private int code;
    private String message;

    ExceptionEnum() {
    }

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
