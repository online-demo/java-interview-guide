package com.example.java.interview.guide.chapter3.sort.insertion;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/18
 * @Version : V1.0
 * @Description : 测试插入排序
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        insertionSort.sort(array);
        System.out.println("{42, 20, 17, 13, 28, 14, 23, 15}" +
                "\n进行插入排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
