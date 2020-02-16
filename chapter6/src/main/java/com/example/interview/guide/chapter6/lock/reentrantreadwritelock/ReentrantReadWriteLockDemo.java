package com.example.interview.guide.chapter6.lock.reentrantreadwritelock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-25 18:27
 * @Version : V1.0
 * @Description : ReentrantReadWriteLock使用方式演示
 */
public class ReentrantReadWriteLockDemo {
    /**
     * 数量为5。
     */
    private static final int COUNT = 5;
    /**
     * 可重入读写锁。
     */
    private static ReentrantReadWriteLock readWriteLock =
            new ReentrantReadWriteLock();
    /**
     * 读锁。
     */
    private static ReentrantReadWriteLock.ReadLock readLock =
            readWriteLock.readLock();
    /**
     * 写锁。
     */
    private static ReentrantReadWriteLock.WriteLock writeLock =
            readWriteLock.writeLock();

    /**
     * 处理读取操作。
     */
    private void handleRead(ReentrantReadWriteLock.ReadLock lock)
            throws InterruptedException {
        try {
            // 模拟读取操作。
            lock.lock();
            System.out.println(printDate()
                    + Thread.currentThread().getName()
                    + " 获取读锁执行了。。。");
            Thread.sleep(5000);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 处理写操作。
     */
    private void handleWrite(ReentrantReadWriteLock.WriteLock lock)
            throws InterruptedException {
        try {
            // 模拟写入操作。
            lock.lock();
            System.out.println(printDate()
                    + Thread.currentThread().getName()
                    + " 获取写锁执行了。。。");
            Thread.sleep(5000);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 测试代码
     */
    public static void main(String[] args) {
        final ReentrantReadWriteLockDemo readWriteLockDemo =
                new ReentrantReadWriteLockDemo();
        Runnable readRunnable = () -> {
            try {
                // 处理读取操作。
                readWriteLockDemo.handleRead(readLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable writeRunnable = () -> {
            try {
                // 处理写入操作。
                readWriteLockDemo.handleWrite(writeLock);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        for (int i = 0; i < COUNT * 2; i++) {
            new Thread(readRunnable).start();
        }

        for (int i = 0; i < COUNT; i++) {
            new Thread(writeRunnable).start();
        }
    }

    /**
     * 返回时间
     *
     * @return 时间
     */
    private String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date()) + " ";
    }

}
