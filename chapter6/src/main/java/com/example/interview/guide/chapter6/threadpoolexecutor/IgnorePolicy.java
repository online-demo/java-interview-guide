package com.example.interview.guide.chapter6.threadpoolexecutor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-03 12:38
 * @Version : V1.0
 * @Description : 创建线程池饱和策略
 */
public class IgnorePolicy implements RejectedExecutionHandler {
    /**
     * 重写rejectedExecution()方法
     */
    @Override
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor e) {
        doLog(runnable, e);
    }

    /**
     * 打印日志
     */
    private void doLog(Runnable runnable, ThreadPoolExecutor e) {
        // 可做日志记录等
        System.err.println(printDate() + runnable.toString() + "被拒绝");
    }

    /**
     * 返回时间
     */
    static String printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date()) + " ";
    }
}
