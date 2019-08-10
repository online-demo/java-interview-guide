package com.example.java.interview.guide.chapter2.string.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/26 14:44
 * @Version : V1.0
 * @Description : 分割回文字符串
 */
public class PalindromeSplit {
    /**
     * 原字符串
     */
    private String content;

    /**
     * 构造器
     *
     * @param content 原字符串
     */
    public PalindromeSplit(String content) {
        // 初始化原字符串
        this.content = content;
    }

    /**
     * 分割回文字符串的结果
     */
    List<List<String>> result = new ArrayList<>();

    /**
     * 分割回文字符串
     *
     * @return 返回结果
     */
    public List<List<String>> split() {
        // 从某个位置搜索回文字符串
        search(0, new ArrayList<>());
        // 返回分割回文字符串的结果
        return result;
    }

    /**
     * 从某个位置搜索回文字符串
     *
     * @param index 位置
     * @param list  回文字符串
     */
    private void search(int index, List<String> list) {
        // 递归出口
        if (index == content.length()) {
            // 到达递归出口，保存此次结果
            List<String> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        // 从index位置向后查找回文字符串
        for (int i = index; i < content.length(); i++) {
            // 截取部分字符串
            String substring = content.substring(index, i + 1);
            // 使用判断回文字符串的方法用于验证substring是否是回文字符串
            Palindrome palindrome = new Palindrome();
            // 如果substring是回文字符串
            if (palindrome.isPalindrome(substring)) {
                // 保存回文字符串
                list.add(substring);
                // 向后递归
                search(i + 1, list);
                // 递归出口返回后，删除list中的数据
                // 供下一次外层循环保存回文字符串
                list.remove(list.size() - 1);
            }
        }
    }
}
