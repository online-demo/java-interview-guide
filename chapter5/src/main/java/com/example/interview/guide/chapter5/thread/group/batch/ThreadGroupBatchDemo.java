package com.example.interview.guide.chapter5.thread.group.batch;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-11-02 19:03
 * @Version : V1.0
 * @Description : 线程组批量管理线程
 */
public class ThreadGroupBatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int batch = 5;
        ThreadGroup threadGroup = new ThreadGroup("我的线程组");
        for (int i = 0; i < batch; i++) {
            BatchThread batchThread
                    = new BatchThread(threadGroup, "线程" + i);
            batchThread.start();
        }
        // 主线程休眠10秒。
        Thread.sleep(10000);
        // 线程组中断。
        threadGroup.interrupt();
        System.out.println(BatchThread.printDate()
                + "调用了ThreadGroup.interrupt()方法");
    }
}
