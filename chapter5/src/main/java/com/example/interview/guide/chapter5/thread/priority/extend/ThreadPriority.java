package com.example.interview.guide.chapter5.thread.priority.extend;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 14:57
 * @Version : V1.0
 * @Description : 线程优先级继承特性验证
 */
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("主线程的优先级是："
                + Thread.currentThread().getPriority());
        System.out.println("设置主线程的优先级为10");
        Thread.currentThread().setPriority(10);
        System.out.println("修改主线程优先级后，主线程的优先级是："
                + Thread.currentThread().getPriority());
        // 不推荐直接创新新线程，而是应该使用线程池的方式管理线程。
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
