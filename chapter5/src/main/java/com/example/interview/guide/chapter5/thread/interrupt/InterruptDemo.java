package com.example.interview.guide.chapter5.thread.interrupt;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 14:47
 * @Version : V1.0
 * @Description : 中断线程及检测线程中断
 */
public class InterruptDemo {
    public static void main(String[] args) {
        // 通过interrupted()方法检测线程是否被中断。
        System.out.println(Thread.currentThread().getName()
                + "线程是否中断：" + Thread.interrupted());
        // 设置线程中断。
        Thread.currentThread().interrupt();
        // 通过interrupted()方法检测线程是否被中断。
        System.out.println(Thread.currentThread().getName()
                + "线程是否中断：" + Thread.interrupted());
        // 检测interrupted()是否会清除线程状态。
        System.out.println(Thread.currentThread().getName()
                + "线程是否中断：" + Thread.interrupted());
    }
}
