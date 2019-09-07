package com.example.java.interview.guide.chapter3.string.substr;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/2 18:25
 * @Version : V1.0
 * @Description : 串联所有单词的子串
 */
public class AllWordsSubString {
    /**
     * 查找串联所有单词的子串
     *
     * @param content 字符串
     * @param words   单词数组
     * @return 子串的位置
     */
    public List<Integer> findSubstring(String content, String[] words) {
        // 字符串非空校验
        if (content == null || content.length() == 0) {
            return Collections.emptyList();
        }
        // 单词数组校验
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }
        // 结果集
        List<Integer> resultList = new ArrayList<>();
        // 单词长度
        int size = words[0].length();
        // 单词数组长度
        int length = words.length;
        // 创建单词Map
        Map<String, Integer> wordsMap = createMap(words);
        // 窗口的不同的初始起点，有size个不同的初始起点
        for (int i = 0; i < size; i++) {
            // 滑动窗口出现的单词次数
            Map<String, Integer> windowWordsMap = new HashMap<>(8);
            // 窗口的左边界
            int left = i;
            // 窗口的右边界
            int right = i;
            // 窗口右侧剩余字符长度不足一个单词的长度 && 剩余子串不足所有单词的总长度  退出循环
            while (right <= content.length() - size && left <= content.length() - length * size) {
                // 截取size长度的字符串
                String word = content.substring(right, right + size);
                // 统计截取的单词出现的次数
                increase(windowWordsMap, word);
                // 截取的字符串不存在于Map中，即不能匹配单词数组中的任何单词
                if (!wordsMap.containsKey(word)) {
                    // 出现不包含的单词，清除之前的结果，重新对单词进行统计
                    windowWordsMap.clear();
                    // 窗口滑动
                    right += size;
                    left = right;
                    continue;
                }
                // 窗口内单词出现的次数 > 单词数组中的次数   不满足条件
                while (windowWordsMap.get(word) > wordsMap.get(word)) {
                    // 窗口左边界向右移动
                    String removeWord = content.substring(left, left + size);
                    // 减少单词出现的次数
                    decrease(windowWordsMap, removeWord);
                    // 窗口向右收缩
                    left += size;
                }
                // 窗口向右膨胀
                right += size;
                // 窗口内的字符长度 = 单词数组中所有单词的总和
                if (right - left == length * size) {
                    resultList.add(left);
                }
            }
        }
        return resultList;
    }

    /**
     * 减少单词的次数
     *
     * @param wordsMap 单词次数Map
     * @param word     单词
     */
    private void decrease(Map<String, Integer> wordsMap, String word) {
        if (wordsMap.containsKey(word)) {
            int count = wordsMap.get(word);
            if (count <= 1) {
                wordsMap.remove(word);
            } else {
                wordsMap.put(word, count - 1);
            }
        }
    }

    /**
     * 单词和出现的次数Map
     *
     * @param words 单词数组
     * @return 单词出现的次数Map
     */
    private Map<String, Integer> createMap(String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>(16);
        for (String string : words) {
            increase(wordsMap, string);
        }
        return wordsMap;
    }

    /**
     * 增加单词的次数
     *
     * @param wordsMap 单词次数Map
     * @param word     单词
     */
    private void increase(Map<String, Integer> wordsMap, String word) {
        // 返回key对应的value，如果key不存在则返回默认值
        int count = wordsMap.getOrDefault(word, 0);
        // 增加单词的次数
        wordsMap.put(word, count + 1);
    }
}
