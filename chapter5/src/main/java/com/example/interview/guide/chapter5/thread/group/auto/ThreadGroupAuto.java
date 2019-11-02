package com.example.interview.guide.chapter5.thread.group.auto;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 18:45
 * @Version : V1.0
 * @Description : 线程组自动归属测试代码
 */
public class ThreadGroupAuto {
    public static void main(String[] args) {
        print();
        // 没有指定线程组，那么自动归到当前线程所属的线程组中
        ThreadGroup group = new ThreadGroup("新的组");
        print();
    }

    private static void print() {
        Thread currentThread = Thread.currentThread();
        System.out.println("当前线程：" + currentThread.getName()
                + ", 所属线程组：" + currentThread.getThreadGroup().getName()
                + ", 线程组中有线程组数量：" + currentThread.getThreadGroup()
                .activeGroupCount()
                + ", 线程组名为：" + currentThread.getThreadGroup()
                .getName());
    }
}
