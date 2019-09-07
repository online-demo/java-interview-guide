package com.example.java.interview.guide.chapter3.sort.quick;

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
        // 数组非空校验和长度校验
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
    private void quickSort(int[] array, int start, int end) {
        // 数组长度校验和起点终点校验
        if (array.length < 1 || start < 0
                || end > array.length || start > end) {
            return;
        }
        if (start < end) {
            // 初始化left指针
            int left = start;
            // 初始化right指针
            int right = end;
            // 选取基准数 pivot为数组第一个元素
            int pivot = array[start];
            while (left < right) {
                // 从右向左找,right指向的位置 > pivot，则right左移
                // 当出现array[right] < pivot时，退出循环
                while (left < right && array[right] >= pivot) {
                    // 右指针向左移动1位
                    right--;
                }
                if (left < right) {
                    // right指针指向的元素入坑
                    // left指针向右移动1位
                    array[left++] = array[right];
                }
                // 从左向右找,left指向的位置 < pivot，则left左移
                // 当出现array[left] > pivot时，退出循环
                while (left < right && array[left] < pivot) {
                    // 左指针向右移动
                    left++;
                }
                if (left < right) {
                    // left指针指向的元素入坑
                    // right指针向左移动1位
                    array[right--] = array[left];
                }
            }
            // 如果left指针与right指针相遇
            if (left == right) {
                // 调整基准数的位置
                // 基准数填入坑后
                // 基准数左边的数都小于基准数
                // 基准数右边的数都大于基准数
                array[left] = pivot;
            }
            // 基准数左边的数组进行递归
            quickSort(array, start, left - 1);
            // 基准数右边的数组进行递归
            quickSort(array, left + 1, end);
        }
    }
}
