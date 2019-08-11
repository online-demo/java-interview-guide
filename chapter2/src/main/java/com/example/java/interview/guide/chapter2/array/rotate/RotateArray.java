package com.example.java.interview.guide.chapter2.array.rotate;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/5 10:01
 * @Version : V1.0
 * @Description : 旋转数组
 */
public class RotateArray {
    /**
     * 旋转数组
     *
     * @param array    原数组
     * @param position 向右移动position位置
     */
    public void rotate(int[] array, int position) {
        // 参数校验
        if (array == null || array.length == 0 || position == 0) {
            return;
        }
        // 数组长度
        int length = array.length;
        // 移动位置 = 数组长度，等于没有移动数组中的任何元素
        if (position == length) {
            return;
        }
        // 移动的位置 > 数组长度，数组旋转大于一圈，对position取模
        if (position > length) {
            position = position % length;
        }
        // 交换的次数
        int count = 0;
        // 外层循环临时存放元素
        int tempOut;
        // 内层循环临时存放元素
        int tempIn;
        // 外层循环  从数组最后一个元素开始旋转
        out:
        for (int i = length - 1; i > length - 1 - position; i--) {
            // 外层循环临时存放元素
            tempOut = array[i];
            // 内层循环  跟随外层循环移动后的位置进行调整
            in:
            for (int j = (i + position) % length; j <= i;
                 j = (j + position) % length) {
                // 交换内外层循环的元素
                tempIn = array[j];
                array[j] = tempOut;
                tempOut = tempIn;
                // 交换的次数+1
                count++;
                // 交换的次数 = 数组长度，数组全部元素调整完毕
                if (count == length) {
                    // 结束外层循环
                    break out;
                }
                // 内层循环结束
                if (j == i) {
                    break;
                }
            }
        }
    }
}
