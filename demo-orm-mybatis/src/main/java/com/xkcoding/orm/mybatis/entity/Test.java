package com.xkcoding.orm.mybatis.entity;

import cn.hutool.core.collection.CollUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * <p>
 * <a href="Test.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/6/20 9:45
 */
public class Test {
  static Map<Integer, String> USER_FINANCE_THIRD_STATUS_MAP = new HashMap<>(4) {
    {
    put(0, "入獄");
    put(1, "待破產");
    put(2, "死亡");
    put(3, "破產");
  }};

  public static void main(String[] args) {
    YesNoNumEnum imprisonment = YesNoNumEnum.YES;
    YesNoNumEnum bankruptAwait = YesNoNumEnum.YES;
    YesNoNumEnum death = null;
    YesNoNumEnum bankrupt = null;
    StringJoiner stringJoiner = new StringJoiner("、");
    if (YesNoNumEnum.YES.equals(imprisonment)){
      stringJoiner.add(USER_FINANCE_THIRD_STATUS_MAP.get(0));
    }
    if (YesNoNumEnum.YES.equals(bankruptAwait)){
      stringJoiner.add(USER_FINANCE_THIRD_STATUS_MAP.get(1));
    }
    if (YesNoNumEnum.YES.equals(death)){
      stringJoiner.add(USER_FINANCE_THIRD_STATUS_MAP.get(2));
    }
    if (YesNoNumEnum.YES.equals(death)){
      stringJoiner.add(USER_FINANCE_THIRD_STATUS_MAP.get(3));
    }

    System.out.println(stringJoiner.toString());



//    CapitalAccountingRecord capitalAccountingRecord = new CapitalAccountingRecord();
//    capitalAccountingRecord.setId(888L);
//    capitalAccountingRecord.setRegistrationNumber("r1");
//    capitalAccountingRecord.setOrderType(OrderTypeEnum.PAY_OFFLINE_ORDERS);
//    capitalAccountingRecord.setReverse(YesNoNumEnum.YES);
//
//    CapitalAccountingRecord capitalAccountingRecord1 = new CapitalAccountingRecord();
//    capitalAccountingRecord1.setId(999L);
//    capitalAccountingRecord1.setOrderType(OrderTypeEnum.PAY_OFFLINE_ORDERS);
//    capitalAccountingRecord1.setRegistrationNumber("r1");
//    capitalAccountingRecord1.setReverse(YesNoNumEnum.NO);
//
//    CapitalAccountingRecord capitalAccountingRecord2 = new CapitalAccountingRecord();
//    capitalAccountingRecord2.setId(777L);
//    capitalAccountingRecord2.setOrderType(OrderTypeEnum.PAY_OFFLINE_ORDERS);
//    capitalAccountingRecord2.setRegistrationNumber("r2");
//    capitalAccountingRecord2.setReverse(YesNoNumEnum.NO);
//    List<CapitalAccountingRecord> list = List.of(capitalAccountingRecord,capitalAccountingRecord1,capitalAccountingRecord2);
//    // 过滤出线下付款订单类型的数据, 按照预登记id分组,然后按照红冲标记分组
//    Map<String, Map<YesNoNumEnum, List<CapitalAccountingRecord>>> map = list.parallelStream()
//                                                                            .filter(item -> item.getOrderType() == OrderTypeEnum.PAY_OFFLINE_ORDERS)
//                                                                            .collect(Collectors.groupingBy(CapitalAccountingRecord::getRegistrationNumber,
//                                                                                                           Collectors.groupingBy(CapitalAccountingRecord::getReverse)));
//    map.forEach((key, value) -> {
//      if (CollUtil.isNotEmpty(value)){
//        value.forEach((reverse,list1) ->{
//          System.out.println(key+":"+reverse + ":" + list1);
//        });
//
//      }
//    });
//    System.out.println(Integer.MAX_VALUE *2);
  }
}
