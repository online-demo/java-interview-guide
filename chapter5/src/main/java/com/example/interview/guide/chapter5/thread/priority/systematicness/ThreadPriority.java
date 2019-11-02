package com.example.interview.guide.chapter5.thread.priority.systematicness;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 15:10
 * @Version : V1.0
 * @Description : 线程规则性和随机性验证
 */
public class ThreadPriority {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(1);
            MyThread2 myThread2 = new MyThread2();
            myThread2.setPriority(10);
            myThread1.start();
            myThread2.start();
        }
    }
}
