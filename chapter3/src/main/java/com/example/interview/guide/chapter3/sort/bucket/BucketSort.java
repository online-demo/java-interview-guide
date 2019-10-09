package com.example.interview.guide.chapter3.sort.bucket;

import com.example.interview.guide.chapter3.sort.insertion.InsertionSort;

import java.util.Arrays;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/24 16:22
 * @Version : V1.0
 * @Description : 桶排序
 */
public class BucketSort {
    public void sort(int[] source) {
        // 数组非空校验和长度校验
        if (source == null || source.length < 2) {
            return;
        }
        int bucketSize = 8;
        // 数组的最小值
        int min = source[0];
        // 数组的最大值
        int max = source[0];
        // 遍历数组，寻找数组最大值和最小值
        for (int i = 1; i < source.length; i++) {
            if (source[i] > max) {
                // 调整最大值
                max = source[i];
            }
            if (source[i] < min) {
                // 调整最小值
                min = source[i];
            }
        }
        // 桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        // 映射关系
        int[][] buckets = new int[bucketCount][0];
        // 利用映射函数将数据分配到各个桶中
        for (int j = 0; j < source.length; j++) {
            // 元素放置的桶的位置
            int index = (source[j] - min) / bucketSize;
            // 桶中添加新的元素
            buckets[index] = arrAppend(buckets[index], source[j]);
        }
        // 使用插入排序对每个桶内的元素进行排序
        InsertionSort insertionSort = new InsertionSort();
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            // 桶中没有元素
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行插入排序
            insertionSort.sort(bucket);
            // 每个桶内已经排序的元素，放入source数组中
            for (int value : bucket) {
                source[arrIndex++] = value;
            }
        }
    }
    /**
     * 自动扩容，并保存数据
     *
     * @param array 原数组
     * @param value 新元素
     */
    private int[] arrAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        // 添加新的元素
        array[array.length - 1] = value;
        return array;
    }
}
