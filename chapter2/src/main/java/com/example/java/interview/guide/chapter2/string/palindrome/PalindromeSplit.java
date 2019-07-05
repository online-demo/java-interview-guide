package com.example.java.interview.guide.chapter2.string.palindrome;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/26 14:44
 * @Version : V1.0
 * @Description : 分割回文串
 */
public class PalindromeSplit {
    /**
     * 原字符串
     */
    private String content;

    /**
     * 构造器
     *
     * @param content   原字符串
     */
    public PalindromeSplit(String content) {
        this.content = content;
    }
    /**
     * 结果
     */
    List<List<String>> result = new ArrayList<>();

    /**
     * 分割回文
     *
     * @return      返回结果
     */
    public List<List<String>> split() {
        search(0, new ArrayList<>());
        return result;
    }

    /**
     * 从某个位置搜索回文
     *
     * @param index     位置
     * @param list      回文
     */
    private void search(int index, List<String> list){
        // 递归出口
        if(index == content.length()){
            // 到达递归出口，保存此次结果
            List<String> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        // 从index位置向后查找回文
        for(int i = index; i < content.length(); i++){
            // 截取部分字符串
            String substring = content.substring(index, i + 1);
            // 判断回文
            Palindrome palindrome = new Palindrome();
            // 是回文
            if(palindrome.isPalindrome(substring)){
                // 保存回文
                list.add(substring);
                // 向后递归
                search(i + 1, list);
                // 递归出口返回后，删除list中的数据，供下一次外层循环保存回文
                list.remove(list.size() - 1);
            }
        }
    }
}
