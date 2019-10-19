package com.example.interview.guide.chapter4.set.linkedhashset;
import java.util.Iterator;
import	java.util.LinkedHashSet;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/10/10 10:07
 * @Version : V1.0
 * @Description : LinkedHashSet使用方式
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<> ();
        linkedHashSet.add("Michael");
        linkedHashSet.add("Jack");
        linkedHashSet.add("John");
        linkedHashSet.add("Allen");
        Iterator<String> iterator = linkedHashSet.iterator();
        System.out.println("linkedHashSet中包含的元素是：");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.printf("hashSet中是否包含Allen：%b%n",
                linkedHashSet.contains("Allen"));
        System.out.printf("hashSet中删除Allen：%b%n",
                linkedHashSet.remove("Allen"));
        System.out.println("linkedHashSet中包含的元素是：");
        linkedHashSet.forEach(System.out::println);
    }
}
