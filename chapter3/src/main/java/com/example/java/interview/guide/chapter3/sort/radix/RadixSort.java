package com.example.java.interview.guide.chapter3.sort.radix;

import java.util.ArrayList;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/25 11:22
 * @Version : V1.0
 * @Description : 基数排序
 */
public class RadixSort {
    /**
     * 以十进制数为例做基数排序
     */
    int decimal = 10;

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
        int max = source[0];
        for (int i = 1; i < source.length; i++) {
            // 最大数
            if (source[i] > max) {
                max = source[i];
            }
        }
        // 最大数的位数(如100是3位数)
        int digits = 0;
        while (max != 0) {
            max /= 10;
            // 最大数的位数累加
            digits++;
        }
        // 取模数，用于计算数字每个位数上的数字
        int mod = 10;
        int div = 1;
        // 槽位  每个槽位是一个list
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        // 槽位初始化
        for (int i = 0; i < decimal; i++) {
            bucket.add(new ArrayList<>());
        }
        // 操作每一位数（从低位向高位即从个位数向十位数向百位数···）
        for (int i = 0; i < digits; i++, mod *= decimal, div *= decimal) {
            // 每一位进行排序
            for (int j = 0; j < source.length; j++) {
                // 计算槽位
                int num = (source[j] % mod) / div;
                // 数值添加到对应槽位的list中
                bucket.get(num).add(source[j]);
            }
            int index = 0;
            // 遍历每个槽位
            for (int k = 0; k < bucket.size(); k++) {
                // 遍历每个槽位上list中的元素
                for (int m = 0; m < bucket.get(k).size(); m++) {
                    // 调整原数组的顺序
                    source[index++] = bucket.get(k).get(m);
                }
                // 槽位上的list清空，为下一次高位数字排序做准备
                bucket.get(k).clear();
            }
        }
    }
}
