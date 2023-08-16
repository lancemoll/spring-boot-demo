package com.xkcoding.orm.mybatis.entity;

/**
 * 备注信息
 *
 * <p>
 * <a href="BaseMemo.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/7/12 23:10
 */

import cn.hutool.json.JSONUtil;
import lombok.Builder;
import lombok.Data;

@Data
public class BaseMemo {
    /**
     * 1、是否自動：定義：系統自動任務扣款都屬於是自動，其他都屬於非自動
     */
    private Boolean automatic;
    /**
     * 2、是否人工：定義：業務人員錄入都是人工，其他都屬於非人工
     */
    private Boolean artificial;
    /**
     * 3、是否線上：定義：線上直接都的在線渠道，其他非在線渠道都屬於線下
     */
    private Boolean online;
    /**
     * 4、是否核銷：定義：是否觸發核銷狀態，已觸發核銷業務為是，其他都為否
     */
    private Boolean verification;

    /**
     * 识别号
     */
    private String identificationNumber;

    /**
     * 收款银行账户编号
     */
    private String receivingBankAccountNumber;
    /**
     * 收款账户关联的公司银行id
     */
    private String receivingBankAccountId;
    /**
     * 银行名称
     */
    private String bankName;

  public static void main(String[] args) {
    BaseMemo baseMemo = new BaseMemo();
    baseMemo.setAutomatic(false);
    baseMemo.setArtificial(false);
    baseMemo.setOnline(true);
    baseMemo.setVerification(false);
    String jsonStr = JSONUtil.toJsonStr(baseMemo);
    System.out.println(JSONUtil.toJsonStr(baseMemo));
  }
}
