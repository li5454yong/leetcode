package com.lxgandlz;

import org.junit.Test;

/**
 * @author li xin guang
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {

        int s = 0, m = 0, e = nums.length - 1;
        if (target < nums[s]) {
            return 0;
        }
        if (target > nums[e]) {
            return e + 1;
        }

        while (s <= e) {
            m = (e + s) / 2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] < target){
                s = m + 1;
            }
            if(nums[m] > target){
                e = m -1;
            }

        }
        return s;
    }

    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6, 7, 8, 10, 67}, 55));
    }
}
