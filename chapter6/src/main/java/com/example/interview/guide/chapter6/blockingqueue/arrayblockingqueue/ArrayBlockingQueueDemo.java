package com.example.interview.guide.chapter6.blockingqueue.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-27 13:54
 * @Version : V1.0
 * @Description : ArrayBlockingQueue使用方式演示
 */
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue =
                new ArrayBlockingQueue<>(5);
        System.out.println("增加值之前队列的容量=" + arrayBlockingQueue.size());
        for (int i = 0; i < 5; i++) {
            int element = i;
            // 一般企业开发中不建议手动创建线程，
            // 此处为了简单起见，手动创建线程。
            // 企业开发中应当使用线程池管理线程。
            new Thread(() -> arrayBlockingQueue
                    .add(String.valueOf(element))).start();
        }
        Thread.sleep(100);
        System.out.println("增加值之后队列的容量=" + arrayBlockingQueue.size());
        System.out.println(arrayBlockingQueue.toString());

        System.out.println("阻塞队列取值开始");
        for (int i = 0; i < 5; i++) {
            System.out.println("从阻塞队列取出的值为：" + arrayBlockingQueue.poll());
        }
    }
}
