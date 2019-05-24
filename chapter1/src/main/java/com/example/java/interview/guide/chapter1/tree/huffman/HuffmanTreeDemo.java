package com.example.java.interview.guide.chapter1.tree.huffman;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-24 14:54
 * @Version : V1.0
 * @Description :
 */
public class HuffmanTreeDemo {
    public static void main(String[] args) {
        HuffmanTree huffmanTree = new HuffmanTree();
        int a[] = { 4,3,5,1,2 };
        List<HuffmanTree.Node> nodeList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            nodeList.add(huffmanTree.createNode(a[i]));
        }
        huffmanTree.createHuffmanTree(nodeList);
        System.out.println("----------哈夫树中序遍历----------");
        huffmanTree.inOrder(huffmanTree.root);
        System.out.println();
        System.out.println("----------哈夫曼编码结果----------");
        huffmanTree.huffmanEncode(huffmanTree.root, "");
    }
}
