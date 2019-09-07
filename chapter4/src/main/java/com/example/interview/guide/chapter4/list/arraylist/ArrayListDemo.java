package com.example.interview.guide.chapter4.list.arraylist;

import java.util.Iterator;
import java.util.ArrayList;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/8/12 11:04
 * @Version : V1.0
 * @Description : ArrayList的使用方式
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        // 创建一个ArrayList对象
        ArrayList<Integer> arrayList = new ArrayList<>();
        // 元素个数
        int size = 10;
        // 初始化arrayList中的元素
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }
        // 调用有参构造传入arrayList作为参数
        ArrayList<Integer> otherList = new ArrayList<>(arrayList);
        System.out.printf("arrayList第0个位置元素是：%s%n"
                , arrayList.get(0));
        System.out.printf("arrayList元素5所在的位置是：%s%n"
                , arrayList.get(5));
        System.out.printf("arrayList是否包含元素10：%s%n"
                , arrayList.contains(10));
        System.out.printf("arrayList删除第0个位置的元素：%s%n"
                , arrayList.remove(0));
        // 获取ArrayList的迭代器
        Iterator<Integer> iterator = arrayList.iterator();
        // 是否还有下一个元素
        while (iterator.hasNext()) {
            // iterator迭代输出每个元素
            Integer element = iterator.next();
            System.out.printf("iterator()迭代器输出arrayList元素：%s%n"
                    , element);
            // 迭代出的元素等于5时进行删除
            if (element == 5) {
                // 取消注释下面代码，会抛出ConcurrentModificationException异常
                // arrayList.remove(0);
                iterator.remove();
                System.out.printf("iterator()迭代器删除arrayList元素：%s%n"
                        , element);
                break;
            }
        }
        iterator.forEachRemaining(integer -> System.out
                .printf("forEachRemaining()输出arrayList元素：%s%n"
                        , integer));
        // 删除与arrayList交集的部分
        otherList.removeAll(arrayList);
        // 通过forEach方法迭代
        otherList.forEach(integer -> System.out
                .printf("forEach()方法输出otherList元素：%s%n", integer));
    }
}
