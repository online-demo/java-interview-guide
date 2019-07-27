package com.example.java.interview.guide.chapter2.sort.couting;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/24 11:20
 * @Version : V1.0
 * @Description : 测试计数排序
 */
public class CountingSortDemo {
    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        countingSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
