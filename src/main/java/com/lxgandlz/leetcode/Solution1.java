package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author li xin guang
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution1 {

    int[] twoSum(int[] nums, int target) {

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(target == nums[i] + nums[j] && i != j){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    /**
     * 一遍哈希
     * @param nums
     * @param target
     * @return
     */
    int[] twoSum1(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(16);

        for(int i=0; i< nums.length; i++){
            if(map.get(target - nums[i]) != null){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);

        }

        return null;
    }

    @Test
    public void test(){
        System.out.println(JSON.toJSONString(twoSum(new int[]{1,2,34,56,7},63)));
    }
}
