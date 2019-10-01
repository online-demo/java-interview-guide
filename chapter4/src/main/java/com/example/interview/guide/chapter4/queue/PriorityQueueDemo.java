package com.example.interview.guide.chapter4.queue;

import java.util.PriorityQueue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-09-28 15:06
 * @Version : V1.0
 * @Description : 优先级队列使用方式
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        // 优先级队列入列。
        priorityQueue.add("1");
        priorityQueue.offer("2");
        priorityQueue.offer("5");
        priorityQueue.offer("3");
        priorityQueue.offer("4");

        // 获取队列头部元素，但是不删除。
        System.out.print("队列头部元素是：");
        System.out.println(priorityQueue.peek());

        // 优先级队列出列。
        System.out.print("依次将元素出队：");
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll() + " ");
        System.out.print(priorityQueue.poll());
    }
}
