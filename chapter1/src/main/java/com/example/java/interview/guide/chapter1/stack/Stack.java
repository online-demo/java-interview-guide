package com.example.java.interview.guide.chapter1.stack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-24 21:42
 * @Version : V1.0
 * @Description :  栈接口
 */
public interface Stack {
    /**
     * 栈是否为空
     *
     * @return      true: 空  false: 非空
     */
    boolean isEmpty();

    /**
     * 入栈操作
     *
     * @param element   元素
     * @return          入栈结果
     */
    boolean push(Object element);

    /**
     * 出栈
     *
     * @return          元素
     */
    Object pop();

    /**
     * 栈的大小
     *
     * @return          栈中的元素个数
     */
    int size();
}
