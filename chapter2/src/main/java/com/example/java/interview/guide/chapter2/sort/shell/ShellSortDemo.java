package com.example.java.interview.guide.chapter2.sort.shell;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/19
 * @Version : V1.0
 * @Description : 测试希尔排序
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        shellSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
