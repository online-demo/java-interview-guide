package com.example.interview.guide.chapter5.lock.semaphore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-23 08:42
 * @Version : V1.0
 * @Description : Semaphore使用方式演示
 */
public class SemaphoreDemo {
    /**
     * 限定线程数量。
     */
    private static final Semaphore SEMAPHORE = new Semaphore(3);
    /**
     * 每次获取的许可数。
     */
    private static final int PERMITS = 1;

    /**
     * 线程。
     */
    static class TestThread implements Runnable {
        @Override
        public void run() {
            try {
                // 获取许可。
                SEMAPHORE.acquire(PERMITS);
                System.out.println(printCurrent() +
                        " : " + Thread.currentThread().getName()
                        + " 开始执行了");
                // 持有许可3秒，不会释放许可。
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // ！！！！非常重要！！！！
                SEMAPHORE.release(PERMITS);
            }
        }

        /**
         * 打印时间。
         *
         * @return  当前时间字符串
         */
        private String printCurrent() {
            SimpleDateFormat sdf =
                    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            return sdf.format(new Date());
        }
    }

    public static void main(String[] args) {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        Thread t1 = new Thread(new TestThread(), "TestThread1");
        Thread t2 = new Thread(new TestThread(), "TestThread2");
        Thread t3 = new Thread(new TestThread(), "TestThread3");
        Thread t4 = new Thread(new TestThread(), "TestThread4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
