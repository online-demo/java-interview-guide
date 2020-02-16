package com.example.interview.guide.chapter6.locksupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-02 10:13
 * @Version : V1.0
 * @Description : LockSupport使用方式演示
 */
public class LockSupportDemo {
    /**
     * 充当锁对象。
     */
    public static Object lock = new Object();
    // 一般企业开发中不建议手动创建线程，
    // 此处为了简单起见，手动创建线程。
    // 企业开发中应当使用线程池管理线程。
    /**
     * 测试线程1
     */
    static TestThread t1 = new TestThread("测试线程1");
    /**
     * 测试线程2
     */
    static TestThread t2 = new TestThread("测试线程2");
    /**
     * 测试线程
     */
    public static class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(printDate() + getName() + "获得锁，开始执行");
                System.out.println(printDate() + getName() + "线程阻塞，等待被唤醒");
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(printDate() + getName() + "被中断了");
                }
                System.out.println(printDate() + getName() + "继续执行");
            }
            System.out.println(printDate() + getName() + "执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("主线程");
        t1.start();
        System.out.println(printDate() + t1.getName() + "启动");
        Thread.sleep(1000L);
        t2.start();
        System.out.println(printDate() + t2.getName() + "启动");
        Thread.sleep(2000L);
        System.out.println(printDate() + Thread.currentThread().getName()
                + "中断线程" + t1.getName());
        t1.interrupt();
        Thread.sleep(3000L);
        System.out.println(printDate() + Thread.currentThread().getName()
                + "唤醒线程" + t2.getName());
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

    /**
     * 返回时间
     */
    static String printDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
