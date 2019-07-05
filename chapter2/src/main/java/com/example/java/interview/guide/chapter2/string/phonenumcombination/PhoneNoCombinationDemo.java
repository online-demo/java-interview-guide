package com.example.java.interview.guide.chapter2.string.phonenumcombination;

import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/2 16:12
 * @Version : V1.0
 * @Description : 测试电话号码的字母组合
 */
public class PhoneNoCombinationDemo {
    public static void main(String[] args) {
        PhoneNoCombination phoneNoCombination = new PhoneNoCombination();
        String phoneNo = "23";
        List<String> result = phoneNoCombination.letterCombinations(phoneNo);
        System.out.printf("电话号码%s的字母组合是：%n", phoneNo);
        System.out.println(result);
    }
}
