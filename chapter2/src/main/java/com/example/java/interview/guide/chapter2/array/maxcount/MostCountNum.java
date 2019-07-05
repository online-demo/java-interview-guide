package com.example.java.interview.guide.chapter2.array.maxcount;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/4 17:25
 * @Version : V1.0
 * @Description : 求众数
 */
public class MostCountNum {

    public int majorityNum(int[] array) {
        // 众数
        int result = array[0];
        // 计数器
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            // count=0，这是result=当前元素
            if (count == 0) {
                result = array[i];
            } else {
                // count!=0，result=当前元素，计数器+1
                if (result == array[i]) {
                    count++;
                } else {
                    // 计数器-1
                    count--;
                }
            }
        }
        return result;
    }
}
