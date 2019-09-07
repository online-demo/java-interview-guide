package com.example.java.interview.guide.chapter3.queue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-28 16:07
 * @Version : V1.0
 * @Description :   队列接口
 */
public interface Queue {
    /**
     * 添加元素到队列
     *
     * @param element   队尾元素
     */
    void add(Object element);

    /**
     * 从队列获取元素
     *
     * @return          队头元素
     */
    Object take();

    /**
     * 队列的大小
     *
     * @return          队列包含的元素个数
     */
    int size();

    /**
     * 是否为空
     *
     * @return          队列是否为空
     */
    boolean isEmpty();
}
