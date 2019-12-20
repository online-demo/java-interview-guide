package com.example.interview.guide.chapter5.volatiledemo;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-10 23:37
 * @Version : V1.0
 * @Description : volatile重排序演示
 */
public class VolatileDemo {
    /**
     * 变量
     */
    int a = 0;
    /**
     * 标记
     */
    boolean flag = false;

    /**
     * 写入数据
     */
    public void write() {
        // 语句1
        a = 1;
        // 语句2
        flag = true;
    }

    /**
     * 读取数据
     */
    public void read() {
        // 语句3
        if (flag) {
            // 语句4
            int i = a * a;
        }
    }
}
