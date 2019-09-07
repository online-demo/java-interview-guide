package com.example.java.interview.guide.chapter3.array.zero;

import static com.example.java.interview.guide.chapter3.array.rotate.RotateArrayDemo.print;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/5 16:23
 * @Version : V1.0
 * @Description : 测试移动零
 */
public class MoveZeroesDemo {
    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes.move(array);
        System.out.println("{0, 1, 0, 3, 12}移动零以后结果：");
        print(array);
    }
}
