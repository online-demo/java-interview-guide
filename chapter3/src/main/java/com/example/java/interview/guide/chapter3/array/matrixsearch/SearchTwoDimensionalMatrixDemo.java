package com.example.java.interview.guide.chapter3.array.matrixsearch;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/15
 * @Version : V1.0
 * @Description : 测试搜索二维矩阵
 */
public class SearchTwoDimensionalMatrixDemo {
    public static void main(String[] args) {
        SearchTwoDimensionalMatrix searchTwoDimensionalMatrix
                = new SearchTwoDimensionalMatrix();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        System.out.print("二维矩阵是否含有5：");
        System.out.println(searchTwoDimensionalMatrix
                .contains(matrix, 5));
        System.out.print("二维矩阵是否含有20：");
        System.out.println(searchTwoDimensionalMatrix
                .contains(matrix, 20));
        System.out.print("二维矩阵是否含有8：");
        System.out.println(searchTwoDimensionalMatrix
                .search(matrix, 8));
        System.out.print("二维矩阵是否含有28：");
        System.out.println(searchTwoDimensionalMatrix
                .search(matrix, 28));
    }
}
