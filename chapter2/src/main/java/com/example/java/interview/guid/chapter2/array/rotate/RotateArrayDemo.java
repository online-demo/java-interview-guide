package com.example.java.interview.guid.chapter2.array.rotate;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/5 10:34
 * @Version : V1.0
 * @Description : 测试旋转数组
 */
public class RotateArrayDemo {
    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] array1 = {1, 2, 3, 4, 5, 6, 7};
        int position1 = 3;
        rotateArray.rotate(array1, position1);
        System.out.printf("数组{1, 2, 3, 4, 5, 6, 7}旋转%s个位置后的结果：%n", position1);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + ", ");
        }
        System.out.println();
        int[] array2 = {-1, -100, 3, 99};
        int position2 = 2;
        rotateArray.rotate(array2, position2);
        System.out.printf("数组{-1, -100, 3, 99}旋转%s个位置后的结果：%n", position2);
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + ", ");
        }
    }
}
