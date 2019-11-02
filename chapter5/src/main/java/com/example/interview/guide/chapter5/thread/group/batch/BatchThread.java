package com.example.interview.guide.chapter5.thread.group.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 19:02
 * @Version : V1.0
 * @Description : 批量线程
 */
public class BatchThread extends Thread {

    public BatchThread(ThreadGroup tg, String name) {
        super(tg, name);
    }

    @Override
    public void run() {
        System.out.println(printDate() + "线程：" +
                Thread.currentThread().getName() + "开始死循环了");
        while (!this.isInterrupted()) {

        }
        System.out.println(printDate() + "线程：" +
                Thread.currentThread().getName() + "结束了");
    }

    /**
     * 返回时间
     */
    static String printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}