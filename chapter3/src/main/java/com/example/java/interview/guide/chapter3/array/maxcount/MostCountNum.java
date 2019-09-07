package com.example.java.interview.guide.chapter3.array.maxcount;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/4 17:25
 * @Version : V1.0
 * @Description : 求众数
 */
public class MostCountNum {

    /**
     * 求数组的众数
     *
     * @param array 数组
     * @return 众数
     */
    public int majorityNum(int[] array) {
        // 众数
        int result = array[0];
        // 计数器
        int count = 1;
        // 遍历数组array
        for (int i = 1; i < array.length; i++) {
            // 如果count=0，说明众数未出现
            // 重新修改result为当前的元素
            if (count == 0) {
                // result=当前元素
                result = array[i];
            } else {
                // count!=0时
                // 如果result=当前元素
                if (result == array[i]) {
                    // 计数器+1
                    count++;
                } else {
                    // 如果result不等于当前元素
                    // 计数器-1
                    count--;
                }
            }
        }
        // 返回众数
        return result;
    }
}
