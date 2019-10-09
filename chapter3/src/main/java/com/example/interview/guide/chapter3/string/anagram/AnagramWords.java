package com.example.interview.guide.chapter3.string.anagram;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/30 12:01
 * @Version : V1.0
 * @Description : 有效的字母异位词
 */
public class AnagramWords {
    /**
     * 判断两个字符串是否是异位词
     *
     * @param base 基础字符串
     * @param test 比较的字符串
     * @return 比较结果
     */
    public boolean isAnagram(String base, String test) {
        // 非空校验
        if (base == null || base.length() == 0) {
            return false;
        }
        // 非空校验
        if (test == null || test.length() == 0) {
            return false;
        }
        // 字符串长度不等，返回false
        if (base.length() != test.length()) {
            return false;
        }
        // 统计base字符串的每个字符的频率
        Map<Character, Integer> baseMap = calculateFrequency(base);
        // 统计test字符串的每个字符的频率
        Map<Character, Integer> testMap = calculateFrequency(test);
        // 对比baseMap与testMap是否相等
        return baseMap.equals(testMap);
    }

    /**
     * 统计字符串中每个字符出现的频率
     *
     * @param base 待统计的字符串
     * @return 每个字符的频率
     */
    private Map<Character, Integer> calculateFrequency(String base) {
        // 记录字符串字符频率
        Map<Character, Integer> frequencyMap = new HashMap<>(16);
        // 遍历字符串的每个字符
        for (int i = 0; i < base.length(); i++) {
            // 第i个位置上的字符
            Character character = base.charAt(i);
            // 字符的频率
            Integer frequency = frequencyMap.get(character);
            // 当前字符已经统计过，累计一次
            if (frequency != null && frequency > 0) {
                // 字符频率加1
                frequencyMap.put(character, frequency + 1);
            } else {
                // 当前字符未统计过，增加频率为1
                frequencyMap.put(character, 1);
            }
        }
        // 返回每个字符的频率
        return frequencyMap;
    }
}
