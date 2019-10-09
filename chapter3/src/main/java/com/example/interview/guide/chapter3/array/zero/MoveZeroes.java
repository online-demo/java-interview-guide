package com.example.interview.guide.chapter3.array.zero;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/5 16:11
 * @Version : V1.0
 * @Description : 移动零
 */
public class MoveZeroes {
    /**
     * 移动零
     *
     * @param array 原数组
     */
    public void move(int[] array) {
        // 非空校验
        if (array == null || array.length == 0) {
            return;
        }
        // 非零索引
        int nullZero = 0;
        for (int i = 0; i < array.length; i++) {
            // array[i]不等于0
            if (array[i] != 0) {
                array[nullZero++] = array[i];
            }
        }
        // nullZero以后的元素都等于0
        while (nullZero < array.length) {
            array[nullZero++] = 0;
        }
    }
}
