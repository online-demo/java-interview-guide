package com.example.interview.guide.chapter6.blockingqueue.linkedblockingdeque;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 16:51
 * @Version : V1.0
 * @Description : 数据交换
 */
public class Exchanger {
    /**
     * 用于保存数据的仓库
     */
    private LinkedBlockingDeque<String> buffer;

    public Exchanger(LinkedBlockingDeque<String> buffer) {
        this.buffer = buffer;
    }

    /**
     * 添加数据
     */
    public void produce(String message) throws InterruptedException {
        buffer.put(message);
    }

    /**
     * 获取数据，如果没有数据就返回null.
     */
    public String consume() throws InterruptedException {
        return buffer.poll(1000, TimeUnit.MILLISECONDS);
    }
}
