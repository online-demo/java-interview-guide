package com.example.interview.guide.chapter5.sync.principles;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 16:12
 * @Version : V1.0
 * @Description : synchronized同步块字节码
 */
public class SynchronizedBlockByteCodeDemo {

    /**
     * synchronized同步块
     */
    public void method() {
        synchronized (this) {
            System.out.println("Method 1 start");
        }
    }
}
