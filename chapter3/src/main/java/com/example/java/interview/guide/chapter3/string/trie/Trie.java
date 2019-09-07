package com.example.java.interview.guide.chapter3.string.trie;

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
     * 结点类
     */
    static class Node {
        /**
         * 是否到达单词的末尾
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

    /**
     * 构造器
     */
    public Trie() {
        root = new Node();
    }

    /**
     * 添加单词到前缀树
     *
     * @param word 单词
     */
    public void add(String word) {
        // 单词非空校验
        if (word == null || word.length() == 0) {
            return;
        }
        // 获取根结点
        Node current = root;
        // 遍历单词的每个字符
        for (int i = 0; i < word.length(); i++) {
            // 获取word第i位置上的字符
            char character = word.charAt(i);
            // 当前的结点的子孩子不包含这个字符
            if (!current.children.containsKey(character)) {
                // 如果当前结点中的子结点中不包含当前字符
                // 新建一个子结点，并将这个字符存放到children中
                current.children.put(character, new Node());
            }
            // 指向当前结点的下一个结点
            current = current.children.get(character);
        }
        // 跳出循环后，单词每个字符都已经遍历完
        current.isEnd = true;
    }

    /**
     * 查找word是否已存在前缀树中
     *
     * @param word 待查的单词
     * @return 查询结果
     */
    public boolean search(String word) {
        // 获取根结点
        Node current = root;
        // 遍历单词的每个字符
        for (int i = 0; i < word.length(); i++) {
            // 获取word第i位置上的字符
            char character = word.charAt(i);
            // 当前节点的子节点集合children不包含这个字符
            if (!current.children.containsKey(character)) {
                // word这个单词不存在于前缀树中
                return false;
            }
            // 指向当前结点的下一个结点
            current = current.children.get(character);
        }
        // 是否到达单词的末尾，如果是，则表明单词word存在于前缀树中
        return current.isEnd;
    }
}
