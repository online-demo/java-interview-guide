package com.example.java.interview.guid.chapter2.string.phonenumcombination;

import java.util.*;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/2 15:33
 * @Version : V1.0
 * @Description : 电话号码的字母组合
 */
public class PhoneNoCombination {
    private Map<Integer, List<String>> phoneNoMap = new HashMap<Integer, List<String>>(){
        {
            put(1, Collections.emptyList());
            put(2, Arrays.asList("a", "b", "c"));
            put(3, Arrays.asList("d", "e", "f"));
            put(4, Arrays.asList("g", "h", "i"));
            put(5, Arrays.asList("j", "k", "l"));
            put(6, Arrays.asList("m", "n", "o"));
            put(7, Arrays.asList("p", "q", "r", "s"));
            put(8, Arrays.asList("t", "u", "v"));
            put(9, Arrays.asList("w", "x", "y", "z"));
        }
    };

    /**
     * 可能的字母组合
     *
     * @param phoneNo       电话号码
     * @return              字符串列表
     */
    public List<String> letterCombinations(String phoneNo) {
        if (phoneNo == null || phoneNo.length() == 0) {
            return Collections.emptyList();
        }
        List<String> resultList = new ArrayList<>();
        Integer first = Integer.valueOf(phoneNo.substring(0, 1));
        List<String> characterList = phoneNoMap.get(first);
        // 递归出口
        if (phoneNo.length() == 1) {
            resultList.addAll(characterList);
            return resultList;
        }
        // 剩余子串进行递归
        List<String> leftCharacterList = letterCombinations(phoneNo.substring(1));
        // 拼接字符串
        for (String character : characterList) {
            for (String leftCharacter : leftCharacterList) {
                resultList.add(character + leftCharacter);
            }
        }
        return resultList;
    }
}
