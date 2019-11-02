package com.example.interview.guide.chapter5.thread.priority.extend;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 14:55
 * @Version : V1.0
 * @Description : 线程1
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        //输出线程级别
        System.out.println("线程1的优先级是：" + this.getPriority());
        //启动线程MyThread2
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}
