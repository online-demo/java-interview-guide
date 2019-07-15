package com.example.java.interview.guide.chapter2.array.multiply;

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
        int[] result = exceptSelfProduct.product(source);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
