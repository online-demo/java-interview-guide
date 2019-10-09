package com.example.interview.guide.chapter3.tree.huffman;

import java.util.Collections;
import java.util.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-23 16:11
 * @Version : V1.0
 * @Description :  哈夫曼树实现
 */
public class HuffmanTree {
    /**
     * 根结点
     */
    public Node root;

    /**
     * 创建Node结点
     *
     * @param weight 权重
     * @return 结点
     */
    public Node createNode(int weight) {
        return new Node(weight);
    }

    /**
     * 创建哈夫曼树
     *
     * @param nodeList 结点集合
     */
    public void createHuffmanTree(List<Node> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) {
            return;
        }
        while (nodeList.size() > 1) {
            Collections.sort(nodeList);
            Node left = nodeList.get(nodeList.size() - 1);
            Node right = nodeList.get(nodeList.size() - 2);
            Node parent = new Node(left.weight + right.weight, left, right, null);
            parent.left = left;
            parent.right = right;
            nodeList.remove(left);
            nodeList.remove(right);
            nodeList.add(parent);
        }
        root = nodeList.get(0);
    }

    /**
     * 中序遍历
     *
     * @param parent 父结点
     */
    public void inOrder(Node parent) {
        if (parent != null) {
            inOrder(parent.left);
            System.out.print(parent.weight + " ");
            inOrder(parent.right);
        }
    }

    /**
     * 哈夫曼编码
     *
     * @param parent 结点
     * @param code   编码
     */
    public void huffmanEncode(Node parent, String code) {
        // 叶子结点
        if (parent != null && parent.left == null && parent.right == null) {
            System.out.println(parent.weight + "被编码成" + code);
        }

        if (parent != null && parent.left != null) {
            // 左子树，编码code添加0
            code += "0";
            huffmanEncode(parent.left, code);
            // 删除上一步添加的'0'
            code = code.substring(0, code.length() - 1);
        }

        if (parent != null && parent.right != null) {
            // 右子树，编码code添加1
            code += "1";
            huffmanEncode(parent.right, code);
            // 删除上一步添加的'1'
            code = code.substring(0, code.length() - 1);
        }
    }

    /**
     * 哈夫曼树结点
     */
    public class Node implements Comparable {
        /**
         * 结点的权重
         */
        public int weight;
        /**
         * 左孩子
         */
        public Node left;
        /**
         * 右孩子
         */
        public Node right;
        /**
         * 父结点
         */
        public Node parent;

        /**
         * 构造器
         *
         * @param weight
         */
        public Node(int weight) {
            this(weight, null, null, null);
        }

        /**
         * 构造器
         *
         * @param weight
         * @param left
         * @param right
         * @param parent
         */
        public Node(int weight, Node left, Node right, Node parent) {
            this.weight = weight;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Node) {
                return ((Node) o).weight - this.weight;
            }
            return 0;
        }
    }
}
