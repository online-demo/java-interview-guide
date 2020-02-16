package com.example.interview.guide.chapter6.lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-20 16:29
 * @Version : V1.0
 * @Description : ReentrantLock使用方式演示
 */
public class ReentrantLockDemo {
    /**
     * 锁对象。
     */
    private static Lock lock;

    public static void main(String[] args)
            throws InterruptedException {
        System.out.println("ReentrantLock公平锁使用方式演示：");
        // 公平锁模式
        lock = new ReentrantLock(true);
        for (int i = 0; i < 5; i++) {
            // 一般企业开发中不建议手动创建线程，
            // 此处为了简单起见，手动创建线程。
            // 企业开发中应当使用线程池管理线程。
            new Thread(new ThreadDemo(i)).start();
        }
        Thread.sleep(1000);
        System.out.println("ReentrantLock非公平锁使用方式演示：");
        // 非公平锁模式
        lock = new ReentrantLock(false);
        for (int i = 0; i < 5; i++) {
            // 一般企业开发中不建议手动创建线程，
            // 此处为了简单起见，手动创建线程。
            // 企业开发中应当使用线程池管理线程。
            new Thread(new ThreadDemo(i)).start();
        }
    }

    /**
     * 实现Runnable接口。
     */
    static class ThreadDemo implements Runnable {
        Integer id;

        public ThreadDemo(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                System.out.println("获得锁的线程：" + id);
                lock.unlock();
            }
        }
    }
}
