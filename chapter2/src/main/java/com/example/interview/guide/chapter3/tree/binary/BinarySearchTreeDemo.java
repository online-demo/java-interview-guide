package com.example.interview.guide.chapter3.tree.binary;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-01 14:26
 * @Version : V1.0
 * @Description : 测试二叉排序树
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(6);
        binarySearchTree.put(3);
        binarySearchTree.put(8);
        binarySearchTree.put(10);
        binarySearchTree.put(2);
        binarySearchTree.put(9);
        binarySearchTree.put(5);
        binarySearchTree.put(1);
        binarySearchTree.put(4);
        binarySearchTree.put(7);
        System.out.println("----------二叉排序树中序遍历结果----------");
        binarySearchTree.inOrder(binarySearchTree.getRoot());
        System.out.println();
        System.out.println("----------二叉排序树先序遍历结果----------");
        binarySearchTree.preOrder(binarySearchTree.getRoot());
        System.out.println();
        System.out.println("----------二叉排序树后序遍历结果----------");
        binarySearchTree.postOrder(binarySearchTree.getRoot());
        System.out.println();
        // 删除元素8
        binarySearchTree.remove(8);
        System.out.println("-----二叉排序树删除元素8后中序遍历结果------");
        binarySearchTree.inOrder(binarySearchTree.getRoot());
    }
}
