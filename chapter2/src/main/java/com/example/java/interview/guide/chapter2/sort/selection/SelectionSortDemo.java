package com.example.java.interview.guide.chapter2.sort.selection;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/18
 * @Version : V1.0
 * @Description : 测试选择排序
 */
public class SelectionSortDemo {
    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        selectionSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
