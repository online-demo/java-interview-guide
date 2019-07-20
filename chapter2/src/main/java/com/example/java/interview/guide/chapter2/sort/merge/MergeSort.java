package com.example.java.interview.guide.chapter2.sort.merge;

import java.util.Arrays;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/19
 * @Version : V1.0
 * @Description : 归并排序
 */
public class MergeSort {
    /**
     * 排序方法
     *
     * @param source 原数组
     */
    public int[] sort(int[] source) {
        // 数组非空校验
        if (source == null || source.length < 2) {
            return source;
        }
        int middle = source.length / 2;
        int[] left = Arrays.copyOfRange(source, 0, middle);
        int[] right = Arrays.copyOfRange(source, middle, source.length);
        return merge(sort(left), sort(right));
    }

    /**
     * 合并两个有序数组
     *
     * @param left  数组1
     * @param right 数组2
     * @return
     */
    private int[] merge(int[] left, int[] right) {
        // 结果数组
        int[] result = new int[left.length + right.length];
        // index:结果数组索引 i：left数组索引 j：right数组索引
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            // left数组遍历结束
            if (i >= left.length) {
                // right数组依次插入result数组]，j自增
                result[index] = right[j++];
                // right数组遍历结束
            } else if (j >= right.length) {
                // left数组依次插入result数组，i自增
                result[index] = left[i++];
                // left[i] > right[j]
            } else if (left[i] > right[j]) {
                // 优先在result数组插入right[j]，j自增
                result[index] = right[j++];
                // left[i] <= right[j]
            } else {
                // 优先在result数组插入left[i]，i自增
                result[index] = left[i++];
            }
        }
        return result;
    }
}
