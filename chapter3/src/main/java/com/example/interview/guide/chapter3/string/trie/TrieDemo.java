package com.example.interview.guide.chapter3.string.trie;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/28 15:52
 * @Version : V1.0
 * @Description : 测试前缀树
 */
public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        // 字典
        String[] dictionary = {"abc", "abd", "b", "abdc"};
        // 将字典中的每个单词加入前缀树中
        for (int i = 0; i < dictionary.length; i++) {
            // 依次加入前缀树
            trie.add(dictionary[i]);
        }
        // 验证前缀树
        System.out.print("abc是否存在于前缀树中：");
        System.out.println(trie.search("abc"));
        System.out.print("abdc是否存在于前缀树中：");
        System.out.println(trie.search("abdc"));
        System.out.print("acdb是否存在于前缀树中：");
        System.out.println(trie.search("acdb"));
    }
}
