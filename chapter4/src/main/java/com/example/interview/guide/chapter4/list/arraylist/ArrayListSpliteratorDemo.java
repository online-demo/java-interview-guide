package com.example.interview.guide.chapter4.list.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-09-22 11:07
 * @Version : V1.0
 * @Description : ArrayListSpliterator使用Demo
 */
public class ArrayListSpliteratorDemo {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");
        arrayList.add("7");
        arrayList.add("8");
        arrayList.add("9");
        Spliterator<String> spliterator1 =  arrayList.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        Spliterator<String> spliterator3 = spliterator1.trySplit();
        Spliterator<String> spliterator4 = spliterator1.trySplit();
        System.out.print("spliterator1的范围：");
        spliterator1.forEachRemaining(System.out::print);
        System.out.println();
        System.out.print("spliterator2的范围：");
        spliterator2.forEachRemaining(System.out::print);
        System.out.println();
        System.out.print("spliterator3的范围：");
        spliterator3.forEachRemaining(System.out::print);
        System.out.println();
        System.out.print("spliterator4的范围：");
        spliterator4.forEachRemaining(System.out::print);
    }
}
