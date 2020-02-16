package com.example.interview.guide.chapter6.atomic.aba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-02 23:23
 * @Version : V1.0
 * @Description : ABA问题演示
 */
public class AbaDemo {
    /**
     * 创建AtomicInteger对象，初始值为100
     */
    private static AtomicInteger ABA = new AtomicInteger(100);

    /**
     * 创建AtomicStampedReference对象，初始值为100
     */
    private static AtomicStampedReference<Integer> NOT_ABA
            = new AtomicStampedReference<Integer>(100, 0);

    /**
     * 测试代码
     */
    public static void main(String[] args) throws InterruptedException {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        // 模拟发生ABA问题
        Thread thread1 = new Thread(() -> {
            // 发生ABA问题
            // 线程thread1将ABA的值从100变成101
            ABA.compareAndSet(100, 101);
            // 线程thread1将ABA的值从101变成100
            ABA.compareAndSet(101, 100);
        });

        Thread thread2 = new Thread(() -> {
            try {
                // 线程thread2休眠1秒
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {

            }
            // 线程thread2将ABA的值从100变成101
            boolean abaResult = ABA.compareAndSet(100, 101);
            System.out.println("线程thread2将ABA的值从100变成101的执行结果是 = "
                    + abaResult);
        });
        // 启动线程
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(() -> {
            try {
                // 线程thread3休眠1秒
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            // 线程thread3将NOT_ABA从100变成101
            NOT_ABA.compareAndSet(100, 101,
                    NOT_ABA.getStamp(), NOT_ABA.getStamp() + 1);
            // 线程thread3将NOT_ABA从101变成100
            NOT_ABA.compareAndSet(101, 100,
                    NOT_ABA.getStamp(), NOT_ABA.getStamp() + 1);
            System.out.println("线程thread3获取NOT_ABA的stamp = "
                    + NOT_ABA.getStamp());
        });

        Thread thread4 = new Thread(() -> {
            // stamp发生变化
            int stamp = NOT_ABA.getStamp();
            System.out.println("线程thread4获取NOT_ABA的stamp = " + stamp);
            try {
                // 线程thread3休眠2秒
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            boolean atomicStampedReferenceResult = NOT_ABA
                    .compareAndSet(100,
                    101, stamp, stamp + 1);
            System.out.println("线程thread4将NOT_ABA的值从100变成101的执行结果是 = "
                    + atomicStampedReferenceResult);
        });
        thread3.start();
        thread4.start();
    }
}
