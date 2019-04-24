package com.example.java.interview.guide.chapter1.list.sequence;

import com.example.java.interview.guide.chapter1.list.List;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-23 16:25
 * @Version : V1.0
 * @Description :  顺序线性表实现
 */
public class SequenceList implements List {
    /**
     * 顺序表的容量
     */
    private int maxSize;
    /**
     * 顺序表实际长度
     */
    private int length;
    /**
     * 一个数组来存放数据
     */
    private Object[] list;

    /**
     * 构造函数
     *
     * @param size      顺序表初始化容量
     */
    public SequenceList(int size) {
        if (size <= 0) {
            throw new RuntimeException("顺序表容量异常");
        }
        this.maxSize = size;
        this.length = 0;
        this.list = new Object[size];
    }

    /**
     * 默认构造函数
     */
    public SequenceList() {
        this(10);
    }
    /**
     * 查询线性表长度
     *
     * @return 线性表长度
     */
    @Override
    public int size() {
        return this.length;
    }

    /**
     * 判断线性表是否为空
     *
     * @return true : 空 false : 非空
     */
    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 插入元素
     *
     * @param index         位置
     * @param object        元素
     */
    @Override
    public void insert(int index, Object object) {
        if (length == maxSize) {
            throw new RuntimeException("顺序表已满，无法插入！");
        }
        //插入位置编号是否合法
        if (index < 0 || index > maxSize) {
            throw new RuntimeException("参数错误！");
        }
        for (int i = length - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        list[index] = object;
        length++;
    }

    /**
     * 删除元素
     *
     * @param index 位置
     */
    @Override
    public void delete(int index) {
        if (isEmpty()) {
            throw  new RuntimeException("顺序表为空，无法删除！");
        }
        if (index < 0 || index > maxSize - 1) {
            throw new RuntimeException("参数错误！");
        }
        // 移动index位置后的元素
        for (int i = index; i < length - 1; i++) {
            list[i] = list[i + 1];
        }
        length--;
    }

    /**
     * 查询指定位置的元素
     *
     * @param index 位置
     * @return 元素
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index >= maxSize) {
            throw new RuntimeException("参数错误！");
        }
        return list[index];
    }
}
