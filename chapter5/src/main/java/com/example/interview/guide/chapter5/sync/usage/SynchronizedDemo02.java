package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-21 07:23
 * @Version : V1.0
 * @Description : 一个线程获取对象的锁之后，其他线程访问其他synchronized实例方法
 */
public class SynchronizedDemo02 {
    /**
     * 同步方法1
     */
    public synchronized void method1() {
        System.out.println("同步方法1开始执行：\t" + TimeUtils.currentTime());
        try {
            System.out.println("同步方法1开始休眠：\t" + TimeUtils.currentTime());
            // sleep方法不会释放监视锁
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
        final SynchronizedDemo02 test = new SynchronizedDemo02();
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程
        // 企业开发中应当使用线程池管理线程。
        new Thread(() -> test.method1()).start();

        new Thread(() -> test.method2()).start();
    }
}
