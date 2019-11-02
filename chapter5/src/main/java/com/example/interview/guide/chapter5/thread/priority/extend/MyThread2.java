package com.example.interview.guide.chapter5.thread.priority.extend;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 14:56
 * @Version : V1.0
 * @Description : 线程2
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("线程2的优先级是：" + this.getPriority());
    }
}
