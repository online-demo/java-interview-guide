package com.example.interview.guide.chapter5.lock.countdownlatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-24 10:53
 * @Version : V1.0
 * @Description : CountDownLatch使用方式演示
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        // 记录当前时间。
        long now = System.currentTimeMillis();
        // 创建CountDownLatch对象，其初始计数器为2。
        CountDownLatch countDownLatch = new CountDownLatch(2);
        // 企业开发中建议使用ThreadPoolExecutor创建线程池。
        ExecutorService executorService = Executors
                .newFixedThreadPool(2);
        try {
            // 并发执行看病和排队的任务。
            executorService.execute(new BuyPopcornTask(countDownLatch));
            executorService.execute(new BuyMovieTicketsTask(countDownLatch));
            // 等待其他线程完成各自的工作后再执
            countDownLatch.await();
            System.out.println(printDate() + "电影票和爆米花都买到了，总共耗时:"
                    + (System.currentTimeMillis() - now));
        } finally {
            executorService.shutdown();
        }
    }

    /**
     * 返回时间字符串。
     * @return 时间
     */
    public static String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date()) + " ";
    }
}
