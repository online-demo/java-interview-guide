package com.example.java.interview.guide.chapter3.array.multiply;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/15
 * @Version : V1.0
 * @Description : 测试除自身以外数组的乘积
 */
public class ExceptSelfProductDemo {
    public static void main(String[] args) {
        ExceptSelfProduct exceptSelfProduct = new ExceptSelfProduct();
        int[] source = {1, 2, 3, 4};
        int[] result1 = exceptSelfProduct.product1(source);
        System.out.print("数组{1, 2, 3, 4}除自身以外数组的乘积=");
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();
        System.out.print("数组{1, 2, 3, 4}除自身以外数组的乘积=");
        int[] result2 = exceptSelfProduct.product2(source);
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
    }
}
