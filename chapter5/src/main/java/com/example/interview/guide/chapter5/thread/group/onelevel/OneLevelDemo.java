package com.example.interview.guide.chapter5.thread.group.onelevel;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 16:28
 * @Version : V1.0
 * @Description : 线程组一级关联测试代码
 */
public class OneLevelDemo {
    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        TestThread testThread2 = new TestThread();
        ThreadGroup threadGroup = new ThreadGroup("新建线程组1");
        // 不推荐创建线程对象，而应该使用线程池管理线程。
        Thread t0 = new Thread(threadGroup, testThread1);
        Thread t1 = new Thread(threadGroup, testThread2);
        t0.start();
        t1.start();
        System.out.println("活动的线程数为：" + threadGroup.activeCount());
        System.out.println("线程组的名称为：" + threadGroup.getName());
        // 线程组中断。
        threadGroup.interrupt();
    }
}
