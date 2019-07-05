package com.example.java.interview.guide.chapter2.string.trie;

/**
 * @author zhouguanya
 * @version Id: TrieDemo.java, v 0.1  2019/6/28 zhouguanya Exp $$
 */
public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        // 字典
        String[] dictionary = {"abc", "abd", "b", "abdc"};

        for(int i=0;i<dictionary.length;i++) {
            // 依次加入前缀树
            trie.add(dictionary[i]);
        }
        System.out.print("abc是否存在于前缀树中：");
        System.out.println(trie.search("abc"));
        System.out.print("abdc是否存在于前缀树中：");
        System.out.println(trie.search("abdc"));
        System.out.print("acdb是否存在于前缀树中：");
        System.out.println(trie.search("acdb"));
    }
}
