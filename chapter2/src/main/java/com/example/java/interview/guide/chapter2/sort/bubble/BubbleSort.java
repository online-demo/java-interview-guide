package com.example.java.interview.guide.chapter2.sort.bubble;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 冒泡排序
 */
public class BubbleSort {
    /**
     * 排序方法
     *
     * @param source 原数组
     */
    public void sort(int[] source) {
        // 数组非空校验
        if (source == null || source.length == 0) {
            return;
        }
        // 表示调整的次数  一共需要 source.length - 1次
        for (int i = 0; i < source.length - 1; i++) {
            for (int j = 0; j < source.length - 1 - i; j++) {
                // 前一个数 > 后一个数
                if (source[j] > source[j + 1]) {
                    // 两个数交换位置
                    int temp = source[j];
                    source[j] = source[j + 1];
                    source[j + 1] = temp;
                }
            }
        }
    }
}
