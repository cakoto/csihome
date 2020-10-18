package com.hy.csi.home.service.base.result;

import lombok.Getter;
import lombok.ToString;

/**
 * @author gyf
 * @since 2020/10/18
 * 统一返回数据
 */
@Getter
@ToString
public enum ResultCodeEnum {
    SUCCESS(true, 20000,"成功"),
    UNKNOWN_REASON(false, 20001, "未知错误"),
    LOGIN_AUTH(false, 20003, "需要登录"),
    LOGIN_ERROR(false, 20004, "账号不正确"),
    LOGIN_ACL(false, 20005, "没有权限");


    private Boolean success;

    private Integer code;

    private String message;

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
