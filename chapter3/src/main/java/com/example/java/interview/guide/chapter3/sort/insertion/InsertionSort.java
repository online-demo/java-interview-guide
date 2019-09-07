package com.example.java.interview.guide.chapter3.sort.insertion;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/18
 * @Version : V1.0
 * @Description : 插入排序
 */
public class InsertionSort {
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
        for (int i = 0; i < source.length - 1; i++) {
            // 当前已排序的序列的最后一个元素
            int current = source[i + 1];
            // 前一个元素
            int preIndex = i;
            // 当前元素 < 前一个元素
            while (preIndex >= 0 && current < source[preIndex]) {
                // 前一个元素向后移动
                source[preIndex + 1] = source[preIndex];
                // 向前迭代
                preIndex--;
            }
            // 在空出的位置插入新元素
            source[preIndex + 1] = current;
        }
    }
}
