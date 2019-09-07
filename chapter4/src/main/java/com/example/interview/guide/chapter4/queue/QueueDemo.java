package com.example.interview.guide.chapter4.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/8/12 15:54
 * @Version : V1.0
 * @Description : LinkedList用作Queue的使用方式
 */
public class QueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        Deque<String> queue = new LinkedList<>();
        // 向队列中添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        // 打印队列中的元素
        queue.forEach(string
                -> System.out.printf("输出queue中的元素：%s%n", string));
        // 返回第一个元素，并在队列中删除
        System.out.printf("输出queue中的第一个元素：%s%n", queue.poll());
        // 返回第一个元素，但不删除
        System.out.printf("输出queue中的第一个元素：%s%n", queue.element());
        // 返回第一个元素，但不删除
        System.out.printf("输出queue中的第一个元素：%s%n", queue.element());
        // 返回第一个元素，但不删除
        System.out.printf("输出queue中的第一个元素：%s%n", queue.peek());
        queue.forEach(string
                -> System.out.printf("输出queue中的元素：%s%n", string));
        // 队列尾部加入f
        queue.offerLast("f");
        // 返回最后一个元素，但不删除
        System.out.printf("输出queue中的最后一个元素：%s%n", queue.peekLast());
        // 返回最后一个元素，并删除
        System.out.printf("输出queue中的最后一个元素：%s%n", queue.pollLast());

        // 队列头部加入新元素1
        queue.push("z");
        // 打印队列中的元素
        queue.forEach(string
                -> System.out.printf("输出queue中的元素：%s%n", string));
    }
}
