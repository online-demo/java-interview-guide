package com.example.java.interview.guide.chapter2.string.palindrome;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/25 21:15
 * @Version : V1.0
 * @Description : 回文判断
 */
public class Palindrome {
    /**
     * 判断是否是回文，忽略字母数字外的其他字符
     *
     * @param str
     * @return
     */
    public boolean isPalindrome(String str) {
        // 非空判断
        if (str == null || "".equals(str)) {
            return false;
        }
        // 从头向尾的指针
        int startIndex = 0;
        // 从尾向头的指针
        int endIndex = str.length() - 1;
        // 循环退出的条件：startIndex < endIndex
        while (startIndex < endIndex) {
            char front = Character.toLowerCase(str.charAt(startIndex));
            // 不是字母或者数字，查找后一个字符
            if (!Character.isLetterOrDigit(front)) {
                startIndex++;
                continue;
            }
            // 不是字母或者数字，查找前一个字符
            char back = Character.toLowerCase(str.charAt(endIndex));
            if (!Character.isLetterOrDigit(back)) {
                endIndex--;
                continue;
            }
            // 前后两个字符不等，不是回文
            if (front != back) {
                return false;
            }
            // 继续向后遍历
            startIndex++;
            // 继续向前遍历
            endIndex--;
        }
        return true;
    }
}
