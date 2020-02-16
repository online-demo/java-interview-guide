package com.example.interview.guide.chapter6.lock.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-25 11:46
 * @Version : V1.0
 * @Description : 旅行任务
 */
public class TravelTask implements Runnable {
    /**
     * 循环栅栏对象。
     */
    private CyclicBarrier cyclicBarrier;
    /**
     * 旅客姓名。
     */
    private String name;
    /**
     * 旅客到达集合地的时间。
     */
    private int arriveTime;

    /**
     * 构造器。
     *
     * @param cyclicBarrier 循环栅栏对象
     * @param name 旅客姓名
     * @param arriveTime 旅客到达集合地的时间
     */
    public TravelTask(CyclicBarrier cyclicBarrier, String name, int arriveTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.arriveTime = arriveTime;
    }

    @Override
    public void run() {
        try {
            //模拟达到需要花的时间
            Thread.sleep(arriveTime * 1000);
            System.out.println(CyclicBarrierDemo.printDate()
                    + " " + name + "到达集合点");
            cyclicBarrier.await();
            System.out.println(CyclicBarrierDemo.printDate()
                    + " " + name + "开始旅行啦～～");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
