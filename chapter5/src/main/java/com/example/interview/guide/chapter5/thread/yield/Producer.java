package com.example.interview.guide.chapter5.thread.yield;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 11:13
 * @Version : V1.0
 * @Description : 生产者
 */
public class Producer extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是生产者，我生产的数据是：" + i);
        }
    }
}
