package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-20 22:56
 * @Version : V1.0
 * @Description : 多个线程访问同一个对象的同一个方法
 */
public class SynchronizedDemo01 implements Runnable {
    /**
     * 模拟一个共享资源
     */
    private static int TOTAL_COUNT = 0;

    /**
     * synchronized 修饰实例方法
     */
    public synchronized void increase() {
        for (int j = 0; j < 10; j++) {
            System.out.println(Thread.currentThread().getName()
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
        SynchronizedDemo01 test = new SynchronizedDemo01();
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程
        // 企业开发中应当使用线程池管理线程。
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test, "线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("线程1和线程2分别进行累加后的结果为："
                + TOTAL_COUNT);
    }
}
