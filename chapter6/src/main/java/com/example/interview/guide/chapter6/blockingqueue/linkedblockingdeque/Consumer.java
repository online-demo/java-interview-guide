package com.example.interview.guide.chapter6.blockingqueue.linkedblockingdeque;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 16:50
 * @Version : V1.0
 * @Description : 消费者线程
 */
public class Consumer extends Thread{
    /**
     * 需要执行的数据的引用。
     */
    private Exchanger exchanger;

    public Consumer(Exchanger exchanger, String name) {
        super(name);
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            String message;
            try {
                while ((message = exchanger.consume()) != null) {
                    System.out.printf("消费者线程%s消费数据%s%n",
                            Thread.currentThread().getName(), message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
