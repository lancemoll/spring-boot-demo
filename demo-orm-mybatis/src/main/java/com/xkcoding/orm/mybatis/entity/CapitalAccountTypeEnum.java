package com.xkcoding.orm.mybatis.entity;

import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 * <a href="CapitalAccountTypeEnum.java"><i>View Source</i></a>
 *
 * @author Conan.chen
 * Date: 2022/11/3 17:42
 */
@ToString
@Getter
public enum CapitalAccountTypeEnum{
    //（0、现金账户，1、冻结账户，2、收款账户 3、营销账户 4、手续费账户 5、分润账户 6、付款賬戶（8888） 8、外部账户 9、金融账户 10、待结算账户 11、结算账户）
    CASH_ACCOUNT(0, "現金賬戶"),
    FROZEN_ACCOUNT(1, "凍結賬戶"),
    RECEIVE_ACCOUNT(2, "收款賬戶"),
    MARKETING_ACCOUNT(3, "營銷賬戶"),
    FEE_ACCOUNT(4, "手續費賬戶"),
    DIVIDEND_ACCOUNT(5, "分潤賬戶"),
    PAYMENT_ACCOUNT(6, "付款賬戶"),
    //    PAYMENT_TO_BE_SETTLED_ACCOUNT(7,"支付待結算賬戶"),
    EXTERNAL_ACCOUNT(8, "外部賬戶"),

    FINANCE_ACCOUNT(9, "金融賬戶"),
    AWAIT_SETTLEMENT_ACCOUNT(10, "待結算賬戶"),
    SETTLEMENT_ACCOUNT(11, "結算賬戶"),
    CHANNEL_RECEIVE_ACCOUNT(12, "渠道收款賬戶"),
    CHANNEL_FEE_ACCOUNT(13, "渠道手續費賬戶"),
    CHANNEL_SETTLEMENT_ACCOUNT(14, "渠道結算賬戶");


    private final Integer code;
    private final Integer dbCode;
    private final String message;

    CapitalAccountTypeEnum(Integer code, String msg) {
        this.code = code;
        this.dbCode = code;
        this.message = msg;
    }

}
