package com.example.interview.guide.chapter5.thread.interrupt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-20 15:15
 * @Version : V1.0
 * @Description : 清除线程中断状态并重新中断线程
 */
public class ReInterruptDemo extends Thread {
    public static void main(String[] args) throws Exception {
        // 当前线程。
        String threadName = Thread.currentThread().getName();
        ReInterruptDemo reInterrupt = new ReInterruptDemo();
        System.out.println(printDate() + threadName + "线程启动");
        // 启动新线程。
        reInterrupt.start();
        // 主线程休眠3秒。
        Thread.sleep(3000);
        System.out.println(printDate() + threadName + "设置子线程中断");
        // 设置线程中断
        reInterrupt.interrupt();
        // 主线程休眠3秒。
        Thread.sleep(3000);
        System.out.println(printDate() + threadName + "运行结束");
    }

    @Override
    public void run() {
        // 当前线程。
        String threadName = Thread.currentThread().getName();
        // for循环等待线程中断。
        while (!Thread.currentThread().isInterrupted()) {

            System.out.println(printDate() + threadName + "线程正在执行");
            try {
                // 应该会执行3次。
                // 线程阻塞，如果线程收到中断操作信号将抛出异常。
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(printDate() + threadName + "线程正在执行");
                // 检测线程是否中断。
                System.out.println(printDate() +
                        threadName + this.isInterrupted());
                // 如果需要维护中断状态，则需要重新设置中断状态。
                // 如果不需要，则不用调用。
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(printDate() + threadName + "线程是否被中断："
                + this.isInterrupted());
        System.out.println(printDate() + threadName + "线程退出");
    }

    private static String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " ";
    }
}
