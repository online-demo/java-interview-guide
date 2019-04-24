package com.example.java.interview.guide.chapter1.list.link;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-24 14:33
 * @Version : V1.0
 * @Description : 测试链式线性表
 */
public class LinkListDemo {
    public static void main(String[] args) {
        int size = 10;
        LinkList linkList = new LinkList();
        System.out.println("----------向链式线性表新增元素----------");
        // 测试insert、get、size方法
        for (int i = 0; i < size; i++) {
            linkList.insert(i, i);
        }
        for (int j = 0; j < linkList.size(); j++) {
            System.out.print(linkList.get(j) + " ");
        }
        System.out.println();
        // 从链式线性表删除元素
        linkList.delete(0);
        System.out.println("----------链式线性表是否为空----------");
        System.out.println(linkList.isEmpty());
        System.out.println("----------链式线性表删除元素后----------");
        for (int j = 0; j < linkList.size(); j++) {
            System.out.print(linkList.get(j) + " ");
        }
    }
}
