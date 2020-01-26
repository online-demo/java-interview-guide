package com.example.interview.guide.chapter5.sync.principles;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 18:13
 * @Version : V1.0
 * @Description : synchronized同步方法字节码
 */
public class SynchronizedMethodByteCodeDemo {
    /**
     * synchronized同步方法
     */
    public synchronized void method() {
        System.out.println("Hello World!");
    }
}
