package com.example.java.interview.guide.chapter3.queue.sequence;

import com.example.java.interview.guide.chapter3.queue.Queue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-28 16:14
 * @Version : V1.0
 * @Description : 顺序队列的实现
 */
public class SequenceQueue implements Queue {
    /**
     * 存储队列中元素的数组
     */
    private Object[] array;
    /**
     * 队列的大小
     */
    private int size;

    public SequenceQueue(int initialCapacity) {
        array = new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * 添加元素到队列
     *
     * @param element 队尾元素
     */
    @Override
    public void add(Object element) {
        array[size++] = element;
    }

    /**
     * 从队列获取元素
     *
     * @return 队头元素
     */
    @Override
    public Object take() {
        Object element = array[0];
        for (int i = 1; i < size; i++) {
            array[i - 1]  = array[i];
        }
        size--;
        return element;
    }

    /**
     * 队列的大小
     *
     * @return 队列包含的元素个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 队列是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 队列是否已满
     *
     * @return 队列是否已满
     */
    public boolean isFull() {
        return size >= array.length;
    }
}
