package com.example.interview.guide.chapter6.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-24 10:52
 * @Version : V1.0
 * @Description : 购买爆米花任务
 */
public class BuyPopcornTask implements Runnable {

    private CountDownLatch countDownLatch;

    /**
     * 构造器
     * @param countDownLatch CountDownLatch对象
     */
    public BuyPopcornTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            // 开始买爆米花。
            System.out.println(CountDownLatchDemo.printDate()
                    + Thread.currentThread().getName()
                    + " 开始买爆米花");
            // 线程休眠5秒。
            Thread.sleep(5000);
            // 买到爆米花。
            System.out.println(CountDownLatchDemo.printDate()
                    + Thread.currentThread().getName()
                    + " 买到爆米花");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch != null) {
                // countDownLatch倒数1。
                countDownLatch.countDown();
            }
        }
    }
}
