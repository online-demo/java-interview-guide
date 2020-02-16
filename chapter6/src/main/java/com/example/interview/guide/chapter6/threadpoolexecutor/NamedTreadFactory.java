package com.example.interview.guide.chapter6.threadpoolexecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-03 12:36
 * @Version : V1.0
 * @Description : 创建线程工厂
 */
public class NamedTreadFactory implements ThreadFactory {
    /**
     * 生成线程编号
     */
    private final AtomicInteger threadId = new AtomicInteger(1);

    /**
     * 重写newThread()方法
     */
    @Override
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable, "线程-"
                + threadId.getAndIncrement());
        System.out.println(IgnorePolicy.printDate()
                + t.getName() + "被创建");
        return t;
    }
}
