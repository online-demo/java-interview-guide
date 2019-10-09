package com.example.interview.guide.chapter3.queue.circle;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-22 16:01
 * @Version : V1.0
 * @Description : 测试循环链表
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        int initialCapacity = 10;
        CircleQueue circleQueue = new CircleQueue(initialCapacity);
        // 入栈 入栈20个元素，测试栈满的情况
        for (int i = 0; i < initialCapacity + initialCapacity; i++) {
            circleQueue.add(i);
        }
        System.out.println("----------队列是否为空----------");
        System.out.println(circleQueue.isEmpty());
        System.out.println("----------队列是否已满----------");
        System.out.println(circleQueue.isFull());
        System.out.println("----------队列元素个数----------");
        System.out.println(circleQueue.size());
        System.out.println("----------打印队列元素----------");
        // 依次出队
        for (int i = 0; i < initialCapacity; i++) {
            System.out.print(circleQueue.take() + " ");
        }
    }
}
