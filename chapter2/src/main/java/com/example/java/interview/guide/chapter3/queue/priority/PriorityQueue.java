package com.example.java.interview.guide.chapter3.queue.priority;

import com.example.java.interview.guide.chapter3.queue.Queue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-22 16:55
 * @Version : V1.0
 * @Description : 顺序存储结构实现最大优先队列
 */
public class PriorityQueue implements Queue {
    /**
     * 优先级队列元素类
     */
    public static class Node {
        /**
         * 数据
         */
        Object element;
        /**
         * 优先级
         */
        int priority;

        public Node(Object obj, int priority) {
            this.element = obj;
            this.priority = priority;
        }
    }

    /**
     * 队头
     */
    int front;
    /**
     * 队尾
     */
    int rear;
    /**
     * 计数器
     */
    int count;
    /**
     * 队列最大长度
     */
    int maxSize;
    /**
     * 队列
     */
    Node[] queue;

    public PriorityQueue(int size) {
        maxSize = size;
        front = rear = 0;
        count = 0;
        queue = new Node[size];
    }

    /**
     * 添加元素到队列
     *
     * @param element 队尾元素
     */
    @Override
    public void add(Object element) {
        //如果队列已满
        if (count >= maxSize) {
            System.out.println("队列已满");
        }
        queue[rear] = (Node) element;
        rear++;
        count++;
    }

    /**
     * 从队列获取元素
     *
     * @return 队头元素
     */
    @Override
    public Object take() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }

        //默认第一个元素为优先级最高的
        Node max = queue[0];
        int maxIndex = 0;
        // 时间复杂度O(n)
        for (int i = 0; i < count; i++) {
            if (queue[i].priority > max.priority) {
                max = queue[i];
                maxIndex = i;
            }
        }

        //找的优先级别最高的元素后，把该元素后面的元素向前移动。
        for (int i = maxIndex + 1; i < count; i++) {
            //移动元素
            queue[i - 1] = queue[i];
        }
        rear--;
        count--;
        return max;
    }

    /**
     * 队列的大小
     *
     * @return 队列包含的元素个数
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * 是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
