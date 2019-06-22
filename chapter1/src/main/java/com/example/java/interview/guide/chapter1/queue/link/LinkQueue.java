package com.example.java.interview.guide.chapter1.queue.link;

import com.example.java.interview.guide.chapter1.queue.Queue;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-28 19:24
 * @Version : V1.0
 * @Description :   队列链式存储
 */
public class LinkQueue implements Queue {
    /**
     *  队列头部元素
     */
    private Node head;
    /**
     *  队列尾部元素
     */
    private Node tail;
    /**
     *  队列长度
     */
    private int size;
    /**
     *  队列构造器
     */
    public LinkQueue() {
        this.head = null;
    }

    /**
     * 定义一个内部类Node，代表队列的结点
     */
    private class Node {
        /**
         * 保存队列的结点数据
         */
        private Object data;
        /**
         * 指向下个结点的引用
         */
        private Node next;
        /**
         * Node无参构造器
         */
        public Node() {

        }
        /**
         * Node有参构造器
         *
         * @param element       队列结点数据
         * @param next          队列下一个结点指针
         */
        public Node(Object element, Node next) {
            this.data = element;
            this.next = next;
        }
    }
    /**
     * 添加元素到队列
     *
     * @param element 队尾元素
     */
    @Override
    public void add(Object element) {
        if (isEmpty()) {
            head = new Node(element, null);
            tail = head;
        } else {
            Node node = new Node(element, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * 从队列获取元素
     *
     * @return 队头元素
     */
    @Override
    public Object take() {
        Object data = head.data;
        head = head.next;
        size--;
        return data;
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
     * 是否为空
     *
     * @return 队列是否为空
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
