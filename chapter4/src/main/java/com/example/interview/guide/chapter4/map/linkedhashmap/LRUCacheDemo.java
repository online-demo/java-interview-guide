package com.example.interview.guide.chapter4.map.linkedhashmap;

import java.util.Map;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-04 11:01
 * @Version : V1.0
 * @Description : 测试LRU算法
 */
public class LRUCacheDemo {
    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("Michael", 90);
        lruCache.put("Jack", 85);
        lruCache.put("John", 88);
        // 再次访问Michael
        lruCache.get("Michael");
        lruCache.put("Allen", 92);
        // 通过LRUCache控制缓存3个Entry。
        // Michael再次被访问，因此不会被删除。
        // 所以Jack应该会被删除。
        Set<Map.Entry<String, Integer>> entries
                = lruCache.entrySet();
        System.out.println("LRU算法运行结果：");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print(entry.getKey() + "=");
            System.out.print(entry.getValue());
            System.out.println();
        }
    }
}
