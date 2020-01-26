package com.example.interview.guide.chapter5.lock.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-24 10:52
 * @Version : V1.0
 * @Description : 买电影票任务
 */
public class BuyMovieTicketsTask implements Runnable {

    private CountDownLatch countDownLatch;

    /**
     * 构造器
     * @param countDownLatch CountDownLatch对象
     */
    public BuyMovieTicketsTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            // 开始排队。
            System.out.println(CountDownLatchDemo.printDate()
                    + Thread.currentThread().getName()
                    + " 开始排队买电影票");
            // 线程休眠10秒。
            Thread.sleep(10000);
            // 结束排队。
            System.out.println(CountDownLatchDemo.printDate()
                    + Thread.currentThread().getName()
                    + " 排队结束，成功买到电影票");
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
