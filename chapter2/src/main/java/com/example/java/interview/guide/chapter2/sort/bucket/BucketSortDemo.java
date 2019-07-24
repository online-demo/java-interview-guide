package com.example.java.interview.guide.chapter2.sort.bucket;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/24 16:49
 * @Version : V1.0
 * @Description : 测试桶排序
 */
public class BucketSortDemo {
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] array = {42, 20, 17, 13, 28, 14, 23, 15};
        bucketSort.sort(array);
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
