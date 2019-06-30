package com.example.java.interview.guid.chapter2.string.anagram;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/30 12:01
 * @Version : V1.0
 * @Description : 测试有效的字母异位词
 */
public class AnagramWordsDemo {
    public static void main(String[] args) {
        String base = "anagram";
        String test = "nagaram";
        AnagramWords anagramWords = new AnagramWords();
        System.out.printf("%s和%s是否是异位词：", base, test);
        System.out.println(anagramWords.isAnagram(base, test));

        String base2 = "rat";
        String test2 = "car";
        System.out.printf("%s和%s是否是异位词：", base2, test2);
        System.out.println(anagramWords.isAnagram(base2, test2));
    }
}
