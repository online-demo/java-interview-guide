package com.example.interview.guide.chapter3.string.substr;

import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/2 19:50
 * @Version : V1.0
 * @Description : 测试串联所有单词的子串
 */
public class AllWordsSubStringDemo {
    public static void main(String[] args) {
        AllWordsSubString allWordsSubString = new AllWordsSubString();
        String content1 = "barfoothefoobarman";
        String[] words1 = {"foo","bar"};
        List<Integer> result1 = allWordsSubString
                .findSubstring(content1, words1);
        System.out.printf("字符串%s串联所有单词的子串为：", content1);
        System.out.println(result1);
        String content2 = "wordgoodstudentgoodword";
        String[] words2 = {"word","student"};
        List<Integer> result2 = allWordsSubString
                .findSubstring(content2, words2);
        System.out.printf("字符串%s串联所有单词的子串为：", content2);
        System.out.println(result2);
    }
}
