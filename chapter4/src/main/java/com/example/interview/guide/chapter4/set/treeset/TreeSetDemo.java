package com.example.interview.guide.chapter4.set.treeset;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
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
        System.out.println("生成从大到小的迭代器," +
                "从大到小输出treeSet中的元素：");
        Iterator<Integer> descendingIterator =
                treeSet.descendingIterator();
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println();
        System.out.println("生成从大到小的集合," +
                "从大到小输出treeSet中的元素：");
        NavigableSet<Integer> navigableSet =
                treeSet.descendingSet();
        Iterator<Integer> descendingSetIterator =
                navigableSet.iterator();
        while (descendingSetIterator.hasNext()) {
            System.out.print(descendingSetIterator.next() + " ");
        }
        System.out.println();
        System.out.printf("treeSet中的第1个元素：%s%n",
                treeSet.first());
        System.out.printf("treeSet中的最后1个元素：%s%n",
                treeSet.last());
        System.out.println("treeSet中大于或等于80的子集：");
        SortedSet<Integer> greaterSetInclusive =
                treeSet.tailSet(80);
        System.out.println(greaterSetInclusive);
        System.out.println("treeSet中大于80的子集：");
        SortedSet<Integer> greaterSetExclusive =
                treeSet.tailSet(80, false);
        System.out.println(greaterSetExclusive);
        System.out.println("treeSet中小于或等于90的子集：");
        SortedSet<Integer> lessSetInclusive =
                treeSet.headSet(90, true);
        System.out.println(lessSetInclusive);
        System.out.println("treeSet中小于90的子集：");
        SortedSet<Integer> lessSetExclusive =
                treeSet.headSet(90);
        System.out.println(lessSetExclusive);
        System.out.printf("treeSet中大于或等于100的最小元素是：%s%n",
                treeSet.ceiling(100));
        System.out.printf("treeSet中小于或等于95的最大元素是：%s%n",
                treeSet.floor(95));
        System.out.printf("treeSet中小于90的最大元素：%s%n",
                treeSet.lower(90));
        System.out.printf("treeSet中大于100的最小元素：%s%n",
                treeSet.higher(100));
        System.out.printf("删除treeSet中的第1个元素：%s%n",
                treeSet.pollFirst());
        System.out.printf("删除treeSet中的第1个元素：%s%n",
                treeSet.pollLast());
        System.out.printf("treeSet中的剩余元素：%s%n", treeSet);
    }
}
