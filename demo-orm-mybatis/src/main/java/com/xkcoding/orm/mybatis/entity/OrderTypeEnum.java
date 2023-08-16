package com.xkcoding.orm.mybatis.entity;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * <p>
 * <a href="OrderTypeEnum.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/2/20 19:58
 */
@Getter
public enum OrderTypeEnum {
    PAYMENT(1, "消費訂單"),
    REFUND(2, "退款訂單"),
    REPAYMENT(3, "付款訂單"),

    MERCHANT_SETTLEMENT(4, "商戶結算"),

    VENDOR_SETTLEMENT(5, "服務商結算"),
    PAYMENT_INSTITUTION_SETTLEMENT(6, "支付機構結算"),

    PAY_OFFLINE_ORDERS(7, "線下付款訂單");

    OrderTypeEnum(int code, String desc) {
        this.code = code;
        this.message = desc;
        this.dbCode = code;
    }

    /**
     * code
     */
    private Integer code;
    /**
     * 描述
     */
    private String message;
    /**
     * 数据库存储
     */
    private Integer dbCode;

}
