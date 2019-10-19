package com.example.interview.guide.chapter5.thread.create.thread;
import	java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-19 16:36
 * @Version : V1.0
 * @Description : 继承Thread类创建线程
 */
public class HelloWorldThread extends Thread {

    /**
     * 重写run()方法，run()方法的方法体就是线程的执行体
     */
    @Override
    public void run(){
        System.out.println(printDate() +
                " HelloWorldThread线程输出：Hello World");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(printDate()
                + " --------主线程创建子线程--------");
        HelloWorldThread helloWorldThread = new HelloWorldThread();
        System.out.println(printDate()
                + " --------主线程启动子线程--------");
        helloWorldThread.start();
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
