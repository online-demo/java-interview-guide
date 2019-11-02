package com.example.interview.guide.chapter5.thread.priority.daemon;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 15:24
 * @Version : V1.0
 * @Description : 守护线程
 */
public class MyDaemon implements Runnable {
    @Override
    public void run() {
        for (long i = 0; i < 20; i++) {
            System.out.println("守护线程第" + i + "次执行！");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
