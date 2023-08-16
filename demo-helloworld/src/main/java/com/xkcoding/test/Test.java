package com.xkcoding.test;

import cn.hutool.core.util.RandomUtil;
import com.xkcoding.deadlock.Account;

import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * <p>
 * <a href="Test.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/1/5 11:27
 */
public class Test {
//    public static String getUserNameOrPassword(int len) {
//        ThreadLocalRandom rand = RandomUtil.getRandom();
//        int number = rand.nextInt(len) + 1;
//        StringBuilder str = new StringBuilder();
//        for (int i = 0; i < number; i++) {
//            if (i % 3 == 0) {
//                str.append((char) (Math.random() * 26 + 'A'));
//            } else {
//                str.append((char) (Math.random() * 26 + 'a')); //生成随机小写字母
//            }
//        }
//        String num = String.valueOf(370436256377495554L).substring(8);
//        str.append(num);
//        return str.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getUserNameOrPassword(8));
//    }
public static void main(String[] args) {
    Account capitalAccountInfo = new Account();
    capitalAccountInfo.setUserId(1L);

    Account capitalAccountInfo1 = new Account();
    capitalAccountInfo1.setUserId(2L);

    List<Account> list = new ArrayList<>(){{
        add(capitalAccountInfo);
        add(null);
    }};
    Set<Long> collect = list.stream().filter(Objects::nonNull).map(item -> item.getUserId()).collect(Collectors.toSet());
    System.out.println(collect);
}

  // 外部迭代
  @NotNull
  public static Map<String, Integer> map2(String[] words) {
    Map<String, Integer> counts = new HashMap<>();
    for (String word : words) {
      counts.merge(word, 1, Integer::sum);
    }
    return counts;
  }

  @NotNull
  public static Map<String, Integer> map2_(String[] words) {
    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
        map.merge(word, 1, Integer::sum);
    }
    return map;
  }
/*
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        test(() -> {
            System.out.println("进入到test之前"+ Thread.currentThread().getName());
            System.out.println(1 +1 );
        });
    }
    public static void test(Runnable runnable){
        System.out.println("进入到test内"+ Thread.currentThread().getName());
        runnable.run();
    }
*/

}
