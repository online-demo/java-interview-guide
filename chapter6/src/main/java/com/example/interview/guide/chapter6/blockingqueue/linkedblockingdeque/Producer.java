package com.example.interview.guide.chapter6.blockingqueue.linkedblockingdeque;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 16:50
 * @Version : V1.0
 * @Description : 生产者线程
 */
public class Producer extends Thread {
    /**
     * 是否结束运行。
     */
    private volatile boolean stop;
    /**
     * 自增编号。
     */
    private AtomicInteger sequence = new AtomicInteger(1);

    /**
     * 需要执行的数据的引用。
     */
    private Exchanger exchanger;

    public Producer(Exchanger exchanger, String name) {
        super(name);
        this.exchanger = exchanger;
    }


    @Override
    public void run() {
        while (!stop) {

            try {
                Thread.sleep(500);
                String message = String.valueOf(sequence.getAndIncrement());
                this.exchanger.produce(message);
                System.out.printf("生产者线程%s生产数据%s%n",
                        Thread.currentThread().getName(), message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
