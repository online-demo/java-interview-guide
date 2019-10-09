package com.example.interview.guide.chapter3.list.sequence;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019-04-23 17:29
 * @Version : V1.0
 * @Description : 测试顺序线性表
 */
public class SequenceListDemo {
    public static void main(String[] args) {
        /**
         * 线性表最大容量
         */
        int maxSize = 15;
        SequenceList sequenceList = new SequenceList(maxSize);
        System.out.println("----------向顺序线性表新增元素----------");
        // 测试insert、get、size方法
        for (int i = 0; i < maxSize; i++) {
            sequenceList.insert(sequenceList.size(), i);
        }
        for (int i = 0; i < sequenceList.size(); i++) {
            System.out.print(sequenceList.get(i) + " ");
        }
        System.out.println();
        System.out.println("----------测试顺序线性表已满----------");
        try {
            sequenceList.insert(0, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        // 测试delete方法
        sequenceList.delete(0);
        System.out.println("----------顺序线性表是否为空----------");
        System.out.println(sequenceList.isEmpty());
        System.out.println("----------顺序线性表删除元素后----------");
        for (int i = 0; i < sequenceList.size(); i++) {
            System.out.print(sequenceList.get(i) + " ");
        }
    }
}
