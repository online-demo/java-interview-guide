package com.example.interview.guide.chapter6.blockingqueue.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-28 10:07
 * @Version : V1.0
 * @Description : 消息对象
 */
public class Message implements Delayed {
    /**
     * 延迟时间
     */
    private long time;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 构造器
     *
     * @param content 消息内容
     * @param time    延迟时间
     * @param unit    延迟时间的单位
     */
    public Message(String content, long time, TimeUnit unit) {
        this.content = content;
        this.time = System.currentTimeMillis()
                + (time > 0 ? unit.toMillis(time) : 0);
    }

    /**
     * 重写Delayed接口的getDelay()方法
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return time - System.currentTimeMillis();
    }

    /**
     * 重写Comparable接口的compareTo()方法
     */
    @Override
    public int compareTo(Delayed o) {
        Message item = (Message) o;
        long diff = this.time - item.time;
        if (diff <= 0) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * 重写Object类的toString()方法
     */
    @Override
    public String toString() {
        return "Message{" +
                "time=" + time +
                ", content='" + content + '\'' +
                '}';
    }
}
