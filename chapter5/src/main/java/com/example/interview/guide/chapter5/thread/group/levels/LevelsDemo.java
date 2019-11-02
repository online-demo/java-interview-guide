package com.example.interview.guide.chapter5.thread.group.levels;

import com.example.interview.guide.chapter5.thread.group.onelevel.TestThread;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 16:45
 * @Version : V1.0
 * @Description : 线程组多级关联测试代码
 */
public class LevelsDemo {
    public static void main(String[] args) {
        // 创建线程组1。
        ThreadGroup threadGroup1 = new ThreadGroup("线程组1");
        // 创建线程组2，创建线程组2的父线程为线程组1。
        ThreadGroup threadGroup2
                = new ThreadGroup(threadGroup1, "线程组2");
        // 创建线程组3，创建线程组3的父线程为线程组1.
        ThreadGroup threadGroup3
                = new ThreadGroup(threadGroup1, "线程组3");
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();
        TestThread testThread3 = new TestThread();
        // 不推荐直接创建线程，而应该使用线程池管理线程。
        Thread t0 = new Thread(threadGroup1, testThread1);
        Thread t1 = new Thread(threadGroup2, testThread2);
        Thread t2 = new Thread(threadGroup3, testThread3);
        t0.start();
        t1.start();
        t2.start();
        System.out.println("threadGroup1线程组的名称为："
                + threadGroup1.getName());
        System.out.println("threadGroup1活动的线程数为："
                + threadGroup1.activeCount());
        System.out.println("threadGroup1活动的线程组数为："
                + threadGroup1.activeGroupCount());
        System.out.println("threadGroup2线程组的名称为："
                + threadGroup2.getName());
        System.out.println("threadGroup2活动的线程数为："
                + threadGroup2.activeCount());
        System.out.println("threadGroup3线程组的名称为："
                + threadGroup3.getName());
        System.out.println("threadGroup3活动的线程数为："
                + threadGroup3.activeCount());
        // 中断线程组1。
        threadGroup1.interrupt();
    }
}
