package com.xkcoding.pay.config;

import cn.hutool.core.collection.CollUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * <p>
 * <a href="TestThread.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/6/2 14:16
 */
public class TestThread {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("1", "2", "3", "4");
    handleLogin(list);
  }

  public static void handleLogin(List<String> paramList) {
    // 使用线程池中线程分批处理业务逻辑，并行处理任务提高终端响应速度
//    CountDownLatch latch = new CountDownLatch(paramList.size());
    for (String param : paramList) {
      ThreadUtils.execute(() -> {
        try {
          System.out.println("业务逻辑处理，参数：" + param);
//          for (int i = 0; i < 10; i++) {
//            latch.countDown();
//          }
//
//          Thread.sleep(1000);

          // 业务逻辑正常处理......
        } catch (Exception e) {
          System.err.println("调用下游系统出现错误，异常逻辑处理......");
        } finally {
          // 业务逻辑处理完毕，计数器减一【当前线程处理任务完毕，线程释放进入线程池，等待处理下一个任务】
//          latch.countDown();
        }
      });
    }
    // 主线程需要等待子任务线程执行完，结果汇总之后，主线程继续往下执行
    try {
//      latch.await();
    } catch (Exception e) {
      System.out.println("等待超时" + e.getMessage());
      throw new RuntimeException("系统处理超时，请稍后再试");
    }

    System.out.println("执行下面的逻辑");
  }
}
