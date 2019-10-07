package com.example.interview.guide.chapter4.map.treemap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-07 22:59
 * @Version : V1.0
 * @Description : TreeMap使用方式
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(90, "Michael");
        treeMap.put(85, "Jack");
        treeMap.put(88, "John");
        treeMap.put(92, "Allen");
        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.printf("treeMap中最小的键是：%s%n",
                treeMap.firstKey());
        System.out.printf("treeMap中最大的键是：%s%n",
                treeMap.lastKey());
        System.out.printf("treeMap中严格小于90的最大的键是：%s%n",
                treeMap.lowerKey(90));
        System.out.printf("treeMap中严格大于88的最小的键是：%s%n",
                treeMap.higherKey(88));
        System.out.printf("treeMap中小于或等于95的最大的键是：%s%n",
                treeMap.floorKey(95));
        System.out.printf("treeMap中包含的大于或等于89的最小键：%s%n",
                treeMap.ceilingKey(89));
        System.out.println("treeMap中包含的键值对的逆序视图：");
        System.out.println(treeMap.descendingMap());
    }
}
