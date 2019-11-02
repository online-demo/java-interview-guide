package com.example.interview.guide.chapter5.thread.wait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 16:42
 * @Version : V1.0
 * @Description : wait/notify方法使用方式
 */
public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建一个对象作为锁。
        Object lock = new Object();
        for (int i = 0; i < 5; i++) {
            // 不推荐直接创建线程。限于篇幅，这里直接创建线程。
            // 推荐使用推荐使用5.2.4节的线程池管理线程。
            new WaitThread(i + "", lock).start();
        }
        // 主线程休眠2秒。
        Thread.sleep(2000);
        System.out.println(printDate() + "主线程休眠2秒");
        // 不推荐直接创建线程。限于篇幅，这里直接创建线程。
        // 推荐使用推荐使用5.2.4节的线程池管理线程。
        new NotifyThread(lock).start();
    }

    /**
     * 调用wait()方法的线程
     */
    static class WaitThread extends Thread {
        /**
         * 锁对象。
         */
        final Object lock;

        public WaitThread(String name, Object lock) {
            // 设置线程名。
            setName("WaitThread" + name);
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(printDate() + getName() + " before wait()");
                try {
                    // 线程等待。
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(printDate() + getName() + " after wait()");
            }
        }
    }

    /**
     * 调用notify()/notifyAll()
     */
    static class NotifyThread extends Thread {

        final Object lock;

        public NotifyThread(Object lock) {
            setName("NotifyThread");
            this.lock = lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(printDate() + getName()
                        + " NotifyThread before notify()");
                // 唤醒所有线程 用notifyAll()会按照后进先出（LIFO）的原则恢复线程。
                lock.notifyAll();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(printDate() + getName()
                        + " NotifyThread after notify()");
            }
        }
    }

    /**
     * 返回当前时间
     */
    private static String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " ";
    }

}
