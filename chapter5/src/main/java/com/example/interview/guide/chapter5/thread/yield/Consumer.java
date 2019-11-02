package com.example.interview.guide.chapter5.thread.yield;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 11:07
 * @Version : V1.0
 * @Description : 消费者
 */
public class Consumer extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("我是消费者，我消费的数据是：" + i);
            Thread.yield();
        }
    }
}