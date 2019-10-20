package com.example.interview.guide.chapter5.thread.interrupt;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 14:56
 * @Version : V1.0
 * @Description : 中断线程并检测线程中断
 */
public class IsInterruptedDemo {
    public static void main(String[] args) {
        // 当前线程。
        Thread thread = Thread.currentThread();
        // 检测当前线程是否被中断。
        System.out.println(thread.getName() + "线程是否中断："
                + thread.isInterrupted());
        // 设置线程中断标识。
        thread.interrupt();
        // 检测当前线程是否被中断。
        System.out.println(thread.getName() + "线程是否中断："
                + thread.isInterrupted());
        // 检测线程中断状态是否被清除。
        System.out.println(thread.getName() + "线程是否中断："
                + thread.isInterrupted());
        try {
            // 线程休眠2s。
            Thread.sleep(2000);
            System.out.println(thread.getName() + "线程休眠未被中断...");
        } catch (Exception e) {
            System.out.println(thread.getName() + "线程休眠被中断...");
            // 判断线程是否被中断
            System.out.println(thread.getName() + "线程是否中断："
                    + thread.isInterrupted());
        }
        System.out.println(thread.getName() + "线程是否中断："
                + thread.isInterrupted());
    }
}
