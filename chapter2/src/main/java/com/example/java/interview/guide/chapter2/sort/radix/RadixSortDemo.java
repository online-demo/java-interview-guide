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
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26,
                27, 2, 46, 4, 19, 50, 48};
        radixSort.sort(array);
        System.out.println("{3, 44, 38, 5, 47, 15, 36, 26," +
                " 27, 2, 46, 4, 19, 50, 48}");
        System.out.println("进行基数排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
