package com.example.interview.guide.chapter5.thread.sleep;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 16:10
 * @Version : V1.0
 * @Description : 线程sleep方法的使用
 */
public class ThreadSleepDemo {
    /**
     * sleep()方法不会释放锁，因此线程是按照先后顺序执行的。
     */
    public synchronized void sleepMethod() {
        System.out.println(printDate() +
                Thread.currentThread().getName() + "休眠1s");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(printDate() +
                Thread.currentThread().getName() + "休眠结束");
    }

    /**
     * wait()方法会释放锁，因此一旦调用wait()方法就会造成其他线程运行
     */
    public synchronized void waitMethod() {
        System.out.println(printDate() +
                Thread.currentThread().getName() + "等待1s");
        synchronized (this) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(printDate() +
                Thread.currentThread().getName() + "等待结束");
    }

    public static void main(String[] args) {

        final ThreadSleepDemo test1 = new ThreadSleepDemo();

        for (int i = 0; i < 5; i++) {
            // 不推荐直接创建线程。限于篇幅，这里直接创建线程。
            // 推荐使用推荐使用5.2.4节的线程池管理线程。
            new Thread(test1::sleepMethod).start();
        }


        try {
            //暂停十秒，等上面程序执行完成。
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("--------------分割线--------------");

        final ThreadSleepDemo test2 = new ThreadSleepDemo();

        for (int i = 0; i < 5; i++) {
            // 不推荐直接创建线程。限于篇幅，这里直接创建线程。
            // 推荐使用推荐使用5.2.4节的线程池管理线程。
            new Thread(test2::waitMethod).start();
        }

    }

    private static String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " ";
    }
}
