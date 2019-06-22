package com.example.java.interview.guide.chapter1.queue.priority;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-22 17:03
 * @Version : V1.0
 * @Description : 测试顺序存储结构实现的最大优先队列
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(5);
        PriorityQueue.Node temp;

        //五个不同优先级的元素入队
        queue.add(new PriorityQueue.Node(1, 30));
        queue.add(new PriorityQueue.Node(2, 90));
        queue.add(new PriorityQueue.Node(3, 40));
        queue.add(new PriorityQueue.Node(4, 50));
        queue.add(new PriorityQueue.Node(5, 80));

        //按照优先级出队
        while (!queue.isEmpty()) {
            temp = (PriorityQueue.Node) queue.take();
            System.out.println("编号是" + temp.element + "的元素出队，"
                    + "该元素优先级" + temp.priority);
        }
    }
}
