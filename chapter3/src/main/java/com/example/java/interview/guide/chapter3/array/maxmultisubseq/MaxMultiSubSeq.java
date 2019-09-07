package com.example.java.interview.guide.chapter3.array.maxmultisubseq;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/3 10:25
 * @Version : V1.0
 * @Description : 乘积最大连续子序列
 */
public class MaxMultiSubSeq {

    /**
     * 乘积最大连续子序列的乘积
     *
     * @param array 整型数组
     * @return 乘积最大连续子序列的乘积
     */
    public int maxSubSqe(int[] array) {
        /**
         * 最大连续子序列的乘积
         */
        int positiveMax = array[0];
        /**
         * 最小连续子序列的乘积
         */
        int negativeMax = array[0];
        /**
         * 乘积最大值
         */
        int max = array[0];
        // 从第1个位置向后遍历
        for (int i = 1; i < array.length; i++) {
            // 遍历过程中的最大值
            int tempPositiveMax = positiveMax;
            // 遍历过程中的负数最小值
            int tempNegativeMax = negativeMax;
            // 第i个元素与最大值和最小值相乘后的最大值
            int multiMax = Math.max(array[i] * tempPositiveMax,
                    array[i] * tempNegativeMax);
            // 修改最大连续子序列的乘积
            positiveMax = Math.max(array[i], multiMax);
            // 第i个元素与最大值和最小值相乘后的最小值
            int multiMin = Math.min(array[i] * tempPositiveMax,
                    array[i] * tempNegativeMax);
            // 调整最小连续子序列的乘积
            negativeMax = Math.min(array[i], multiMin);
            // 最大连续子序列的乘积和小连续子序列的乘积的最大值 > max
            if (Math.max(positiveMax, negativeMax) > max) {
                // 调整最大值
                max = Math.max(positiveMax, negativeMax);
            }
        }
        // 返回乘积最大值
        return max;
    }

}
