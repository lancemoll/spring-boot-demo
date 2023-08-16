package com.xkcoding.test;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

// lombok
@SuperBuilder
@Data
class POJO1 {
    String id;
    // 仅做示例，省略其他字段
}

@SuperBuilder
@Data
class POJO2 extends POJO1 {
    String note;
}

class App {
    public static void main(String[] args) {
//        // 简单的 builder 实现
//        POJO2 b = POJO2.builder()
//                // 不包含id(String id)方法
//                .note("this is pojo b").build();
//        b.setId("001");
//        // ...
//        // 还有个问题：没有默认构造器了，解决方法：重写构造器

      Random random = new Random();
      List<Integer> list = random.ints(6L).boxed().collect(Collectors.toList());
      System.out.println("list = " + list);
    }
}
