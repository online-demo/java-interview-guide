package com.example.interview.guide.chapter5.sync.deadlock;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 14:20
 * @Version : V1.0
 * @Description : synchronized死锁现象
 */
public class SynchronizedDeadLockDemo {
    /** A锁 */
    private static final String A = "A";

    /** B锁 */
    private static String B = "B";

    public static void main(String[] args) {
        new SynchronizedDeadLockDemo().deadLock();
    }

    /**
     * 模拟死锁
     *
     * 一般企业开发中不建议手动创建线程，
     * 此处为了简单起见，手动创建线程。
     * 企业开发中应当使用线程池管理线程。
     */
    public void deadLock() {

        // 线程t1先获取A锁再获取B锁
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    // 获取A锁后休眠2s
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    // 获取B锁
                    System.out.println("线程t1尝试获取B锁...");
                }
            }
        });

        // 先获取B锁再获取A锁
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                try {
                    // 获取B锁后休眠2s
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("线程t2尝试获取A锁...");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
