package com.example.java.interview.guide.chapter3.sequence.minstack;

import java.util.Stack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 最小栈
 */
public class MinStack {
    /**
     * 普通栈  存放元素
     */
    private Stack<Integer> stack;
    /**
     * 辅助栈  存放最小值的索引位置
     */
    private Stack<Integer> minStack;

    /**
     * 构造器
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /**
     * 入栈
     *
     * @param element   入栈元素
     */
    public void push(int element) {
        stack.push(element);
        // 入栈元素比当前最小元素小
        if (minStack.isEmpty() || element <= minStack.peek()) {
            // 将element放入最小栈的栈顶
            minStack.push(element);
        }
    }

    /**
     * 出栈
     *
     * @return      栈顶元素
     */
    public Integer pop() {
        // 出栈的元素是最小元素
        if (stack.peek().equals(minStack.peek())) {
            // 最小栈出栈
            minStack.pop();
        }
        // 出栈
        return stack.pop();
    }

    /**
     * 查询栈顶元素
     *
     * @return      栈顶元素
     */
    public Integer top() {
        // 返回栈顶元素
        return stack.peek();
    }

    /**
     * 查询最小元素
     *
     * @return      最小元素
     */
    public Integer getMin() {
        // 返回最小栈的额栈顶元素
        return minStack.peek();
    }
}
