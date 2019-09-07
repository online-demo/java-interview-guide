package com.example.java.interview.guide.chapter3.string.palindrome;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/25 21:42
 * @Version : V1.0
 * @Description : 回文字符串判断测试
 */
public class PalindromeDemo {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String str1 = "A man, a plan, a canal: Panama";
        String str2 = "Hello World";
        // 验证str1是不是回文
        System.out.println(str1 + "是不是回文字符串？"
                + palindrome.isPalindrome(str1));
        // 验证str2是不是回文
        System.out.println(str2 + "是不是回文字符串？"
                + palindrome.isPalindrome(str2));
    }
}
