package com.example.interview.guide.chapter4.set.hashset;
import	java.util.HashSet;
import java.util.Iterator;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/10/9 9:51
 * @Version : V1.0
 * @Description : HashSet使用方式
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<> ();
        hashSet.add("Michael");
        hashSet.add("Jack");
        hashSet.add("John");
        hashSet.add("Allen");
        Iterator<String> iterator = hashSet.iterator();
        System.out.println("hashSet中包含的元素是：");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.printf("hashSet中是否包含Andy：%b%n", hashSet.contains("Allen"));
        System.out.printf("hashSet中删除Andy：%b%n", hashSet.remove("Allen"));
        System.out.println("forEach输出hashSet的元素：");
        hashSet.forEach(System.out::println);
    }
}
