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
        int[] array = {91, 60, 96, 13, 35, 65, 46, 65
                , 10, 30, 20, 31, 77, 81, 22};
        heapSort.sort(array);
        System.out.println("{91,60,96,13,35,65,46," +
                "65,10,30,20,31,77,81,22}");
        System.out.println("进行堆排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
