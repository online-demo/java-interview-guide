package com.example.interview.guide.chapter6.atomic.atomcinteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-02 18:21
 * @Version : V1.0
 * @Description : AtomicInteger使用方式演示
 */
public class AtomicIntegerDemo {
    /**
     * 累加线程。
     */
    static class AddThread implements Runnable {
        /**
         * 计数器。
         */
        private AtomicInteger atomicInteger;

        /**
         * 构造器
         *
         * @param atomicInteger 计数器
         */
        AddThread(AtomicInteger atomicInteger) {
            this.atomicInteger = atomicInteger;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                atomicInteger.incrementAndGet();
            }
        }
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) throws InterruptedException {
        // 创建AtomicInteger对象。
        AtomicInteger count = new AtomicInteger(0);
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        // 创建累加线程1
        Thread thread1 = new Thread(new AddThread(count));
        // 创建累加线程2
        Thread thread2 = new Thread(new AddThread(count));
        // 启动累加线程1
        thread1.start();
        // 启动累加线程2
        thread2.start();
        thread1.join();
        thread2.join();
        // 打印atomicInteger被线程1和线程2累加后的值
        System.out.println("count累加后的值=" + count.intValue());
    }
}