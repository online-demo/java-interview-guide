package com.example.interview.guide.chapter5.thread.yield;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 11:18
 * @Version : V1.0
 * @Description : yield方法使用方式
 */
public class YieldDemo {
    public static void main(String[] args) {
        // 不推荐直接创建线程，推荐使用线程池管理线程。
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        // 最低优先级
        producer.setPriority(Thread.MIN_PRIORITY);
        // 最高优先级
        consumer.setPriority(Thread.MAX_PRIORITY);
        consumer.start();
        producer.start();
    }
}
