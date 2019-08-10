package com.example.java.interview.guide.chapter2.string.split;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/25 22:15
 * @Version : V1.0
 * @Description : 测试单词拆分
 */
public class WordSplitDemo {

    public static void main(String[] args) {
        WordSplit wordSplit = new WordSplit();
        String content1 = "HelloWorld";
        Set<String> set1 = new HashSet<>();
        set1.add("Hello");
        set1.add("World");
        System.out.printf("测试%s，字典=%s，结果=", content1, set1);
        System.out.println(wordSplit
                .splitToWordDictionary(content1, set1));
        String content2 = "JavaInterviewJava";
        Set<String> set2 = new HashSet<>();
        set2.add("Java");
        set2.add("Interview");
        System.out.printf("测试%s，字典=%s，结果=", content2, set2);
        System.out.println(wordSplit
                .splitToWordDictionary(content2, set2));
        String content3 = "catsandog";
        Set<String> set3 = new HashSet<>();
        set3.add("cats");
        set3.add("dog");
        set3.add("sand");
        set3.add("and");
        set3.add("cat");
        System.out.printf("测试%s，字典=%s，结果=", content3, set3);
        System.out.println(wordSplit
                .splitToWordDictionary(content3, set3));
    }
}
