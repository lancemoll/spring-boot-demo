package com.xkcoding.pay.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils {

    private static ExecutorService executor;

    static {
        /**
         * 构建一个线程池
         * 获取服务器CPU的核数：Runtime.getRuntime().availableProcessors()
         * 线程池定义大小：CPU * 2 + 1
         */
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2 + 1,
                                          Runtime.getRuntime().availableProcessors() * 2 + 1,
                                          0L, TimeUnit.MILLISECONDS,
                                          new LinkedBlockingQueue(10000));
    }
    /**
     * 线程池中线程执行任务
     */
    public static void execute(Runnable task) {
        executor.execute(task);
    }

}
