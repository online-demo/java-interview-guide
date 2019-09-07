package com.example.java.interview.guide.chapter3.sort.duplicate;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/29 19:14
 * @Version : V1.0
 * @Description : 测试寻找重复数
 */
public class DuplicateElementDemo {
    public static void main(String[] args) {
        DuplicateElement duplicateElement = new DuplicateElement();
        int[] array1 = {1, 3, 4, 2, 2};
        System.out.print("数组{1, 3, 4, 2, 2}的重复数：");
        System.out.println(duplicateElement.findDuplicate(array1));
        int[] array2 = {3, 1, 3, 4, 2};
        System.out.print("数组{3, 1, 3, 4, 2}的重复数：");
        System.out.println(duplicateElement.findDuplicate(array2));
    }
}
