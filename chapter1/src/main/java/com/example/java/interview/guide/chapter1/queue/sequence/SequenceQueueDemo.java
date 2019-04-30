package com.example.java.interview.guide.chapter1.queue.sequence;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-28 17:58
 * @Version : V1.0
 * @Description :   测试队列
 */
public class SequenceQueueDemo {
    public static void main(String[] args) {
        int initialCapacity = 10;
        SequenceQueue sequenceQueue = new SequenceQueue(initialCapacity);
        // 入栈
        for (int i = 0; i < initialCapacity; i++) {
            sequenceQueue.add(i);
        }
        System.out.println("----------队列是否为空----------");
        System.out.println(sequenceQueue.isEmpty());
        System.out.println("----------队列是否已满----------");
        System.out.println(sequenceQueue.isFull());
        System.out.println("----------队列元素个数----------");
        System.out.println(sequenceQueue.size());
        System.out.println("----------打印队列元素----------");
        // 出队
        for (int i = 0; i < initialCapacity; i++) {
            System.out.print(sequenceQueue.take() + " ");
        }
    }
}
