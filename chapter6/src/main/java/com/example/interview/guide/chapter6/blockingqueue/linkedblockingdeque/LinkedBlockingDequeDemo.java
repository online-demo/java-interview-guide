package com.example.interview.guide.chapter6.blockingqueue.linkedblockingdeque;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 16:51
 * @Version : V1.0
 * @Description : LinkedBlockingDeque使用方式演示
 */
public class LinkedBlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建容量为1的LinkedBlockingDeque对象。
        LinkedBlockingDeque<String> buffer = new LinkedBlockingDeque<>(1);
        // 创建Exchanger对象。
        Exchanger stack = new Exchanger(buffer);
        // 创建生产者对象。
        Producer producer = new Producer(stack, "Producer1");
        // 创建消费者对象。
        Consumer consumer = new Consumer(stack, "Consumer1");
        // 启动生产者线程。
        producer.start();
        // 启动消费者线程。
        consumer.start();
        Thread.sleep(5000);
        // 停止生产者线程。
        producer.setStop(true);
    }
}
