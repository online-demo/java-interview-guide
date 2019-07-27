package com.example.java.interview.guide.chapter2.sort.quick;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/23 18:34
 * @Version : V1.0
 * @Description : 测试快速排序
 */
public class QuickSortDemo {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        quickSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
