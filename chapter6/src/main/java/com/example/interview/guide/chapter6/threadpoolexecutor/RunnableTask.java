package com.example.interview.guide.chapter6.threadpoolexecutor;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-02-03 12:33
 * @Version : V1.0
 * @Description : 创建任务类
 */
public class RunnableTask implements Runnable {
    /**
     * 任务名
     */
    private String name;

    /**
     * 构造器
     */
    public RunnableTask(String name) {
        this.name = name;
    }

    /**
     * 重写run()方法
     */
    @Override
    public void run() {
        try {
            System.out.println(IgnorePolicy.printDate()
                    + this + "处理开始");
            // 让任务执行慢点，休眠3秒
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(IgnorePolicy.printDate()
                + this + "处理结束");
    }

    @Override
    public String toString() {
        return "任务[name=" + name + "]";
    }
}
