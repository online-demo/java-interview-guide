package com.example.java.interview.guide.chapter3.sort.largestnum;

import java.util.Arrays;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/17
 * @Version : V1.0
 * @Description : 最大数
 */
public class LargestNumber {
    /**
     * 字符串0
     */
    private String zero = "0";

    /**
     * 返回最大数
     *
     * @param array 数字数组
     * @return 最大数
     */
    public String create(int[] array) {
        // 数字数组校验
        if (array == null || array.length == 0) {
            return zero;
        }
        String[] stringArray = new String[array.length];
        // 数字数组转为字符串数组
        for (int i = 0; i < stringArray.length; i++) {
            stringArray[i] = String.valueOf(array[i]);
        }
        // 对字符串数组进行排序
        Arrays.sort(stringArray, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (stringArray[0].equals(zero)) {
            return zero;
        }
        StringBuffer stringBuffer = new StringBuffer();
        // 拼接字符串
        for (String string : stringArray) {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}
