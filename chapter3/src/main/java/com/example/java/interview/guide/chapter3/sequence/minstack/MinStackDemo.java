package com.example.java.interview.guide.chapter3.sequence.minstack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 测试最小栈
 */
public class MinStackDemo {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(1);
        minStack.push(3);
        minStack.push(4);
        minStack.push(0);
        System.out.print("当前栈的最小元素：");
        System.out.println(minStack.getMin());
        System.out.print("当前栈出栈的元素：");
        System.out.println(minStack.pop());
        System.out.print("当前栈的栈顶元素：");
        System.out.println(minStack.top());
        System.out.print("当前栈的最小元素：");
        System.out.println(minStack.getMin());
    }
}
