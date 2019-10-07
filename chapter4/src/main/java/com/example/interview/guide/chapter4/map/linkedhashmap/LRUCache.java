package com.example.interview.guide.chapter4.map.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-04 11:00
 * @Version : V1.0
 * @Description : LRU算法
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    /**
     * 缓存的最大Entry数量
     */
    private int maxEntries;

    public LRUCache(int maxEntries) {
        super(16, 0.75f, true);
        this.maxEntries = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxEntries;
    }

}
