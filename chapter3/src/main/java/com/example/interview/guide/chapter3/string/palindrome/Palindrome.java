package com.example.interview.guide.chapter3.string.palindrome;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/25 21:15
 * @Version : V1.0
 * @Description : 回文字符串判断
 */
public class Palindrome {
    /**
     * 判断是否是回文字符串，忽略字母数字外的其他字符
     *
     * @param str 待验证的字符串
     * @return 验证结果
     */
    public boolean isPalindrome(String str) {
        // 非空判断
        if (str == null || "".equals(str)) {
            // 把null和空字符串当做非回文字符串
            return false;
        }
        // 从头向尾的指针
        int startIndex = 0;
        // 从尾向头的指针
        int endIndex = str.length() - 1;
        // 循环退出的条件：startIndex >= endIndex
        while (startIndex < endIndex) {
            // 获取字符串startIndex位置上的字符并转成小写字母
            char front = Character.toLowerCase(str.charAt(startIndex));
            // 不是字母或者数字，查找后一个字符
            if (!Character.isLetterOrDigit(front)) {
                // 指针向后移动一位
                startIndex++;
                continue;
            }
            // 获取字符串endIndex位置上的字符并转成小写字母
            char back = Character.toLowerCase(str.charAt(endIndex));
            // 不是字母或者数字，查找前一个字符
            if (!Character.isLetterOrDigit(back)) {
                // 指针向前移动一位
                endIndex--;
                continue;
            }
            // 前后两个字符不等
            if (front != back) {
                // 不是回文字符串
                return false;
            }
            // startIndex向后移动，继续向后遍历
            startIndex++;
            // endIndex向前移动，继续向前遍历
            endIndex--;
        }
        // 是回文字符串
        return true;
    }
}
