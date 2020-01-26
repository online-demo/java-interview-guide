package com.example.interview.guide.chapter5.sync.communication;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2020-01-01 16:53
 * @Version : V1.0
 * @Description : Synchronized实现线程间通信
 */
public class SynchronizedCommunicationDemo {
    /**
     * 写入数据的线程。
     */
    private static class Writer implements Runnable {
        /**
         * 管道字符输出流。
         */
        private PipedWriter pipedWriter;

        /**
         * 构造器
         *
         * @param writer 管道字符输出流。
         */
        private Writer(PipedWriter writer) {
            pipedWriter = writer;
        }

        /**
         * 重写run()方法。
         */
        @Override
        public void run() {
            // 输入的字符。
            int receive;
            try {
                // 读取控制台写入的字符。
                while ((receive = System.in.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + "写入字符:" + (char) receive);
                    // 写入字符到到管道字符输出流中。
                    pipedWriter.write(receive);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭流。
                    pipedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 打印数据的线程。
     */
    private static class Printer implements Runnable {
        /**
         * 管道字符输入流。
         */
        private PipedReader pipedReader;

        /**
         * 构造器。
         *
         * @param in 管道字符输入流。
         */
        private Printer(PipedReader in) {
            this.pipedReader = in;
        }

        @Override
        public void run() {
            // 输入的字符。
            int receive;
            try {
                // 管道字符输入流读取数据。
                while ((receive = pipedReader.read()) != -1) {
                    System.out.println(Thread.currentThread().getName() + "打印字符:" + (char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建输出流对象。
        PipedWriter out = new PipedWriter();
        // 创建输入流对象。
        PipedReader in = new PipedReader();
        // 输出流与输入流相连接。
        out.connect(in);
        // 创建打印线程，并启动线程。
        Thread printThread = new Thread(new Printer(in), "打印线程");
        printThread.start();
        // 一般企业开发中不建议手动创建线程，
        // 此处为了简单起见，手动创建线程
        // 企业开发中应当使用线程池管理线程。
        // 创建写入线程，并启动线程。
        Thread writeThread = new Thread(new Writer(out), "写入线程");
        writeThread.start();
    }
}
