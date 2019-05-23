package com.example.java.interview.guide.chapter1.tree.redblack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-15 16:33
 * @Version : V1.0
 * @Description :   红黑树测试
 */
public class RedBlackTreeDemo {
    public static void main(String[] args) {
        int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
        RedBlackTree redBlackTree = new RedBlackTree();
        for (int i = 0; i < a.length; i++) {
            redBlackTree.insert(a[i]);
        }
        System.out.println("----------红黑树中序遍历结果----------");
        redBlackTree.inOrder();
        redBlackTree.remove(60);
        System.out.println();
        System.out.println("----------红黑树中序遍历结果----------");
        redBlackTree.inOrder();
    }
}
