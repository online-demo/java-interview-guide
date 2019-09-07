package com.example.interview.guide.chapter4.list.linkedlist;

import java.util.Iterator;

import java.util.LinkedList;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/8/12 11:05
 * @Version : V1.0
 * @Description : LinkedList的使用方式
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        // 创建一个LinkedList对象
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = 10;
        // 初始化linkedList中的元素
        for (int i = 0; i < size; i++) {
            linkedList.add(i);
        }
        // forEach输出linkedList中的元素
        linkedList.forEach(integer
                -> System.out.printf("输出linkedList中的元素：%s%n", integer));
        linkedList.addFirst(-1);
        System.out.printf("linkedList第一个元素是：%s%n", linkedList.getFirst());
        linkedList.addLast(10);
        System.out.printf("linkedList是否包含元素10：%s%n", linkedList.contains(10));
        System.out.printf("linkedList最后一个元素是：%s%n", linkedList.getLast());
        System.out.printf("linkedList第5个位置上的元素是：%s%n", linkedList.get(5));
        System.out.printf("linkedList元素10所在的位置是：%s%n", linkedList.indexOf(10));
        linkedList.remove(0);
        // 获取迭代器
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.printf("iterator迭代器输出元素：%s%n", element);
            if (element == 8) {
                iterator.remove();
                System.out.printf("iterator迭代器删除元素8：%s%n", element);
                break;
            }
        }
        // forEachRemaining迭代剩余元素
        iterator.forEachRemaining(integer
                -> System.out.printf("forEachRemaining()输出：%s%n", integer));
    }
}
