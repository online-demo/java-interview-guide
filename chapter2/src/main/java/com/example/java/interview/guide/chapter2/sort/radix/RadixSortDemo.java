package com.example.java.interview.guide.chapter2.sort.radix;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/25 14:15
 * @Version : V1.0
 * @Description : 测试基数排序
 */
public class RadixSortDemo {
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        radixSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
