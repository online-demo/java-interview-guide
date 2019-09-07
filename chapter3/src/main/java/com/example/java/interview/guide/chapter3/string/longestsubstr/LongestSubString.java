package com.example.java.interview.guide.chapter3.string.longestsubstr;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/30 16:37
 * @Version : V1.0
 * @Description : 无重复字符的最长子串
 */
public class LongestSubString {
    /**
     * 无重复字符的最长子串
     *
     * @param content 待查字符串
     * @return 长度
     */
    public int lengthOfLongestSubString(String content) {
        // 保存第一个不重复的字符的位置
        Map<Character, Integer> characterIndexMap = new HashMap<>(16);
        // 无重复字符的最长子串的长度
        int maxLength = 0;
        // 当前有效的非空子串的起始位置
        int current = 0;
        // 遍历content字符串的内容
        for (int i = 0; i < content.length(); i++) {
            // 第i个位置上的字符
            Character character = content.charAt(i);
            // HashMap存在，说明已经重复
            if (characterIndexMap.containsKey(character)) {
                // 当前有效的非空子串的起始位置后移
                current = Math.max(current, characterIndexMap.get(character) + 1);
                if (i - current + 1 > maxLength) {
                    maxLength = i - current + 1;
                }
            }
            // character不存在与HashMap中
            // 更新最长字串的长度
            if (i - current + 1 > maxLength) {
                maxLength = i - current + 1;
            }
            // 修改当前字符的value，记录最新位置
            characterIndexMap.put(character, i);
        }
        // 返回无重复字符的最长子串的长度
        return maxLength;
    }
}
