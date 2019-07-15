package com.example.java.interview.guide.chapter2.array.multiply;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/15
 * @Version : V1.0
 * @Description : 除自身以外数组的乘积
 */
public class ExceptSelfProduct {
    /**
     * 返回除自身以外数组的乘积数组
     *
     * @param source 原数组
     * @return 目标数组
     */
    public int[] product(int[] source) {
        // 原数组大小
        int size = source.length;
        // 从左向右的乘积数组
        int[] left = new int[size];
        // 从右向左的乘积数组
        int[] right = new int[size];
        // 结果数组
        int[] result = new int[size];
        // 数组第1个元素为1，方便做乘积
        left[0] = 1;
        right[size - 1] = 1;
        // 遍历原数组
        for (int i = 1; i < size; i++) {
            // left数组赋值
            // left[i] = source[i]左边的元素 * source[i - 1]左边元素的乘积
            left[i] = source[i - 1] * left[i - 1];
            // right数组赋值
            // right[size - i - 1] = source[size]右边的元素 * source[size - i]右边元素的乘积
            right[size - i - 1] = source[size - i] * right[size - i];
        }
        // 结果数组赋值
        for (int i = 0; i < size; i++) {
            // result[i] = 左边元素的乘积 * 右边元素的乘积
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
