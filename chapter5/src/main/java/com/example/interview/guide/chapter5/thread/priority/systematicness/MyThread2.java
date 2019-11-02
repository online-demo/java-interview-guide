package com.example.interview.guide.chapter5.thread.priority.systematicness;

import java.util.Random;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 15:09
 * @Version : V1.0
 * @Description : 线程2
 */
public class MyThread2 extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("------2------ thread 2 start running");
        long count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                random.nextInt();
                count = count + i;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("------2------ thread 2 use time = " + (end - start));
    }
}
