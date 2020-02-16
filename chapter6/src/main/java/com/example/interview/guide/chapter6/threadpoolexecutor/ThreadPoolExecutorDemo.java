package com.example.interview.guide.chapter6.threadpoolexecutor;

import java.util.concurrent.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-03 15:14
 * @Version : V1.0
 * @Description : ThreadPoolExecutor使用方式演示
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        /* 核心线程池的大小 */
        int corePoolSize = 2;
        /* 核心线程池的最大线程数 */
        int maxPoolSize = 4;
        /* 线程最大空闲时间 */
        long keepAliveTime = 10;
        /* 时间单位 */
        TimeUnit unit = TimeUnit.SECONDS;
        /* 阻塞队列 容量为2 */
        BlockingQueue<Runnable> workQueue
                = new ArrayBlockingQueue<>(2);
        /* 线程创建工厂 */
        ThreadFactory threadFactory = new NamedTreadFactory();
        /* 线程池拒绝策略 */
        RejectedExecutionHandler handler = new IgnorePolicy();
        ThreadPoolExecutor executor = null;
        try {
            /* 推荐的创建线程池的方式 */
            executor = new ThreadPoolExecutor(corePoolSize,
                    maxPoolSize, keepAliveTime, unit,
                    workQueue, threadFactory, handler);
            /* 预启动所有核心线程  提升线程池执行效率 */
            executor.prestartAllCoreThreads();
            /* 任务数量 */
            int count = 10;
            // 向线程池提交任务
            for (int i = 1; i <= count; i++) {
                RunnableTask task
                        = new RunnableTask(String.valueOf(i));
                executor.submit(task);
            }
        } finally {
            // 关闭线程池
            assert executor != null;
            executor.shutdown();
        }
    }
}
