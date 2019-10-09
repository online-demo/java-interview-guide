package com.example.interview.guide.chapter3.array.maxmultisubseq;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/4 16:39
 * @Version : V1.0
 * @Description : 测试乘积最大连续子序列
 */
public class MaxMultiSubSeqDemo {
    public static void main(String[] args) {
        MaxMultiSubSeq maxMultiSubSeq = new MaxMultiSubSeq();
        int[] array1 = {2, -5, 2, -4};
        System.out.print("数组{2, -5, 2, -4}乘积最大连续子序列=");
        System.out.println(maxMultiSubSeq.maxSubSqe(array1));
        int[] array2 = {-2, 0, -1};
        System.out.print("数组{-2, 0, -1}乘积最大连续子序列=");
        System.out.println(maxMultiSubSeq.maxSubSqe(array2));
    }
}
