package com.example.interview.guide.chapter3.sort.selection;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/18
 * @Version : V1.0
 * @Description : 选择排序
 */
public class SelectionSort {
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
        // 表示调整的次数  一共需要 source.length - 1次
        for (int i = 0; i < source.length - 1; i++) {
            // 最小值的索引位置
            int minIndex = i;
            // 遍历 j 到 source.length 的无序区间
            for (int j = i; j < source.length; j++) {
                // source[j] < source[minIndex]
                // 说明存在比minIndex位置更小的元素
                if (source[j] < source[minIndex]) {
                    // 修改最小值索引位置
                    minIndex = j;
                }
            }
            // 两个数交换位置
            int temp = source[minIndex];
            source[minIndex] = source[i];
            source[i] = temp;
        }
    }
}
