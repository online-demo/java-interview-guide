package com.example.interview.guide.chapter3.array.triplet;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/12
 * @Version : V1.0
 * @Description : 递增的三元子序列
 */
public class IncreasingTriplet {

    /**
     * 判断是否包含递增的三元子序列
     *
     * @param array     数组
     * @return          结果
     */
    public boolean containsIncreasingTriplet(int[] array) {
        // 数组合法性校验
        if (array == null || array.length == 0) {
            return false;
        }
        // 最大值
        int high = Integer.MAX_VALUE;
        // 最小值
        int low = Integer.MAX_VALUE;
        for (int num : array) {
            // 数字小于当前最小值
            if (num <= low) {
                // 修改最小值
                low = num;
            } else if (num <= high) {
                // 数字 >= 当前的最小值 && 数字 <= 当前的最大值
                // 修改最大值
                high = num;
            } else {
                // 数字大于最大值，说明此时已满三个元素
                // 分别是 low、high 和 num三个元素组成的递增的三元子序列
                return true;
            }
        }
        return false;
    }
}
