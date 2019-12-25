package com.lxgandlz;

import org.junit.Test;

/**
 * @author li xin guang
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {

        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            max = Math.max(max, curr);
        }

        return max;

    }

    @Test
    public void test() {
        System.out.println(maxSubArray(new int[]{1,2}));
    }
}
