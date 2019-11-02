package com.example.interview.guide.chapter5.thread.group.onelevel;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 16:28
 * @Version : V1.0
 * @Description : 测试线程
 */
public class TestThread implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程名："
                        + Thread.currentThread().getName());
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
