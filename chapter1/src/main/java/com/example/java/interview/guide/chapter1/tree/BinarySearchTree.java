package com.example.java.interview.guide.chapter1.tree;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-30 11:04
 * @Version : V1.0
 * @Description :   二叉查找树实现
 */
public class BinarySearchTree {
    private class Node {
        /** 保存节点数据 */
        public int data;
        /** 当前节点的左孩子指针 */
        public Node left;
        /** 当前节点的右孩子指针 */
        public Node right;
        /** 当前节点的父节点 */
        public Node parent;

        /**
         * Node构造器
         *
         * @param value     节点值
         */
        public Node(int value){
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }
    /** 二叉查找树根节点 */
    private Node root;
    /**
     * 二叉查找树构造器
     */
    public BinarySearchTree(){
        root = null;
    }

    /**
     * 查找指定的元素
     *
     * @param key   待查找的元素
     * @return      返回待查找的元素
     *              如果不存在则返回其父节点
     */
    public Node find(int key) {
        // 从根节点开始遍历
        Node current = root;
        while (current != null) {
            // 如果查找元素小于当前节点的元素
            // 从当前节点的左子树上搜索指定元素
            if (key < current.data) {
                // 当前节点左孩子为空
                if (current.left == null) {
                    return current;
                }
                current = current.left;
                // 如果查找元素大于当前节点的元素
                // 从当前节点的右子树上搜索指定元素
            } else if (key > current.data) {
                // 当前节点右孩子为空
                if (current.right == null) {
                    return current;
                }
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * 添加元素
     *
     * @param value     待插入的元素
     */
    public void put(int value) {
        Node newNode = new Node(value);
        // 如果当前二叉查找树不存在
        if (root == null) {
            root = newNode;
            return;
        }
        Node parent = find(value);
        // 当前值小于父节点值
        if (value < parent.data) {
            parent.left = newNode;
            parent.left.parent = parent;
            return;
        }
        // 当前元素值大于等于父节点的值
        parent.right = newNode;
        parent.right.parent = parent;
    }

    /**
     * 从二叉查找树上删除指定元素
     *
     * @param value     待删除元素
     * @return          删除结果
     */
    public boolean remove(int value) {
        Node temp = find(value);
        if (temp.data != value) {
            return false;
        }
        // 删除的节点是叶子节点
        if (temp.left == null && temp.right == null) {
            // 如果删除的节点是根节点
            if (temp == root) {
                root = null;
                // 如果删除的节点是父节点的右孩子，将父节点的右孩子置为空
            } else if (temp.parent.data < temp.data) {
                temp.parent.right = null;
            } else {
                // 如果删除的节点是父节点的左孩子，将父节点的左孩子置为空
                temp.parent.left = null;
            }
            return true;
            // 删除的节点有左右两个孩子
        } else if (temp.left != null && temp.right != null) {
            Node successor = findSuccessor(temp);
            // 维护后继节点的左孩子的关系
            successor.left = temp.left;
            successor.left.parent = successor;
            successor.right = temp.right;
            successor.right.parent = successor;
            // 因要把后继节点放在删除的节点位置上，所以需要处理后继节点的子节点
            // 后继节点的有右孩子且后继节点的父节点不是当前删除的节点
            if (successor.right != null && successor.parent != temp) {
                // 后继节点的右孩子的父节点=后继节点的父节点
                successor.right.parent = successor.parent;
                // 后继节点的父节点的左孩子=后继节点的右孩子
                successor.parent.left = successor.right;
                // 后继节点的右孩子=删除节点的右孩子
                successor.right = temp.right;
                // 后继节点的右孩子的父节点=后继节点
                successor.right.parent = successor;
            } else {
                successor.parent.left = null;
            }
            // 如果删除的是根节点
            if (temp == root) {
                // 后继节点的父节点为空
                successor.parent = null;
                // 更新根节点为后继节点
                root = successor;
                return true;
            } else {
                // 后继节点的父节点=删除节点的父节点
                successor.parent = temp.parent;
                // 删除节点的父节点小于删除节点的值：删除的是一个右节点
                if (temp.parent.data < temp.data) {
                    // 删除节点的右节点=后继节点
                    temp.parent.right = successor;
                } else {
                    // 删除节点的左节点=后继节点
                    temp.parent.left = successor;
                }
                return true;
            }
        } else {
            // 删除的节点有一个孩子
            // 删除的节点的右孩子非空
            if (temp.right != null) {
                // 如果删除的是根节点
                if (temp == root) {
                    root = root.right;
                    return true;
                }
                temp.right.parent = temp.parent;
                // 删除的是一个左节点
                if (temp.data < temp.parent.data) {
                    temp.parent.left = temp.right;
                } else {
                    // 删除的是一个右节点
                    temp.parent.right = temp.right;
                }
                return true;
            } else {
                // 删除的节点有一个左孩子
                // 删除的节点是根节点
                if (temp == root) {
                    root = temp.left;
                    return true;
                }
                temp.left.parent = temp.parent;
                // 删除的是一个左节点
                if (temp.data < temp.parent.data) {
                    temp.parent.left = temp.left;
                } else {
                    // 删除的是一个右节点
                    temp.parent.right = temp.left;
                }
                return true;
            }
        }
    }

    /**
     * 查询当前节点的后继节点
     *
     * @param node  当前节点
     * @return      后继节点
     */
    public Node findSuccessor(Node node) {
        if (node.right == null) {
            return node;
        }
        Node current = node.right;
        Node parent = node.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * 获取根节点
     *
     * @return  根节点
     */
    public Node getRoot() {
        return root;
    }

    /**
     * 中序遍历
     * 左孩子---->父节点---->右孩子
     *
     * @param node  起始节点
     */
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    /**
     * 先序遍历
     * 父节点---->左孩子---->右孩子
     *
     * @param node  起始节点
     */
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * 左孩子---->右孩子---->父节点
     *
     * @param node  起始节点
     */
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
