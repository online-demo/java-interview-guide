package com.example.interview.guide.chapter5.thread.create.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-10-19 17:47
 * @Version : V1.0
 * @Description : 实现Callable接口创建线程
 */
public class CalculateCallable {
    public static void main(String[] args) {
        // FutureTask对象。
        // Lambda表达式。
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int count = 0;
            for (int i = 0; i <= 100; i++) {
                count += i;
            }
            return count;
        });
        // 创建线程。
        Thread thread = new Thread(task);
        // 启动线程。
        thread.start();
        try {
            // 获取线程返回值。
            System.out.println("1 + 2 + 3 + ... + 100 = " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
