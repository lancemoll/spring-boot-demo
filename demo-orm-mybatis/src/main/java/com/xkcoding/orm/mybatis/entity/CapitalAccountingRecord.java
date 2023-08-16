package com.xkcoding.orm.mybatis.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 资金账户记账记录
 * </p>
 *
 * @author Conan.chen
 * @since 2022-10-20
 */
@Data
@ToString
public class CapitalAccountingRecord implements Serializable {



    /**
     * 主键ID
     */
    private Long id;

    /**
     * 事件ID
     */
    private Long eventId;
    /**
     * 来源id: 清分记录id,转账id
     */
    private Long sourceId;


    /**
     * 店铺ID服務商ID平台ID
     */
    private Long businessId;

    /**
     * 业务编号
     */
    private String businessNumber;

    /**
     * 店铺名称服務商名稱平台名称
     */
    private String businessName;

    /**
     * 账户ID
     */
    private Long accountId;

    /**
     * 账户账户 500开头，共11位数，服务商账户 700开头，平台账户 600开头
     */
    private String accountNumber;

    /**
     * 资金账户ID
     */
    private Long capitalAccountId;

    /**
     * 资金账户类型字典account_account_type（0、现金账户，1、冻结账户，2、收款账户 3、营销账户 4、手续费账户 5、分润账户 6、备付金账户 8、外部账户 9、金融账户 10、待结算账户 11、结算账户,12.渠道收款賬戶,13.渠道手續費賬戶,14.渠道結算賬戶）
     */
    private CapitalAccountTypeEnum capitalAccountType;

    /**
     * 订单类型
     */
    private OrderTypeEnum orderType;
    /**
     * 预登记id
     */
    private Long registrationId;
    /**
     * 预登记number
     */
    private String registrationNumber;
    /**
     * 业务id(预登记/付款/退款申请id)
     */
    private Long bizId;
    /**
     * 业务编号(预登记/付款/退款申请id关联的number)
     */
    private String bizNumber;
    /**
     * 訂單創建時間
     */
    private Date bizTime;

    /**
     * 支付渠道編號
     */
    private String channelNumber;
    /**
     * 支付渠道名稱
     */
    private String channelName;


    /**
     * 明细金额
     */
    private BigDecimal amountDetail;

    /**
     * 当前账户余额
     */
    private BigDecimal amountNow;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建者id
     */
    private String createBy;

    /**
     * 更新者id
     */
    private String updateBy;

    /**
     * 币种ID
     */
    private Long currencyTypeId;


    /**
     * 是否红冲[0：不红冲，1：红冲]
     */
    private YesNoNumEnum reverse;
    /**
     * 备注
     */
    private String memo;

}
