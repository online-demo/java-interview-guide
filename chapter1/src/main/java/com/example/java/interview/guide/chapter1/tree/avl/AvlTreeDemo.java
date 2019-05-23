package com.example.java.interview.guide.chapter1.tree.avl;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-06 20:47
 * @Version : V1.0
 * @Description :   AVL树测试
 */
public class AvlTreeDemo {
    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        int array[] = { 3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9 };
        for (int i = 0; i < array.length; i++) {
            // 添加元素到AVL树
            avlTree.insert(array[i]);
        }
        print(avlTree);
        System.out.println();
        System.out.println("--------在AVL树查找元素12--------");
        System.out.println(avlTree.search(12));
        System.out.println("--------在AVL树查找元素20--------");
        System.out.println(avlTree.search(20));
        avlTree.remove(12);
        print(avlTree);
    }
    public static void print(AvlTree avlTree) {
        System.out.println("----------中序遍历AVL树----------");
        avlTree.inOrder();
        System.out.println();
        System.out.println("----------先序遍历AVL树----------");
        avlTree.preOrder();
        System.out.println();
        System.out.println("----------后序遍历AVL树----------");
        avlTree.postOrder();
    }
}
