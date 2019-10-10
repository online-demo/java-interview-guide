package com.example.interview.guide.chapter4.set.treeset;
import java.util.Iterator;
import java.util.NavigableSet;
import	java.util.TreeSet;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/10/10 10:47
 * @Version : V1.0
 * @Description : TreeSet使用方式
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<> ();
        treeSet.add(80);
        treeSet.add(100);
        treeSet.add(60);
        treeSet.add(90);
        treeSet.add(70);
        Iterator<Integer> iterator = treeSet.iterator();
        System.out.println("从小到大输出treeSet中的元素：");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("生成从大到小的迭代器,");
        System.out.println("从大到小输出treeSet中的元素：");
        Iterator<Integer> descendingIterator = treeSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();
        System.out.println("生成从大到小的集合,");
        System.out.println("从大到小输出treeSet中的元素：");
        NavigableSet<Integer> navigableSet = treeSet.descendingSet();
        Iterator<Integer> descendingSetIterator = navigableSet.iterator();
        while (descendingSetIterator.hasNext()) {
            System.out.print(descendingSetIterator.next() + " ");
        }

    }
}
