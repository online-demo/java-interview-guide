package com.example.interview.guide.chapter4.map.linkedhashmap;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-04 10:08
 * @Version : V1.0
 * @Description : LinkedHashMap使用
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // 测试LinkedHashMap按照插入顺序访问元素。
        Map<String, Integer> linkedHashMap
                = new LinkedHashMap<> ();
        linkedHashMap.put("Michael", 90);
        linkedHashMap.put("Jack", 85);
        linkedHashMap.put("John", 88);
        linkedHashMap.put("Allen", 92);
        print(linkedHashMap, "LinkedHashMap按插入顺序打印成绩，打印结果：");

        // 测试HashMap按照插入顺序访问元素。
        Map<String, Integer> hashMap
                = new HashMap<>(8);
        hashMap.put("Michael", 90);
        hashMap.put("Jack", 85);
        hashMap.put("John", 88);
        hashMap.put("Allen", 92);
        print(hashMap, "使用HashMap按插入顺序打印成绩，打印结果：");

        // 测试LinkedHashMap按照访问顺序访问元素。
        Map<String, Integer> linkedHashMapAccessOrder
                = new LinkedHashMap<>(8, 0.75f, true);
        linkedHashMapAccessOrder.put("Michael", 90);
        linkedHashMapAccessOrder.put("Jack", 85);
        linkedHashMapAccessOrder.put("John", 88);
        linkedHashMapAccessOrder.put("Allen", 92);
        linkedHashMapAccessOrder.get("Michael");
        print(linkedHashMapAccessOrder,
                "LinkedHashMap按访问顺序打印成绩，打印结果：");
    }

    private static void print(Map<String, Integer> hashMap, String msg) {
        Set<Map.Entry<String, Integer>> entries
                = hashMap.entrySet();
        System.out.println(msg);
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + "=");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }
}
