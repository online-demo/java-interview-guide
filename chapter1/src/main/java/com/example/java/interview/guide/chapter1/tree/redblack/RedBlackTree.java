package com.example.java.interview.guide.chapter1.tree.redblack;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-05-13 17:31
 * @Version : V1.0
 * @Description :   红黑树的实现
 */
public class RedBlackTree {
    /**
     * 红色结点的值
     */
    private final int RED = 0;
    /**
     * 黑色结点的值
     */
    private final int BLACK = 1;
    /**
     * 红黑树根结点
     */
    private Node root;
    /**
     * 红黑树默认构造器
     */
    public RedBlackTree() {
        root = null;
    }
    /**
     * 红黑树的结点
     */
    private class Node {
        /**
         * 结点值
         */
        int key;
        /**
         * 结点颜色
         */
        int color = BLACK;
        /**
         * 结点的左孩子
         */
        Node left = null;
        /**
         * 结点的右孩子
         */
        Node right = null;
        /**
         * 结点的父结点
         */
        Node parent = null;

        /**
         * 结点构造器
         *
         * @param key       结点元素值
         */
        Node(int key) {
            this.key = key;
        }
    }

    /**
     * 红黑树中插入结点
     *
     * @param key       结点值
     */
    public void insert(int key) {
        Node node = new Node(key);
        insert(node);
    }

    /**
     * 插入结点
     *
     * @param node   待插入结点
     */
    public void insert(Node node) {
        Node temp = root;
        // 待插入结点的父结点
        Node parent = null;
        // 父结点和子结点key值大小比较值
        int compare;
        // step 1. 将红黑树当作一颗二叉查找树，将结点添加到二叉查找树中
        while (temp != null) {
            parent = temp;
            // 子结点key - 父结点key
            compare =  node.key - temp.key;
            // 子结点key < 父结点key
            if (compare < 0) {
                //搜索左子树,改变temp引用指向其左孩子
                temp = temp.left;
            } else if(compare > 0) {
                //搜索右子树
                temp = temp.right;
            } else {
                // 等于0说明元素已经存在，不需要插入
                return;
            }
        }
        // 找到了带插入结点的位置：parent结点
        // 待插入结点的父结点 = parent
        node.parent = parent;
        if (parent != null) {
            // 确定node是其父结点parent的左孩子还是右孩子
            compare = node.key - parent.key;
            if (compare < 0) {
                // 待插入结点作为parent父结点的左子结点
                parent.left = node;
            } else {
                // 待插入结点作为parent父结点的右子结点
                parent.right = node;
            }
        } else {
            // parent == null，即红黑树不存在
            root = node;
        }
        // step 2. 设置插入的结点的颜色为红色
        node.color = RED;
        // step 3. 调整红黑树，使之重新达到平衡
        fixRedBlackTree(node);
    }

    /**
     * 调整红黑树，使之重新达到平衡
     *
     * @param node      结点
     */
    private void fixRedBlackTree(Node node) {
        // 查询node结点的父结点
        Node parent;
        // node祖父结点
        Node grandParent;
        // 父结点是黑色的情况下不需要调整
        // 父结点存在 && 父结点的颜色是红色——此时需要调整红黑树
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            // 祖父结点
            grandParent = parentOf(parent);
            // 祖父结点不存在，说明当前的红黑树高度为2，跳出当前循环
            if (grandParent == null) {
                break;
            }
            // 父结点是祖父结点的左孩子
            if (parent == grandParent.left) {
                // node结点的叔叔结点
                Node uncle = grandParent.right;
                // case 1 ： 叔叔结点是红色
                if (isRed(uncle)) {
                    // 叔叔结点涂黑
                    setBlackColor(uncle);
                    // 父结点涂黑
                    setBlackColor(parent);
                    // 祖父结点涂红
                    setRedColor(grandParent);
                    // 继续调整祖父结点
                    node = grandParent;
                    continue;
                }
                // case 2 : 叔叔结点是黑色 && 当前结点是父结点的右孩子
                if (node == parent.right) {
                    // 父结点
                    Node temp = parent;
                    // 左旋转
                    leftRotate(parent);
                    // 交换parent和node
                    parent = node;
                    node = temp;
                }
                // case 3 : 叔叔是黑色，且当前结点是左孩子
                // 也有可能是case 2旋转来
                // 或者是插入的时候就是左结点
                setBlackColor(parent);
                setRedColor(grandParent);
                rightRotate(grandParent);
            } else {
                // 父结点是祖父结点的右孩子的情况
                // node结点的叔叔结点
                Node uncle = grandParent.left;
                // case 1 ： 叔叔结点是红色
                if (isRed(uncle)) {
                    setBlackColor(uncle);
                    setBlackColor(parent);
                    setRedColor(grandParent);
                    node = grandParent;
                    continue;
                }
                // case 2 : 叔叔结点是黑色 && 当前结点是左孩子
                if (node == parent.left) {
                    rightRotate(parent);
                    Node temp = parent;
                    parent = node;
                    node = temp;
                }
                // case 3 : 叔叔是黑色，且当前结点是右孩子
                // 也有可能是case 2旋转来
                // 或者是插入的时候就是右孩子
                setBlackColor(parent);
                setRedColor(grandParent);
                leftRotate(grandParent);
            }
        }
        // 设置根结点为黑色
        setBlackColor(root);
    }

    /**
     * 红黑树右旋转
     *
     * @param node      结点
     */
    private void rightRotate(Node node) {
        // 当前结点的左结点
        Node leftChild = node.left;
        // node结点的左孩子=node结点的左孩子的右结点
        node.left = leftChild.right;
        if (leftChild.right != null) {
            // 左孩子的右孩子=node
            leftChild.right.parent = node;
        }
        // 左孩子的父结点=node的父结点
        leftChild.parent = node.parent;
        // node父结点为空
        if (node.parent == null) {
            // 根结点=leftChild
            root = leftChild;
        } else {
            // node结点是父结点的右孩子
            if (node.parent.right == node) {
                // node父结点的右孩子=node结点的左孩子
                node.parent.right = leftChild;
            } else {
                // node父结点的左孩子=node结点的左孩子
                node.parent.left = leftChild;
            }
        }
        // node左孩子的右孩子=node
        leftChild.right = node;
        // node结点的父结点=node左孩子
        node.parent = leftChild;
    }

    /**
     * 红黑树左旋转
     *
     * @param node      结点
     */
    private void leftRotate(Node node) {
        // 结点node的右孩子
        Node rightChild = node.right;
        // 结点的右孩子=右孩子的左孩子
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        // 右结点的父结点 = 父结点的父结点
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else {
            // 如果node是父结点的左孩子
            if (node.parent.left == node) {
                // node结点的父结点的左孩子=node结点的右孩子
                node.parent.left = rightChild;
            } else {
                // node结点的父结点的右孩子=node结点的右孩子
                node.parent.right = rightChild;
            }
        }
        // node结点的右孩子的左孩子=node
        rightChild.left = node;
        // node结点的父结点=node结点的右孩子
        node.parent = rightChild;
    }

    /**
     * 设置结点颜色为红色
     *
     * @param node      结点
     */
    private void setRedColor(Node node) {
        if (node != null) {
            node.color = RED;
        }
    }

    /**
     * 设置结点颜色为黑色
     *
     * @param node      结点
     */
    private void setBlackColor(Node node) {
        if (node != null) {
            node.color = BLACK;
        }
    }

    /**
     * 返回结点的颜色
     *
     * @param node      结点
     * @return          结点颜色
     */
    private boolean isRed(Node node) {
        return (node != null) && (node.color == RED);
    }

    /**
     * 查询node结点的父结点
     *
     * @param node      node结点
     * @return          父结点
     */
    private Node parentOf(Node node) {
        return node != null ? node.parent : null;
    }


    /**
     * 中序遍历红黑树
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序遍历红黑树
     *
     * @param node      父结点
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + ":" +
                    (node.color == RED ? "红色" : "黑色") + "  ");
            inOrder(node.right);
        }
    }

    /**
     * 删除结点
     *
     * @param key       结点值
     */
    public void remove(int key) {
        Node node;
        if ((node = search(root, key)) != null) {
            remove(node);
        }
    }

    /**
     * 删除结点
     *
     * @param node      待删除的结点
     */
    private void remove(Node node) {
        if (node == null) {
            return;
        }
        Node child;
        Node parent;
        int color;
        // 被删除结点有左右两个子节点
        if (node.left != null && node.right != null) {
            // 被删除结点的后继结点
            // 用后继结点取代删除的结点，然后去除删除的结点
            // 后继结点是右子树中最左边的结点
            Node replace = node;
            // 下面是搜索node结点的后继结点
            replace = replace.right;
            while (replace.left != null) {
                replace = replace.left;
            }
            // node不是根结点(只有根结点不存在父结点)
            if (parentOf(node) != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left  = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                // 更新根结点
                root = replace;
            }
            // 后继结点的右孩子
            // 后继结点一定不会存在左孩子，否则就是其左孩子成为后继结点
            child = replace.right;
            // 后继结点的父结点
            parent = parentOf(replace);
            // 后继结点的颜色
            color = colorOf(replace);
            // 待删除结点是后继结点的父结点
            if (parent == node) {
                // 后继结点替代后继结点的父结点
                parent = replace;
            } else {
                // 后继结点的右孩子的父结点=后继结点的父结点
                if (child != null) {
                    child.parent = parent;
                }
                // 后继结点父结点的左孩子=后继结点的右孩子
                parent.left = child;
                // 后继结点的右孩子=node的右孩子
                replace.right = node.right;
                // node结点右孩子的父亲=后继结点
                node.right.parent = replace;
            }
            // 修改后继结点在红黑树中的父结点和子结点的关系
            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = replace;
            if (color == BLACK) {
                fixRemove(child, parent);
            }
            return;
        }
        // 待删除结点只有一个孩子结点
        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }
        // 待删除结点的父结点
        parent = node.parent;
        // 待删除结点的颜色
        color = node.color;
        if (child != null) {
            child.parent = parent;
        }
        // node结点不是根结点
        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            // 待删除结点是根结点
            root = child;
        }
        if (color == BLACK) {
            fixRemove(child, parent);
        }
    }

    /**
     * 红黑树删除后，重新调整红黑树
     *
     * @param node      待修正的结点
     * @param parent    父结点
     */
    private void fixRemove(Node node, Node parent) {
        Node other;
        while ((node == null || isBlack(node)) && node != root) {
            // node是父结点的一个左孩子
            if (parent.left == node) {
                // 兄弟结点=父结点的右孩子
                other = parent.right;
                if (isRed(other)) {
                    // case 1 : 兄弟结点是红色
                    setBlackColor(other);
                    setRedColor(parent);
                    leftRotate(parent);
                    other = parent.right;
                }
                if ((other.left == null || isBlack(other.left))
                        && (other.right == null || isBlack(other.right))) {
                    // 经历上面的if条件保证兄弟结点一定是黑色
                    // case 2 : 兄弟结点是黑色 && 兄弟结点的两个孩子都是黑色
                    setRedColor(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.right == null || isBlack(other.right)) {
                        // case 3 ：兄弟结点的左孩子是红色，兄弟结点的右孩子是黑色
                        setBlackColor(other.left);
                        setRedColor(other);
                        rightRotate(other);
                        other = parent.right;
                    }
                    // case 4 : 兄弟结点是黑色 && 右孩子是红色
                    setColor(other, colorOf(parent));
                    setBlackColor(parent);
                    setBlackColor(other.right);
                    leftRotate(parent);
                    node = root;
                    break;
                }
            } else {
                // 兄弟结点=父结点的左孩子
                other = parent.left;
                if (isRed(other)) {
                    // case 1 : 兄弟结点是红色
                    setBlackColor(other);
                    setRedColor(parent);
                    rightRotate(parent);
                    other = parent.left;
                }
                if ((other.left == null || isBlack(other.left))
                        && (other.right == null || isBlack(other.right))) {
                    // 经历上面的if条件保证兄弟结点一定是黑色
                    // case 2 : 兄弟结点是黑色 && 兄弟结点的两个孩子都是黑色
                    setRedColor(other);
                    node = parent;
                    parent = parentOf(node);
                } else {
                    if (other.left == null || isBlack(other.left)) {
                        // case 3 ：兄弟结点的右孩子是红色，兄弟结点的左孩子是黑色
                        setBlackColor(other.right);
                        setRedColor(other);
                        leftRotate(other);
                        other = parent.left;
                    }
                    // case 4 : 兄弟结点是黑色 && 左孩子是红色
                    setColor(other, colorOf(parent));
                    setBlackColor(parent);
                    setBlackColor(other.left);
                    rightRotate(parent);
                    node = root;
                    break;
                }
            }
        }
        if (node != null) {
            setBlackColor(node);
        }
    }

    /**
     * 设置结点的颜色
     * @param node
     * @param color
     */
    private void setColor(Node node, int color) {
        if (node != null) {
            node.color = color;
        }
    }

    /**
     * 结点的颜色是否为黑色
     *
     * @param node      结点
     * @return          boolean
     */
    private boolean isBlack(Node node) {
        return (node != null) && (node.color == BLACK);
    }

    /**
     * 结点的颜色
     * @param node
     * @return
     */
    private int colorOf(Node node) {
        return node != null ? node.color : BLACK;
    }

    /**
     * 查找值为key的结点
     *
     * @param node      父结点
     * @param key       待查找元素
     * @return          对应的Node
     */
    private Node search(Node node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            return search(node.left, key);
        } else if (key > node.key){
            return search(node.right, key);
        } else {
            return node;
        }
    }
}
