package com.example.interview.guide.chapter3.reference;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-26 10:11
 * @Version : V1.0
 * @Description :   引用测试
 */
public class WeakReferenceDemo {
    private static ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();
    private static int ONE_M = 1024*1024;
    private static final int MAX = 10000;
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Map<Object, Object> map = new HashMap<>(15000);
        Thread thread = new Thread(() -> {
            try {
                int count = 0;
                WeakReference<byte[]> k;
                while((k = (WeakReference) referenceQueue.remove()) != null) {
                    System.out.println((count++) + "回收了:" + k);
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        for(int i = 0; i < MAX; i++) {
            byte[] bytes = new byte[ONE_M];
            WeakReference<byte[]> weakReference = new WeakReference<>(bytes, referenceQueue);
            map.put(weakReference, object);
        }

        System.out.println("map.size=" + map.size());

        Thread.yield();
    }
}
