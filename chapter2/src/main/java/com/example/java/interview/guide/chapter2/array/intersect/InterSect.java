package com.example.java.interview.guide.chapter2.array.intersect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/11
 * @Version : V1.0
 * @Description : 两个数组的交集
 */
public class InterSect {

    /**
     * 两个数组的交集实现1
     *
     * @param array1        数组1
     * @param array2        数组2
     * @return              交集
     */
    public List<Integer> intersect1(int[] array1, int[] array2) {
        if (array1 == null || array1.length == 0 || array2 == null || array2.length == 0) {
            return null;
        }
        // 每个数字出现的次数计数器
        Map<Integer, Integer> counter = new HashMap<>(16);
        // 统计数组1
        for (int i = 0; i < array1.length; i++) {
            int num = array1[1];
            // 数字已经出现过 次数加1
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                // 数字未出现过 次数 = 1
                counter.put(num, 1);
            }
        }
        // 交集
        List<Integer> result = new ArrayList<>();
        // 遍历数组2
        for (int i = 0; i < array2.length; i++) {
            int num = array2[i];
            // 存在于计数器中
            if (counter.containsKey(num) && counter.get(num) > 0) {
                // 计数器减1
                counter.put(num, counter.get(num) - 1);
                // 添加到交集
                result.add(num);
            }
        }
        return result;
    }

    /**
     * 两个数组的交集实现2
     *  两个数组都有序
     *
     * @param array1        数组1
     * @param array2        数组2
     * @return              交集
     */
    public List<Integer> intersect2(int[] array1, int[] array2) {
        int cursor1 = 0;
        int cursor2 = 0;
        // 交集
        List<Integer> result = new ArrayList<>();
        while (cursor1 < array1.length && cursor2 < array2.length) {
            int num1 = array1[cursor1];
            int num2 = array2[cursor2];
            if (num1 == num2) {
                result.add(num1);
                cursor1++;
                cursor2++;
            } else if (num1 < num2) {
                cursor1++;
            } else {
                cursor2++;
            }
        }
        return result;
    }
}
