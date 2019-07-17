package com.example.java.interview.guide.chapter2.sort.bubble;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 测试冒泡排序
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
