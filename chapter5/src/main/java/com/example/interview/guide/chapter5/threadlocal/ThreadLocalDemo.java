package com.example.interview.guide.chapter5.threadlocal;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-02 22:59
 * @Version : V1.0
 * @Description : ThreadLocal使用方式演示
 */
public class ThreadLocalDemo {
    /**
     * 定义了一个ThreadLocal对象，
     * 并重写它的initialValue方法，初始值是3
     * 这个对象会在3个线程间共享。
     */
    private ThreadLocal<Integer> threadLocal = ThreadLocal
            .withInitial(() -> 3);
    /**
     * 设置一个信号量，许可数为1，让三个线程顺序执行。
     */
    private Semaphore semaphore = new Semaphore(1);
    /**
     * 一个随机数。
     */
    private Random random = new Random();

    /**
     * 工作线程，操作ThreadLocal。
     */
    public class Worker implements Runnable {
        @Override
        public void run() {

            try {
                // 随机延时1s以内的时间。
                Thread.sleep(random.nextInt(1000));
                // 获取许可。
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 从threadLocal中获取值。
            int value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() +
                    " threadLocal old value : " + value);
            // 修改value值
            value = random.nextInt();
            // 新的value值放入threadLocal中。
            threadLocal.set(value);
            System.out.println(Thread.currentThread().getName() +
                    " threadLocal new value: " + value);
            System.out.println(Thread.currentThread().getName() +
                    " threadLocal latest value : " + threadLocal.get());
            // 释放信号量。
            semaphore.release();
            // 在线程池中,当线程退出之前一定要记得调用remove方法
            // 因为在线程池中的线程对象是循环使用的。
            // 如果不清除ThreadLocal可能会造成下一个任务进入线程池后，
            // 会得到上次保存的ThreadLocal。
            threadLocal.remove();
        }
    }

    /**
     * 创建三个线程，每个线程都会对ThreadLocal对象进行操作。
     */
    public static void main(String[] args) {
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，通过Executors创建线程池
        // 企业开发中应当使用ThreadPoolExecutor创建线程池。
        ExecutorService executorService = Executors
                .newFixedThreadPool(3);
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        executorService.execute(threadLocalDemo.new Worker());
        executorService.execute(threadLocalDemo.new Worker());
        executorService.execute(threadLocalDemo.new Worker());
        executorService.execute(threadLocalDemo.new Worker());
        executorService.execute(threadLocalDemo.new Worker());
        // 关闭线程池。
        executorService.shutdown();
    }
}
