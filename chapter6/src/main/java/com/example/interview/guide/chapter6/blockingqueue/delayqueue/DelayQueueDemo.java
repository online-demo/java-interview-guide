package com.example.interview.guide.chapter6.blockingqueue.delayqueue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 10:06
 * @Version : V1.0
 * @Description : DelayQueueDemo使用方式演示
 */
public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 消息1延迟5秒出队。
        Message item1 = new Message("消息1", 5, TimeUnit.SECONDS);
        // 消息2延迟10秒出队。
        Message item2 = new Message("消息2", 10, TimeUnit.SECONDS);
        // 消息3延迟15秒出队。
        Message item3 = new Message("消息3", 15, TimeUnit.SECONDS);
        DelayQueue<Message> queue = new DelayQueue<>();
        // 向DelayQueue中添加元素
        queue.put(item1);
        queue.put(item2);
        queue.put(item3);
        System.out.println(printDate() + " DelayQueue元素出队测试开始");
        for (int i = 0; i < 3; i++) {
            Message take = queue.take();
            System.out.format(printDate() + " 消息%s出队%n", take);
        }
        System.out.println(printDate() + " DelayQueue元素出队测试结束");
    }

    /**
     * 返回当前时间
     *
     * @return 当前时间
     */
    private static String printDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
