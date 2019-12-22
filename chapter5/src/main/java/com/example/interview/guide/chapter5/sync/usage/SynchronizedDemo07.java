package com.example.interview.guide.chapter5.sync.usage;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-12-22 13:57
 * @Version : V1.0
 * @Description : class对象充当锁
 */
public class SynchronizedDemo07 implements Runnable {
    /**
     * 共享资源
     */
    private static int TOTAL_COUNT = 0;

    @Override
    public void run() {
        //省略其他耗时操作....
        //使用同步代码块对变量i进行同步操作,锁对象为instance
        synchronized (SynchronizedDemo07.class) {
            for (int j = 0; j < 10; j++) {
                System.out.println(TimeUtils.currentTime()
                        + " " + Thread.currentThread().getName()
                        + "执行累加操作。。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                TOTAL_COUNT++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedDemo07 test = new SynchronizedDemo07();
        Thread t1 = new Thread(test, "线程1");
        Thread t2 = new Thread(test,"线程2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("TOTAL_COUNT=" + TOTAL_COUNT);
    }
}
