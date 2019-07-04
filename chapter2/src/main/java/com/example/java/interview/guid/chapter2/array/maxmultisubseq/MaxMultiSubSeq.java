package com.example.java.interview.guid.chapter2.array.maxmultisubseq;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/3 10:25
 * @Version : V1.0
 * @Description : 乘积最大子序列
 */
public class MaxMultiSubSeq {


    public int maxSubSqe(int[] nums) {
        /**
         * 最大连续子序列的乘积
         */
        int posmax = nums[0];
        /**
         * 最小连续子序列的乘积
         */
        int negmax = nums[0];
        /**
         * 乘积最大值
         */
        int max = nums[0];
        // 从第1个位置向后遍历
        for (int i = 1; i < nums.length; i++) {
            // 遍历过程中的最大值
            int tempPosMax = posmax;
            // 遍历过程中的负数最小值
            int tempNegMax = negmax;
            // 第i个元素与最大值和最小值相乘后的最大值
            int multiMax = Math.max(nums[i] * tempPosMax, nums[i] * tempNegMax);
            // 修改最大连续子序列的乘积
            posmax = Math.max(nums[i], multiMax);
            // 第i个元素与最大值和最小值相乘后的最小值
            int multiMin = Math.min(nums[i] * tempPosMax, nums[i] * tempNegMax);
            // 调整最小连续子序列的乘积
            negmax = Math.min(nums[i], multiMin);
            // 最大连续子序列的乘积和小连续子序列的乘积的最大值 > max
            if (Math.max(posmax, negmax) > max) {
                // 调整最大值
                max = Math.max(posmax, negmax);
            }
        }
        return max;
    }

}
