package com.example.interview.guide.chapter6.lock.cyclicbarrier;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-25 11:48
 * @Version : V1.0
 * @Description : 旅游团司机任务
 */
public class TourDriverTask implements Runnable {
    @Override
    public void run() {
        System.out.println(CyclicBarrierDemo.printDate()
                + " 旅游团司机开始发车");
        try {
            //模拟发车耗时2秒。
            Thread.sleep(2000);
            System.out.println(CyclicBarrierDemo.printDate()
                    + " 旅游团司机发车成功，开启旅游时光");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
