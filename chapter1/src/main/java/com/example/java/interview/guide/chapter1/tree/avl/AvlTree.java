package com.example.java.interview.guide.chapter1.tree.avl;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-05 20:33
 * @Version : V1.0
 * @Description :   AVL树实现
 */
public class AvlTree {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 内部类
     */
    public class Node {
        /**
         * 节点元素值
         */
        private int key;
        /**
         * 高度
         */
        private int height;
        /**
         * 左子节点
         */
        private Node left;
        /**
         * 右子节点
         */
        private Node right;

        /**
         * 内部类构造器
         *
         * @param key       元素值
         * @param left      左子节点
         * @param right     右子节点
         */
        Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /**
     * AVL树构造器
     */
    public AvlTree() {

    }

    /**
     * 添加key到AVL树
     *
     * @param key
     */
    public void insert(int key) {
        root = insert(root, key);
    }

    /**
     * 将结点插入到AVL树中，并返回根节点
     *
     * @param key       元素值
     * @return          插入结果
     */
    private Node insert(Node root, int key) {
        // 创建节点
        if (root == null) {
            root = new Node(key, null, null);
        } else if (key < root.key) {
            // 插入左子树
            root.left = insert(root.left, key);
            // 二叉树失衡
            if (height(root.left) - height(root.right) == 2) {
                // 进行LL旋转
                if (key < root.left.key) {
                    root = leftLeftRotate(root);
                } else {
                    // 进行LR旋转
                    root = leftRightRotate(root);
                }
            }
        } else if (key > root.key) {
            // 插入右子树
            root.right = insert(root.right, key);
            // 二叉树失衡
            if (height(root.right) - height(root.left) == 2) {
                if (key > root.right.key) {
                    // 进行RR旋转
                    root = rightRightRotate(root);
                } else {
                    // 进行RL旋转
                    root = rightLeftRotate(root);
                }
            }
        }
        root.height = max(height(root.left), height(root.right)) + 1;
        return root;
    }

    /**
     * LL旋转(右旋)
     *
     * @param root    失衡AVL树根节点
     * @return        调整后的AVL树根节点
     */
    private Node leftLeftRotate(Node root) {
        // 失衡AVL树根节点的左子节点——也是调整后的AVL树的根节点
        Node leftChild = root.left;
        // 失衡AVL树根节点的左子节点 = 失衡AVL树根节点的左子节点的右子节点
        root.left = leftChild.right;
        // 失衡AVL树根节点的左子节点的右节点 = 原AVL树的根节点
        leftChild.right = root;
        // 调整leftChild的高度 = max(左子树的高度，右子树的高度) + 1
        leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;
        // 调整root的高度 = max(左子树的高度，右子树的高度) + 1
        root.height = max(height(root.left), height(root.right)) + 1;
        return leftChild;
    }

    /**
     * RR旋转(左旋)
     *
     * @param root    失衡AVL树根节点
     * @return        调整后的AVL树根节点
     */
    private Node rightRightRotate(Node root) {
        // 失衡AVL树根节点的右子节点——也是调整后的AVL树的根节点
        Node rightChild = root.right;
        // 失衡AVL树根节点的右子节点 = 失衡AVL树根节点的右子节点的左子节点
        root.right = rightChild.left;
        // 失衡AVL树根节点的右子节点的左节点 = 原AVL树的根节点
        rightChild.left = root;
        // 调整leftChild的高度 = max(左子树的高度，右子树的高度) + 1
        rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;
        // 调整root的高度 = max(左子树的高度，右子树的高度) + 1
        root.height = max(height(root.left), height(root.right)) + 1;
        return rightChild;
    }

    /**
     * LR旋转(左右旋)
     *
     * @param root    失衡AVL树根节点
     * @return        调整后的AVL树根节点
     */
    private Node leftRightRotate(Node root) {
        // 对左子树进行RR旋转
        root.left = rightRightRotate(root.left);
        // 对失衡AVL树最低失衡根结点进行LL旋转
        return leftLeftRotate(root);
    }

    /**
     * RL旋转(右左旋)
     *
     * @param root    失衡AVL树根节点
     * @return        调整后的AVL树根节点
     */
    private Node rightLeftRotate(Node root) {
        // 对左子树进行LL旋转
        root.right = leftLeftRotate(root.right);
        // 对失衡AVL树最低失衡根结点进行RR旋转
        return rightRightRotate(root);
    }

    /**
     * 比较两个子树的最大高度
     *
     * @param a     子树a的高度
     * @param b     子树b的高度
     * @return      子树a和子树b的最大高度
     */
    private int max (int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 获取树的高度
     *
     * @param node      节点
     * @return          树高
     */
    private int height(Node node) {
        if (node != null) {
            return node.height;
        }
        return 0;
    }

    /**
     * 先序遍历AVL树
     */
    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * 先序遍历AVL树
     *
     * @param parent    父节点
     */
    private void preOrder(Node parent) {
        if (parent != null) {
            System.out.print(parent.key + " ");
            preOrder(parent.left);
            preOrder(parent.right);
        }
    }

    /**
     * 中序遍历AVL树
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历AVL树
     *
     * @param parent    父节点
     */
    private void inOrder(Node parent) {
        if (parent != null) {
            inOrder(parent.left);
            System.out.print(parent.key + " ");
            inOrder(parent.right);
        }
    }

    /**
     * 后序遍历AVL树
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 后序遍历AVL树
     *
     * @param parent    父节点
     */
    private void postOrder(Node parent) {
        if (parent != null) {
            postOrder(parent.left);
            postOrder(parent.right);
            System.out.print(parent.key + " ");
        }
    }
}
