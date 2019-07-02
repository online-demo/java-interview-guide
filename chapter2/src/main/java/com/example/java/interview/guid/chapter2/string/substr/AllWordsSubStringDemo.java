package com.example.java.interview.guid.chapter2.string.substr;

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
        String content = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> result = allWordsSubString.findSubstring(content, words);
        System.out.println(result);
    }
}
