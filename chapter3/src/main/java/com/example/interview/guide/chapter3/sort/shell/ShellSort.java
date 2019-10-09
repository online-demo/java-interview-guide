package com.example.interview.guide.chapter3.sort.shell;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/19
 * @Version : V1.0
 * @Description : 希尔排序
 */
public class ShellSort {
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
        // 数组长度
        int length = source.length;
        // 增量
        int gap = length / 2;
        while (gap > 0) {
            // 插入排序
            for (int i = gap; i < length; i++) {
                int temp = source[i];
                // 前一个元素的索引位置
                int preIndex = i - gap;
                // 前面的元素 > 当前的元素
                // 插入排序
                while (preIndex >= 0 && source[preIndex] > temp) {
                    source[preIndex + gap] = source[preIndex];
                    preIndex -= gap;
                }
                // 插入元素
                source[preIndex + gap] = temp;
            }
            // 缩小增量
            gap = gap / 2;
        }
    }
}
