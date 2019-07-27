package com.example.java.interview.guide.chapter2.sort.couting;

import java.util.Arrays;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/24 9:16
 * @Version : V1.0
 * @Description : 计数排序
 */
public class CountingSort {
    public void sort(int[] source) {
        // 数组非空校验
        if (source == null || source.length < 2) {
            return;
        }
        // 数组的最小值
        int min = source[0];
        // 数组的最大值
        int max = source[0];
        // 寻找数组最大值和最小值
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) {
                max = source[i];
            }
            if (source[i] < min) {
                min = source[i];
            }
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        // 偏移量
        int offset = -1 * min;
        for (int i = 0; i < source.length; i++) {
            // 累加数字出现的频率
            bucket[source[i] + offset]++;
        }
        for (int index = 0, i = 0; index < source.length;) {
            // 元素出现的频率 != 0
            if (bucket[i] != 0) {
                source[index] = i - offset;
                // 元素出现的频率减1
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }
    }
}
