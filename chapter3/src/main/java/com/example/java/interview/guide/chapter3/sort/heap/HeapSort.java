package com.example.java.interview.guide.chapter3.sort.heap;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/23 19:09
 * @Version : V1.0
 * @Description : 堆排序
 */
public class HeapSort {
    /**
     * 对数组排序
     *
     * @param source 待排序的数组
     */
    public void sort(int[] source) {
        // 数组非空校验和长度校验
        if (source == null || source.length < 2) {
            return;
        }
        // 数组长度
        int length = source.length;
        // 构建大顶堆
        buildMaxHeap(source, length);
        // 经过以上步骤构建大顶堆后
        // 最大的元素一定在堆顶
        // 堆顶元素的索引是0
        // 从数组最后一个元素开始遍历
        for (int i = source.length - 1; i > 0; i--) {
            // 最后一个元素与堆顶元素交换
            // 既将最大元素放在数组最后一位
            swap(source, 0, i);
            // 堆顶元素交换后，不需要参与调整
            // 因此长度减去1
            length--;
            // 调整大顶堆
            modifyMaxHeap(source, 0, length);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param source 数组
     * @param length 长度
     */
    private void buildMaxHeap(int[] source, int length) {
        // 构建大顶堆
        for (int parent = (int) Math.floor(length / 2);
             parent >= 0; parent--) {
            // 调整大顶堆
            modifyMaxHeap(source, parent, length);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param source 数组
     * @param parent 父结点
     * @param length 长度
     */
    private void modifyMaxHeap(int[] source, int parent, int length) {
        // parent位置的元素左孩子的位置
        int left = 2 * parent + 1;
        // parent位置的元素右孩子的位置
        int right = 2 * parent + 2;
        // 父结点，左孩子，右孩子的最大值
        int largest = parent;
        // 左孩子 > 最大值
        if (left < length && source[left] > source[largest]) {
            // 修改最大值的位置
            largest = left;
        }
        // 右孩子 > 最大值
        if (right < length && source[right] > source[largest]) {
            // 修改最大值的位置
            largest = right;
        }
        // 最大值的位置不等于父节点的位置
        if (largest != parent) {
            // 交换最大值和父结点
            swap(source, parent, largest);
            // 递归
            modifyMaxHeap(source, largest, length);
        }
    }

    /**
     * 交换两个位置上的元素
     *
     * @param array 数组
     * @param i     位置i
     * @param j     位置j
     */
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
