package com.example.interview.guide.chapter5.thread.interrupt;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 15:08
 * @Version : V1.0
 * @Description : 中断线程并抛出异常后重新抛出异常
 */
public class RethrowInterruptExceptionDemo {
    public static void main(String[] args) throws InterruptedException {
        // 当前线程。
        Thread thread = Thread.currentThread();
        try {
            // 检测当前线程是否被中断。
            thread.interrupt();
            // 线程休眠3s。
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(thread.getName()
                    + "抛出InterruptedException中断异常");
            System.out.println(thread.getName()
                    + "做一些清理工作");
            throw e;
        }
    }
}
