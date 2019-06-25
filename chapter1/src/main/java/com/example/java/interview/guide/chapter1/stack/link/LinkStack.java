package com.example.java.interview.guide.chapter1.stack.link;

import com.example.java.interview.guide.chapter1.stack.Stack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-25 16:34
 * @Version : V1.0
 * @Description : 链式栈
 */
public class LinkStack implements Stack {
    /**
     * 栈顶元素
     */
    private Node top;
    /**
     *  链式栈长度
     */
    private int size;
    /**
     * 链式栈构造器
     */
    public LinkStack() {
        this.top = null;
    }

    /**
     * 定义一个内部类Node，代表链式栈的结点
     */
    private class Node {
        /**
         * 保存链式栈的结点数据
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
         * @param element       链式栈结点数据
         * @param next          链式栈下一个结点指针
         */
        public Node(Object element, Node next) {
            this.data = element;
            this.next = next;
        }
    }

    /**
     * 栈是否为空
     *
     * @return true: 空  false: 非空
     */
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * 入栈操作
     *
     * @param element 元素
     * @return 入栈结果
     */
    @Override
    public boolean push(Object element) {
        if (element == null) {
            throw new NullPointerException("入栈元素为空");
        }
        // 创建新Node结点，新结点指向原top结点
        Node node = new Node(element, top);
        // 修改top结点指向
        top = node;
        size++;
        return true;
    }

    /**
     * 出栈
     *
     * @return 元素
     */
    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        }
        // 当前栈顶元素
        Object element = top.data;
        // 修改栈顶元素为原栈顶元素的下一个结点
        top = top.next;
        size--;
        return element;
    }

    /**
     * 栈的大小
     *
     * @return 栈中的元素个数
     */
    @Override
    public int size() {
        return size;
    }
}
