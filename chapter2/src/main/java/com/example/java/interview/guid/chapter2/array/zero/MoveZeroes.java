package com.example.java.interview.guid.chapter2.array.zero;

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
     * @param array     原数组
     */
    public void move(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int nullZero = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[nullZero++] = array[i];
            }
        }
        while (nullZero < array.length) {
            array[nullZero++] = 0;
        }
    }
}
