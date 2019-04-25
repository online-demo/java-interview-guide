package com.example.java.interview.guide.chapter1.stack.sequence;

import com.example.java.interview.guide.chapter1.stack.Stack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-25 10:21
 * @Version : V1.0
 * @Description :   顺序栈实现
 */
public class SequenceStack implements Stack {
    /**
     * 顺序栈用于存储数据的数组
     */
    private Object[] data;
    /**
     * 顺序栈最大容量
     */
    private int maxSize;
    /**
     * 栈顶元素索引
     */
    private int top;
    /**
     * 顺序栈有参构造器
     *
     * @param maxSize      顺序栈最大容量
     */
    public SequenceStack(int maxSize) {
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }
    /**
     * 顺序栈无参构造器
     */
    public SequenceStack() {
        this(10);
    }
    /**
     * 栈是否为空
     *
     * @return true: 空  false: 非空
     */
    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈操作
     *
     * @param element   元素
     * @return          入栈结果
     */
    @Override
    public boolean push(Object element) {
        if (isFull()) {
            throw new RuntimeException("栈已满，不能加入元素");
        }
        data[top++] = element;
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
            throw new RuntimeException("栈为空，不能取出元素");
        }
        // 栈顶元素
        Object element = data[--top];
        // GC
        data[top] = null;
        return element;
    }

    /**
     * 栈的大小
     *
     * @return 栈中的元素个数
     */
    @Override
    public int size() {
        return top + 1;
    }

    /**
     * 栈是否已满
     *
     * @return      true: 空  false: 非空
     */
    public boolean isFull() {
        return top >= maxSize;
    }

}
