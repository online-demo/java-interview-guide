package com.example.interview.guide.chapter6.copyonwritearraylist;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-29 15:14
 * @Version : V1.0
 * @Description : CopyOnWriteArrayList使用方式演示
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList
                = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            copyOnWriteArrayList.add(i);
        }
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程。
        // 企业开发中应当使用线程池管理线程。
        // 遍历copyOnWriteArrayList中的元素。
        new Thread(() -> {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + "输出元素：" + copyOnWriteArrayList.get(i));
            }
        }).start();

        // 删除copyOnWriteArrayList中的偶数元素。
        new Thread(() -> {
            for (int i = 0; i < copyOnWriteArrayList.size(); i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (copyOnWriteArrayList.get(i) == 5) {
                    System.out.println(Thread.currentThread().getName()
                            + "删除元素：" + copyOnWriteArrayList.remove(i));
                }
            }
        }).start();

        Thread.sleep(2000);
        // 遍历CopyOnWriteArrayList中的元素。
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println("CopyOnWriteArrayList剩余元素：" + integer);
        }
    }
}
