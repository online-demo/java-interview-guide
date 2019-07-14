package com.example.java.interview.guide.chapter2.string.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/6/28 15:31
 * @Version : V1.0
 * @Description : 前缀树
 */
public class Trie {
    /**
     * 结点
     */
    static class Node {
        /**
         * 单词是否遍历完
         */
        boolean isEnd;
        /**
         * 该结点的子结点
         */
        Map<Character, Node> children = new HashMap<>();
    }

    /**
     * 根结点
     */
    private Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * 添加单词到前缀树
     *
     * @param word      单词
     */
    public void add(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            // 获取word第i位置上的字符
            char character = word.charAt(i);
            // 子孩子包含这个字符
            if (!cur.children.containsKey(character)) {
                // 如果当前结点中的子结点中不包含当前字符，新建一个子结点
                cur.children.put(character, new Node());
            }
            // 指向结点的下一个结点
            cur = cur.children.get(character);
        }
        cur.isEnd = true;
    }

    /**
     * 查找word是否已存在前缀树中
     *
     * @param word      待查的单词
     * @return          查询结果
     */
    public boolean search(String word) {
        Node cur = root;
        for(int i = 0 ; i < word.length() ; i++) {
            char character = word.charAt(i);
            if (!cur.children.containsKey(character)) {
                return false;
            }
            cur = cur.children.get(character);
        }
        return cur.isEnd;
    }
}
