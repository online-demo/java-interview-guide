package com.example.interview.guide.chapter3.array.maxcount;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/4 18:00
 * @Version : V1.0
 * @Description : 测试求众数
 */
public class MostCountNumDemo {
    public static void main(String[] args) {
        MostCountNum mostCountNum = new MostCountNum();
        int[] array1 = {3, 2, 3};
        System.out.print("数组{3, 2, 3}的众数是");
        System.out.println(mostCountNum.majorityNum(array1));
        int[] array2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.print("数组{2,2,1,1,1,2,2}的众数是");
        System.out.println(mostCountNum.majorityNum(array2));
    }
}
