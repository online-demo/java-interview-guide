package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-21 11:07
 * @Version : V1.0
 * @Description : 当多个线程作用于不同的实例化对象
 */
public class SynchronizedDemo04 {
    /**
     * 同步方法1
     */
    public synchronized void method1() {
        System.out.println("同步方法1开始执行：\t" + TimeUtils.currentTime());
        try {
            System.out.println("同步方法1开始休眠：\t" + TimeUtils.currentTime());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法1执行结束：\t" + TimeUtils.currentTime());
    }
    /**
     * 同步方法2
     */
    public synchronized void method2() {
        System.out.println("同步方法2开始执行：\t" + TimeUtils.currentTime());
        try {
            System.out.println("同步方法2开始休眠：\t" + TimeUtils.currentTime());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("同步方法2执行结束：\t" + TimeUtils.currentTime());
    }


    public static void main(String[] args) {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程
        // 企业开发中应当使用线程池管理线程。
        new Thread(() -> new SynchronizedDemo04().method1()).start();

        new Thread(() -> new SynchronizedDemo04().method2()).start();
    }
}
