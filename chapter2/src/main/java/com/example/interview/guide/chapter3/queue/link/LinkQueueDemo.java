package com.example.interview.guide.chapter3.queue.link;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-28 20:07
 * @Version : V1.0
 * @Description : 测试链式队列
 */
public class LinkQueueDemo {
    public static void main(String[] args) {
        int initialCapacity = 10;
        LinkQueue linkQueue = new LinkQueue();
        // 入队
        for (int i = 0; i < initialCapacity; i++) {
            linkQueue.add(i);
        }
        System.out.println("----------队列是否为空----------");
        System.out.println(linkQueue.isEmpty());
        System.out.println("----------队列元素个数----------");
        System.out.println(linkQueue.size());
        System.out.println("----------打印队列元素----------");
        // 依次出队
        for (int i = 0; i < initialCapacity; i++) {
            System.out.print(linkQueue.take() + " ");
        }
        System.out.println();
        System.out.println("----------队列元素个数----------");
        System.out.println(linkQueue.size());
    }
}
