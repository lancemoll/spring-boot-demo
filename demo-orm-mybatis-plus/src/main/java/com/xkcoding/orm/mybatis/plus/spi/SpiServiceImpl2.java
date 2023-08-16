package com.xkcoding.orm.mybatis.plus.spi;

import java.util.List;

/**
 * <p>
 * <a href="SpiServiceImpl2.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/4/6 14:59
 */
public class SpiServiceImpl2 implements SpiService {
    @Override
    public void execute() {
        System.out.println("SpiServiceImpl2 execute()");
    }
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6);
        list.stream().filter(i -> i % 2 != 0).forEach(System.out::println);

    }
}
