package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 13:34
 * @Version : V1.0
 * @Description : synchronized作用于同步代码块
 */
public class SynchronizedDemo06 implements Runnable {

    static SynchronizedDemo06 instance = new SynchronizedDemo06();

    /**
     * 共享资源
     */
    private static int TOTAL_COUNT = 0;

    @Override
    public void run() {

        //使用同步代码块对变量进行同步操作,锁对象为instance
        synchronized (instance) {
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
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance, "线程1");
        Thread t2 = new Thread(instance, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("TOTAL_COUNT=" + TOTAL_COUNT);
    }
}
