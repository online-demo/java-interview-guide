package com.example.interview.guide.chapter3.sort.couting;


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
        int[] array = {2, 3, 8, 7, 1, 2, 2, 2, 7, 3,
                9, 8, 2, 1, 4, 2, 4, 6, 9, 2};
        countingSort.sort(array);
        System.out.println("进行计数排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
