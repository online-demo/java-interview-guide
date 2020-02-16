package com.example.interview.guide.chapter6.blockingqueue.linkedblockingqueue;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-27 21:01
 * @Version : V1.0
 * @Description : LinkedBlockingQueue使用方式演示
 */
public class LinkedBlockingQueueDemo {
    /**
     * 生产者生产的消息。
     */
    private static AtomicInteger PRODUCE_COUNT
            = new AtomicInteger(0);
    /**
     * 消费者消费的消息。
     */
    private static AtomicInteger CONSUME_COUNT
            = new AtomicInteger(0);
    /**
     * LinkedBlockingQueue阻塞队列。
     */
    private static LinkedBlockingQueue<Integer> linkedBlockingQueue
            = new LinkedBlockingQueue<>(3);
    /**
     * 生产者-消费者模型传递的消息总数。
     */
    private static final int COUNT = 10;

    /**
     * 生产者线程。
     */
    static class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < COUNT; i++) {
                try {
                    Integer messageId = PRODUCE_COUNT.incrementAndGet();
                    // 生产者向队列添加元素。
                    linkedBlockingQueue.put(messageId);
                    System.out.printf("%s生产的消息id=%s，队列剩余容量=%s%n",
                            Thread.currentThread().getName(),
                            messageId, linkedBlockingQueue.remainingCapacity());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 消费者线程。
     */
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (CONSUME_COUNT.get() < COUNT) {
                try {
                    // 带超时时间的出队方法，如果不存在将返回null。
                    Integer messageId = linkedBlockingQueue
                            .poll(5, TimeUnit.SECONDS);
                    System.out.printf("%s消费的消息id=%s，队列剩余容量=%s%n",
                            Thread.currentThread().getName(),
                            messageId, linkedBlockingQueue.remainingCapacity());
                    CONSUME_COUNT.incrementAndGet();
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试代码。
     */
    public static void main(String[] args) {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        new Thread(new Producer(), "生产者1").start();
        new Thread(new Consumer(), "消费者1").start();
        new Thread(new Consumer(), "消费者2").start();
        new Thread(new Consumer(), "消费者3").start();
    }
}
