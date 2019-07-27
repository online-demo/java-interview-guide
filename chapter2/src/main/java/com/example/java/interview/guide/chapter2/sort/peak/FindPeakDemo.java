package com.example.java.interview.guide.chapter2.sort.peak;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/26 11:10
 * @Version : V1.0
 * @Description : 测试寻找峰值
 */
public class FindPeakDemo {
    public static void main(String[] args) {
        FindPeak findPeak = new FindPeak();
        int[] array1 = {1, 2, 3, 1};
        System.out.printf("数组{1, 2, 3, 1}的峰值元素位置：%d%n",
                findPeak.findPeakElementIndex(array1));
        int[] array2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.printf("数组{1, 2, 1, 3, 5, 6, 4}的峰值元素位置：%d%n",
                findPeak.findPeakElementIndex(array2));
    }
}
