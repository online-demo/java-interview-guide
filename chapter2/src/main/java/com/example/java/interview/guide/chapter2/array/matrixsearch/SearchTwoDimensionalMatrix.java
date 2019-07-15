package com.example.java.interview.guide.chapter2.array.matrixsearch;


/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/15
 * @Version : V1.0
 * @Description : 搜索二维矩阵
 */
public class SearchTwoDimensionalMatrix {
    /**
     * 搜索二维矩阵是否含有某个元素
     *
     * 二分查找法搜索矩阵的每一行
     *
     * @param matrix    二维矩阵
     * @param element   元素
     * @return          结果
     */
    public boolean contains(int[][] matrix, int element) {
        // 矩阵合法性校验
        int dimension = matrix.length;
        if (dimension == 0) {
            return false;
        }
        int size = matrix[0].length;
        if (size == 0) {
            return false;
        }
        // 遍历二维矩阵
        for (int i = 0; i < dimension; i++) {
            // 低位指针，二分搜索matrix[i]的起点
            int low = 0;
            // 高位指针，二分搜索matrix[i]的终点
            int high = size - 1;
            // 低位指针 <= 高位指针
            while (low <= high) {
                // 中间值
                int middle = (low + high) / 2;
                // 找到元素
                if (matrix[i][middle] == element) {
                    return true;
                    // 中间值 < element
                } else if (matrix[i][middle] < element) {
                    // 修改low指针，即在matrix[i]的后半部分搜索
                    low = middle + 1;
                    // 中间值 > element
                } else {
                    /// 修改high指针，即在matrix[i]的前半部分搜索
                    high = middle - 1;
                }
            }
        }
        return false;
    }

    /**
     * 分治算法查找二维矩阵是否含有某个元素
     * 若左下角元素等于目标元素，则找到
     * 若左下角元素大于目标元素，则目标元素不可能存在于当前矩阵的最后一行，问题规模可以减少最后一行
     * 若左下角元素小于目标元素，则目标元素不可能存在于当前矩阵的第一列，问题规模可以减小第一列
     * 依次减小问题的规模
     *
     * @param matrix        二维矩阵
     * @param element       元素
     * @return              结果
     */
    public boolean search(int[][] matrix, int element) {
        // 矩阵合法性校验
        int dimension = matrix.length;
        if (dimension == 0) {
            return false;
        }
        int size = matrix[0].length;
        if (size == 0) {
            return false;
        }
        // 最后1行
        int i = dimension - 1;
        // 第1列
        int j = 0;
        while (i >= 0 && j < size) {
            // 找到element
            if (matrix[i][j] == element) {
                return true;
                // matrix[i][j] < elements说明这一列不可能含有element
            } else if (matrix[i][j] < element) {
                // 下一列进行搜索
                j++;
                // matrix[i][j] > elements说明这一行不可能含有element
            } else {
                // 上一行进行搜索
                i--;
            }
        }
        return false;
    }
}
