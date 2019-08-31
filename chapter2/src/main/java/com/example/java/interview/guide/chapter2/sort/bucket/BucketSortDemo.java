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
        int[] array = {7, 17, 39, 26, 72, 94,
                21, 12, 23, 68, 50, 76};
        bucketSort.sort(array);
        System.out.println("{7, 17, 39, 26, 72, 94, " +
                "21, 12, 23, 68, 50, 76}");
        System.out.println("进行桶排序后的结果是：");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
