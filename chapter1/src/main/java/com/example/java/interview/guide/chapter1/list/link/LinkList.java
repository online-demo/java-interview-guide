package com.example.java.interview.guide.chapter1.list.link;

import com.example.java.interview.guide.chapter1.list.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-24 10:12
 * @Version : V1.0
 * @Description : 链式线性表实现
 */
public class LinkList implements List {

    /**
     * 定义一个内部类Node，代表链式线性表的节点
     */
    private class Node {
        /**
         * 保存链式线性表的节点数据
         */
        private Object data;
        /**
         * 指向下个节点的引用
         */
        private Node next;
        /**
         * Node无参构造器
         */
        public Node() {

        }
        /**
         * Node有参构造器
         *
         * @param element      链式线性表节点数据
         * @param next      链式线性表下一个节点指针
         */
        public Node(Object element, Node next) {
            this.data = element;
            this.next = next;
        }
    }

    /**
     * 链式线性表头结点
     */
    private Node header;
    /**
     * 链式线性表尾节点
     */
    private Node tail;
    /**
     *  链式线性表长度
     */
    private int size;

    /**
     * 链式线性表无参构造器
     */
    public LinkList() {
        header = null;
        tail = null;
    }

    /**
     * 链式线性表有参构造器
     *
     * @param element       元素值
     */
    public LinkList(Object element) {
        header = new Node(element, null);
        // 只有一个节点，header,tail都指向该节点
        tail = header;
        size++;
    }

    /**
     * 查询线性表长度
     *
     * @return 线性表长度
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 判断线性表是否为空
     *
     * @return true : 空 false : 非空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入元素
     *
     * @param index  位置
     * @param element 元素
     */
    @Override
    public void insert(int index, Object element) {
        if(index < 0 || index > size){
            throw new RuntimeException("索引超出链式线性表范围");
        }
        //如果是空链表
        if(header == null) {
            add(element);
            return;
        }
        //当index为0时，即在链表头处插入元素
        if(index == 0){
            addAtHead(element);
        }
        else{
            //获取前一个节点
            Node prev = findByIndex(index - 1);
            //让prev的next指向新节点，新节点的next指向原来prev的下一个节点
            prev.next = new Node(element, prev.next);
            size++;
        }
    }

    /**
     * 链式线性表头部插入元素
     *
      * @param element      元素值
     */
    private void addAtHead(Object element){
        //创建新节点，
        Node newNode = new Node(element, null);
        // 新节点的next指向header
        newNode.next = header;
        // 新节点作为新的header
        header = newNode;
        //若插入前是空表
        if(tail == null){
            tail = header;
        }
        size++;
    }
    /**
     * 新增一个链式线性表节点
     *
     * @param element        元素值
     */
    private void add(Object element) {
        //如果链式线性表是空的
        if(header == null){
            header = new Node(element, null);
            //只有一个节点，header,tail都该指向该节点
            tail = header;
        } else {
            //创建新节点
            Node newNode = new Node(element, null);
            //尾节点的next指向新节点
            tail.next = newNode;
            //将新节点作为尾节点
            tail = newNode;
        }
        size++;
    }

    /**
     * 删除元素
     *
     * @param index     位置
     */
    @Override
    public void delete(int index) {
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException("索引超出链式线性表范围");
        }
        Node del;
        //若删除的是头节点
        if(index == 0) {
            header = header.next;
            size--;
            return;
        }
        //获取待删除节点的前一个节点
        Node prev = findByIndex(index - 1);
        //获取待删除节点
        del = prev.next;
        prev.next = del.next;
        //将被删除节点的next引用置为空
        del.next = null;
        size--;
    }

    /**
     * 查询指定位置的元素
     *
     * @param index     位置
     * @return          元素
     */
    @Override
    public Object get(int index) {
        Node node = findByIndex(index);
        if (node != null) {
            return node.data;
        }
        return null;
    }

    /**
     * 根据索引值查找链式线性表元素
     *
     * @param index         索引值
     * @return              Node节点
     */
    private Node findByIndex(int index) {
        if(index < 0 || index > size-1){
            throw new RuntimeException("索引超出链式线性表范围");
        }
        // 从header开始遍历
        Node current = header;
        // 从链式线性表头结点向后查找index位置的Node节点
        for (int i = 0; i < size && current != null; i++, current = current.next) {
            if (i == index) {
                return current;
            }
        }
        return null;
    }
}
