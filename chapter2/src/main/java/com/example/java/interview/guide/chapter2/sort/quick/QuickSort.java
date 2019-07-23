package com.example.java.interview.guide.chapter2.sort.quick;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/23 16:54
 * @Version : V1.0
 * @Description : 快速排序
 */
public class QuickSort {
    /**
     * 排序方法
     *
     * @param source 原数组
     */
    public void sort(int[] source) {
        // 数组非空校验
        if (source == null || source.length < 2) {
            return;
        }
        quickSort(source, 0, source.length - 1);
    }

    /**
     * 快速排序算法实现
     *
     * @param array 数组
     * @param start 排序的起点
     * @param end   排序的终点
     */
    void quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end > array.length || start > end) {
            return;
        }
        if (start < end) {
            int left = start;
            int right = end;
            // 基准数
            int pivot = array[start];
            while (left < right) {
                // 从右向左找,right指向的位置 > pivot，则right左移
                // 当出现array[right] < pivot时，退出循环
                while (left < right && array[right] >= pivot) {
                    // 右指针向左移动
                    right--;
                }
                if (left < right) {
                    // 入坑
                    array[left++] = array[right];
                }
                // 从左向右找,left指向的位置 < pivot，则left左移
                // 当出现array[left] > pivot时，退出循环
                while (left < right && array[left] < pivot) {
                    // 左指针向右移动
                    left++;
                }
                if (left < right) {
                    // 入坑
                    array[right--] = array[left];
                }
            }
            if (left == right) {
                // 调整基准数的位置
                // 调整后，基准数左边的数都小于基准数，基准数右边的数都大于基准数
                array[left] = pivot;
            }
            // 递归基准数左边的数组
            quickSort(array, start, left - 1);
            // 递归基准数右边的数组
            quickSort(array, left + 1, end);
        }
    }
}
