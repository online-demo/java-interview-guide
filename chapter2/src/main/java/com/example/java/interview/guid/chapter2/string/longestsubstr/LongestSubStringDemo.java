package com.example.java.interview.guid.chapter2.string.longestsubstr;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/1 10:11
 * @Version : V1.0
 * @Description : 测试无重复字符的最长子串
 */
public class LongestSubStringDemo {
    public static void main(String[] args) {
        LongestSubString longestSubString = new LongestSubString();
        String content1 = "abcabcbb";
        System.out.print(content1 +"无重复字符的最长子串=");
        System.out.println(longestSubString.lengthOfLongestSubString(content1));
        String content2 = "bbbbb";
        System.out.print(content2 +"无重复字符的最长子串=");
        System.out.println(longestSubString.lengthOfLongestSubString(content2));
        String content3 = "pwwkew";
        System.out.print(content3 +"无重复字符的最长子串=");
        System.out.println(longestSubString.lengthOfLongestSubString(content3));
    }
}
