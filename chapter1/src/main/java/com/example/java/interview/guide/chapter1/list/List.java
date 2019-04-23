package com.example.java.interview.guide.chapter1.list;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Package : com.example.java.interview.guide.chapter1.list
 * @Date : 2019-04-23 15:38
 * @Version : V1.0
 * @Description : 线性表
 */
public interface List {
    /**
     * 查询线性表长度
     *
     * @return 线性表长度
     */
    int size();

    /**
     * 判断线性表是否为空
     *
     * @return          true : 空 false : 非空
     */
    boolean isEmpty();

    /**
     * 插入元素
     *
     * @param index     位置
     * @param object         元素
     * @throws Exception
     */
    void insert(int index, Object object);

    /**
     * 删除元素
     *
     * @param index     位置
     * @throws Exception
     */
    void delete(int index);

    /**
     * 查询指定位置的元素
     *
     * @param index     位置
     * @return          元素
     * @throws Exception
     */
    Object get(int index);
}
