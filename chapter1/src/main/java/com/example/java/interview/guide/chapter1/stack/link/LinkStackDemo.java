package com.example.java.interview.guide.chapter1.stack.link;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-25 17:46
 * @Version : V1.0
 * @Description : 测试链式栈
 */
public class LinkStackDemo {
    public static void main(String[] args) {
        int size = 10;
        LinkStack linkStack = new LinkStack();
        for (int i = 0; i < size; i++) {
            linkStack.push(i);
        }
        System.out.println("----------链式栈是否为空----------");
        System.out.println(linkStack.isEmpty());
        System.out.println("----------链式栈元素个数----------");
        System.out.println(linkStack.size());
        System.out.println("----------打印链式栈元素----------");
        for (int i = 0; i < size; i++) {
            System.out.print(linkStack.pop() + " ");
        }
    }
}
