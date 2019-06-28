package com.example.java.interview.guid.chapter2.string.split;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/25 21:15
 * @Version : V1.0
 * @Description : 单词拆分
 */
public class WordSplit {
    /**
     * 判断content是否可以被拆分为一个或多个在字典中出现的单词
     *
     * @param content       待拆分字符串
     * @return              返回结果
     */
    public boolean splitToWordDictionary(String content, Set<String> wordDictionary) {
        boolean[] dp = new boolean[content.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= content.length(); i++) {
            for (int j = i - 1; j >= 0 && !dp[i]; j--) {
                // 截取从j到i的子串
                String subString = content.substring(j, i);
                dp[i] = dp[j] && wordDictionary.contains(subString);
            }
        }
        return dp[content.length()];
    }

    public static void main(String[] args) {
        String content1 = "leetcode";
        Set<String> set1 = new HashSet<>();
        set1.add("leet");
        set1.add("code");
        WordSplit wordSplit = new WordSplit();
        System.out.printf("测试%s，字典=%s，结果=", content1, set1);
        System.out.println(wordSplit.splitToWordDictionary(content1, set1));
        String content2 = "applepenapple";
        Set<String> set2 = new HashSet<>();
        set2.add("apple");
        set2.add("pen");
        set2.add("apple");
        System.out.printf("测试%s，字典=%s，结果=", content2, set2);
        System.out.println(wordSplit.splitToWordDictionary(content2, set2));
        String content3 = "catsandog";
        Set<String> set3 = new HashSet<>();
        set3.add("cats");
        set3.add("dog");
        set3.add("sand");
        set3.add("and");
        set3.add("cat");
        System.out.printf("测试%s，字典=%s，结果=", content3, set3);
        System.out.println(wordSplit.splitToWordDictionary(content3, set3));
    }
}
