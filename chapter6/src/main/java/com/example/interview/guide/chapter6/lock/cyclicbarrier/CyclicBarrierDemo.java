package com.example.interview.guide.chapter6.lock.cyclicbarrier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-25 11:48
 * @Version : V1.0
 * @Description : CyclicBarrier使用方式演示
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,
                new TourDriverTask());
        // 企业开发中建议使用ThreadPoolExecutor创建线程池。
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            //旅游团3人先后到达指定集合地点。
            executor.execute(new TravelTask(cyclicBarrier, "张三", 5));
            executor.execute(new TravelTask(cyclicBarrier, "李四", 3));
            executor.execute(new TravelTask(cyclicBarrier, "王五", 1));
        } finally {
            executor.shutdown();
        }
    }

    /**
     * 获取当前时间。
     *
     * @return 当前时间
     */
    static String printDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
