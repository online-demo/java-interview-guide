package com.example.java.interview.guide.chapter2.array.intersect;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/11
 * @Version : V1.0
 * @Description : 测试两个数组的交集
 */
public class InterSectDemo {
    public static void main(String[] args) {
        InterSect interSect = new InterSect();
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {2, 3};
        System.out.print("数组{1, 2, 3, 4}和数组{2, 3}的交集=");
        System.out.println(interSect.intersect1(array1, array2));
        int[] array3 = {1, 2, 3, 4};
        int[] array4 = {3, 4, 5};
        System.out.print("数组{1, 2, 3, 4}和数组{3, 4, 5}的交集=");
        System.out.println(interSect.intersect2(array3, array4));
    }
}
