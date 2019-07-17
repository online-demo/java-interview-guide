package com.example.java.interview.guide.chapter2.sort.largestnum;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 测试最大数
 */
public class LargestNumberDemo {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        int[] array = {3, 30, 34, 5, 9};
        System.out.println(largestNumber.create(array));
    }
}
