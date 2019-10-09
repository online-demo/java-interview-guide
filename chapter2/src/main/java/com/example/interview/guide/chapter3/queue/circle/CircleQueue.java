package com.example.interview.guide.chapter3.queue.circle;

import com.example.interview.guide.chapter3.queue.Queue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-06-22 15:52
 * @Version : V1.0
 * @Description : 循环链表实现
 */
public class CircleQueue implements Queue {
    /**
     * 队头
     */
    int front;
    /**
     * 队尾
     */
    int rear;
    /**
     * 统计元素个数的计数器
     */
    int count;
    /**
     * 队的最大长度
     */
    int maxSize;
    /**
     * 存储队列中元素的数组
     */
    Object[] array;

    /**
     * 构造器
     *
     * @param size  指定队列容量
     */
    public CircleQueue(int size) {
        init(size);
    }

    /**
     * 初始化
     *
     * @param size  队列容量
     */
    public void init(int size) {
        maxSize = size;
        front = 0;
        rear = 0;
        count = 0;
        array = new Object[size];
    }

    /**
     * 添加元素到队列
     *
     * @param element 队尾元素
     */
    @Override
    public void add(Object element) {
        if (count == maxSize && front == rear) {
            // 队列已满
            System.out.println("队列已满");
            return;
        }
        array[rear] = element;
        rear = (rear + 1) % maxSize;
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
            // 队列为空
            return null;
        }
        Object obj = array[front];
        front = (front + 1) % maxSize;
        count--;
        return obj;
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

    /**
     * 队列是否已满
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        return count >= maxSize;
    }
}
