package com.example.java.interview.guide.chapter1.list;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Package :  com.example.java.interview.guide.chapter1.list
 * @Date : 2019-04-23 17:29
 * @Version : V1.0
 * @Description : 测试线性表
 */
public class SequenceListDemo {
    public static void main(String[] args) {
        int defaultSize = 15;
        SequenceList sequenceList = new SequenceList(defaultSize);
        System.out.println("----------向线性表新增元素----------");
        // 测试insert、get、size方法
        for (int i = 0; i < defaultSize; i++) {
            sequenceList.insert(sequenceList.size(), i);
        }
        for (int i = 0; i < sequenceList.size(); i++) {
            System.out.print(sequenceList.get(i) + " ");
        }
        System.out.println();
        System.out.println("----------测试线性表已满----------");
        try {
            sequenceList.insert(0, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("----------从线性表删除元素----------");
        // 测试delete方法
        sequenceList.delete(0);
        for (int i = 0; i < sequenceList.size(); i++) {
            System.out.print(sequenceList.get(i) + " ");
        }
    }
}
