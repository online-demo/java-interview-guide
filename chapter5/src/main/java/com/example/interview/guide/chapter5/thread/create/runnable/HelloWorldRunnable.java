package com.example.interview.guide.chapter5.thread.create.runnable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-19 16:51
 * @Version : V1.0
 * @Description : 实现Runnable接口创建线程
 */
public class HelloWorldRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(printDate()
                + " HelloWorldThread线程输出：Hello World");
    }

    public static void main(String[] args) throws InterruptedException {

        HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable();
        System.out.println(printDate()
                + " --------主线程创建子线程--------");
        Thread thread = new Thread(helloWorldRunnable);
        System.out.println(printDate()
                + " --------主线程启动子线程--------");
        thread.start();
        System.out.println(printDate()
                + " ---------主线程休眠3秒---------");
        Thread.sleep(3000);
        System.out.println(printDate()
                + " --------主线程执行结束--------");

    }

    private static String printDate() {
        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
