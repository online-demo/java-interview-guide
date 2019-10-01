package com.example.interview.guide.chapter4.map;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-01 13:42
 * @Version : V1.0
 * @Description : HashMap的使用方式
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> studentCore =
                new HashMap<>(16);
        studentCore.put("Michael", 90);
        studentCore.put("Jack", 85);
        studentCore.put("John", 88);
        studentCore.put("Allen", 92);
        System.out.printf("Michael的分数是：%s%n",
                studentCore.get("Michael"));
        System.out.printf("Allen的分数是：%s%n",
                studentCore.get("Allen"));
        studentCore.replace("Michael", 90, 95);
        System.out.printf("Michael的更新后分数是：%s%n",
                studentCore.get("Michael"));
        studentCore.put("Allen", 90);
        System.out.printf("Allen的更新后分数是：%s%n",
                studentCore.get("Allen"));
        System.out.printf("studentCore键值对个数是：%s%n",
                studentCore.size());
        System.out.printf("studentCore是否含有John键：%s%n",
                studentCore.containsKey("John"));
        studentCore.remove("John");
        System.out.printf("studentCore删除John后，是否含有John键：%s%n",
                studentCore.containsKey("John"));
        System.out.printf("studentCore删除John后键值对个数是：%s%n",
                studentCore.size());
        Set<String> students = studentCore.keySet();
        System.out.print("studentCore所有的键是：");
        for (String student : students) {
            System.out.print(student + " ");
        }
        System.out.println();
        Collection<Integer> scores = studentCore.values();
        System.out.print("studentCore所有的值是：");
        for (Integer score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        System.out.println("遍历studentCore中的键值对：");
        Set<Map.Entry<String, Integer>> entrySet =
                studentCore.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.printf("key=%s,", entry.getKey());
            System.out.printf("value=%s", entry.getValue());
            System.out.println();
        }
        System.out.println("遍历studentCore中的键值对：");
        studentCore.forEach((key, value) -> {
            System.out.printf("key=%s,", key);
            System.out.printf("value=%s", value);
            System.out.println();
        });

    }
}
