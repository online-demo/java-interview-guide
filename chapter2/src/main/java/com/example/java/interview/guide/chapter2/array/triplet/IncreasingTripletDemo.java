package com.example.java.interview.guide.chapter2.array.triplet;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/12
 * @Version : V1.0
 * @Description : 测试递增的三元子序列
 */
public class IncreasingTripletDemo {
    public static void main(String[] args) {
        IncreasingTriplet increasingTriplet = new IncreasingTriplet();
        int[] array1 = {1, 2, 3, 4, 5};
        System.out.print("数组{1,2,3,4,5}是否含有递增的三元子序列：");
        System.out.println(increasingTriplet
                .containsIncreasingTriplet(array1));
        int[] array2 = {5, 4, 3, 2, 1};
        System.out.print("数组{5,4,3,2,1}是否含有递增的三元子序列：");
        System.out.println(increasingTriplet
                .containsIncreasingTriplet(array2));
    }
}
