package com.example.interview.guide.chapter5.thread.create.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-19 18:13
 * @Version : V1.0
 * @Description : 使用线程池管理线程
 */
public class ThreadPoolDemo {

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
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        /* 线程创建工厂 */
        ThreadFactory threadFactory = new NameTreadFactory();
        /* 线程池拒绝策略 */
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = null;
        try {
            /* 推荐的创建线程池的方式 */
            /* 不推荐使用现成的API创建线程池 */
            executor = new ThreadPoolExecutor(corePoolSize,
                    maxPoolSize, keepAliveTime, unit,
                    workQueue, threadFactory, handler);
            /* 预启动所有核心线程  提升效率 */
            executor.prestartAllCoreThreads();
            /* 任务数量 */
            int count = 10;
            for (int i = 1; i <= count; i++) {
                RunnableTask task = new RunnableTask(String.valueOf(i));
                executor.submit(task);
            }
        } finally {
            assert executor != null;
            executor.shutdown();
        }

    }

    /**
     * 线程工厂
     */
    static class NameTreadFactory implements ThreadFactory {
        /* 线程id */
        private final AtomicInteger threadId = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            Thread t = new Thread(runnable, "线程-"
                    + threadId.getAndIncrement());
            System.out.println(t.getName() + " 已经被创建");
            return t;
        }
    }

    /**
     * 线程池拒绝策略
     */
    public static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor e) {
            doLog(runnable, e);
        }

        private void doLog(Runnable runnable, ThreadPoolExecutor e) {
            // 可做日志记录等。
            System.err.println(e.toString() +
                    runnable.toString() + " rejected");
        }
    }

    /**
     * 线程
     */
    static class RunnableTask implements Runnable {
        private String name;

        public RunnableTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                //让任务执行慢点。
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "RunnableTask [name=" + name + "]";
        }
    }

}
