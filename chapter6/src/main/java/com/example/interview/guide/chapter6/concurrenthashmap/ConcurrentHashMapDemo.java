package com.example.interview.guide.chapter6.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-30 11:02
 * @Version : V1.0
 * @Description : ConcurrentHashMap使用方式演示
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建ConcurrentHashMap，初始容量设置为16.
        ConcurrentHashMap<String, Integer> concurrentHashMap
                = new ConcurrentHashMap<>(16);
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        // 创建一个线程，向ConcurrentHashMap中添加10个元素
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                concurrentHashMap.put(String.valueOf(i), i);
            }
        }).start();
        // 创建一个线程，将ConcurrentHashMap中的偶数键的值乘以2
        new Thread(() -> {
            for (Map.Entry<String, Integer> entry : concurrentHashMap.entrySet()) {
                if (Integer.parseInt(entry.getKey()) % 2 == 0) {
                    concurrentHashMap.put(entry.getKey(), 2 * entry.getValue());
                }
            }
        }).start();

        Thread.sleep(100);
        // 打印ConcurrentHashMap中的所有键值对。
        concurrentHashMap.forEach((key, value) ->
                System.out.println("[key=" + key + ",value=" + value + "]"));
    }
}
