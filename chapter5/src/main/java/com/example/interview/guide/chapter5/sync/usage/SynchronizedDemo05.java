package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 13:23
 * @Version : V1.0
 * @Description : synchronized作用于静态方法
 */
public class SynchronizedDemo05 implements Runnable {
    /**
     * 共享资源
     */
    private static int TOTAL_COUNT = 0;

    /**
     * synchronized 修饰静态方法方法
     */
    public static synchronized void increase() {
        for (int j = 0; j < 10; j++) {
            System.out.println(TimeUtils.currentTime()
                    + " " + Thread.currentThread().getName()
                    + "执行累加操作。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TOTAL_COUNT++;
        }
    }

    @Override
    public void run() {
        increase();
    }

    public static void main(String[] args) throws InterruptedException {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        Thread t1 = new Thread(new SynchronizedDemo05(), "线程1");
        Thread t2 = new Thread(new SynchronizedDemo05(), "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("TOTAL_COUNT=" + TOTAL_COUNT);
    }
}
