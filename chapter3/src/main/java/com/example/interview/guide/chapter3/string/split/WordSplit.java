package com.example.interview.guide.chapter3.string.split;

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
     * @param content        待拆分字符串
     * @param wordDictionary 字典
     * @return 返回结果
     */
    public boolean splitToWordDictionary(String content, Set<String> wordDictionary) {
        // 记录content每一段子串是够满足条件
        boolean[] subStringResult = new boolean[content.length() + 1];
        // 初始化subStringResult[0]为true方便下面的计算
        subStringResult[0] = true;
        // i从1向后遍历，直至整个content字符串
        for (int i = 1; i <= content.length(); i++) {
            // 从i向前检测每段字符串是否满足条件
            for (int j = i - 1; j >= 0 && !subStringResult[i]; j--) {
                // 截取从j到i的子串
                String subString = content.substring(j, i);
                // 赋值subStringResult的第i个元素的值
                // subStringResult[i]等于
                // subStringResult[j]的结果 && j~i间的子串是否存在于字典中
                subStringResult[i] = subStringResult[j]
                        && wordDictionary.contains(subString);
            }
        }
        // 返回整个字符串是否满足条件
        return subStringResult[content.length()];
    }

}
