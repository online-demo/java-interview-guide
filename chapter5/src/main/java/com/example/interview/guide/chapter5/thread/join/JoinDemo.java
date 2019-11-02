package com.example.interview.guide.chapter5.thread.join;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 12:33
 * @Version : V1.0
 * @Description : join方法使用
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建两个线程。
        Thread thread2 = new Thread(() -> {
            System.out.println("线程2启动");
            System.out.println("线程2休眠2秒");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行结束");
        });

        Thread thread1 = new Thread(() -> {
            try {
                // 调用线程2的join()方法。
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程1启动");
            System.out.println("线程1休眠2秒");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程1执行结束");
        });

        // 线程1启动
        thread1.start();
        thread2.start();
    }
}
