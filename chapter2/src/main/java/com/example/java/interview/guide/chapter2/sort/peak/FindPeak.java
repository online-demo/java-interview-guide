package com.example.java.interview.guide.chapter2.sort.peak;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/26 10:49
 * @Version : V1.0
 * @Description : 寻找峰值
 */
public class FindPeak {
    /**
     * 寻找峰值元素的索引
     *
     * @param array 数组
     * @return 峰值元素的索引
     */
    public int findPeakElementIndex(int[] array) {
        // 数组非空校验和长度校验
        if (array == null || array.length == 0) {
            return -1;
        }
        //数组只有1个元素
        if (array.length == 1) {
            return 0;
        }
        // 数组大小
        int size = array.length;
        // 低位索引位置
        int low = 0;
        // 高位索引位置
        int high = size - 1;
        // 中位索引位置
        int mid;
        // 二分搜索
        while (low <= high) {
            // high和low中间元素索引位置
            mid = (high - low) / 2 + low;
            // 如果array[mid] 大于左右两边的元素，则返回mid
            if (array[mid] > (mid - 1 < 0 ? Integer.MIN_VALUE : array[mid - 1])
                    && array[mid] > (mid + 1 > size - 1 ? Integer.MIN_VALUE : array[mid + 1])) {
                return mid;
                // 如果array[mid]小于左边的数
            } else if (array[mid] < (mid - 1 < 0 ? Integer.MIN_VALUE : array[mid - 1])) {
                // 修改高位索引位置
                high = mid - 1;
            } else {
                // 如果array[mid]小于右边的数
                // 低位索引位置
                low = mid + 1;
            }
        }
        return -1;
    }
}
