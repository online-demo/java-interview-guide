package com.example.java.interview.guide.chapter3.sort.quick;

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
        int[] array = {4, 7, 6, 5, 3, 2, 8, 1};
        quickSort.sort(array);
        System.out.println("{4, 7, 6, 5, 3, 2, 8, 1}");
        System.out.println("进行快速排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
