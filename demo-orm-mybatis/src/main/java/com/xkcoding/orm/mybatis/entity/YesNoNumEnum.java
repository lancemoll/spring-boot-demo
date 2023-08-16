package com.xkcoding.orm.mybatis.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum YesNoNumEnum {
    NO(0,"否"),
    YES(1,"是");

    YesNoNumEnum(int code, String message) {
        this.code = code;
        this.message = message;
        this.dbCode = code;
    }

    private final Integer code;
    private final String message;
    private final Integer dbCode;
}
