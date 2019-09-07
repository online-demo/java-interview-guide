package com.example.java.interview.guide.chapter3.sort.duplicate;

/**
 * @Author : zhouguanya
 * @Project : java-interview-guide
 * @Date : 2019/7/29 18:44
 * @Version : V1.0
 * @Description : 寻找重复数
 */
public class DuplicateElement {
    /**
     * 查找重复数
     *
     * @param nums array
     * @return
     */
    public int findDuplicate(int[] nums) {
        // 开始位置
        int start = 1;
        // 结束位置
        int end = nums.length - 1;
        while (start + 1 < end) {
            // 中间位置
            int mid = start + (end - start) / 2;
            // 如果 比mid小的数字的个数 < mid
            if (smallerNunCount(mid, nums) <= mid) {
                // 说明mid之前的数据没有重复数
                // 在mid的后半部分查询
                start = mid;
            } else {
                // mid之前的数据存在重复数
                end = mid;
            }
        }
        // start  start+1  end
        if (smallerNunCount(start, nums) <= start) {
            return end;
        }
        return start;
    }

    public int smallerNunCount(int mid, int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
            }
        }
        return count;
    }
}
