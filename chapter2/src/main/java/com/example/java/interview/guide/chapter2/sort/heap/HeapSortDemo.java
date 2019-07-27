package com.example.java.interview.guide.chapter2.sort.heap;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/23 20:07
 * @Version : V1.0
 * @Description : 测试堆排序
 */
public class HeapSortDemo {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        heapSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
