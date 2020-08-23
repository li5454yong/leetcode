package com.lxgandlz;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;

/**
 * @author li xin guang
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution15 {
    /**
     * 三层循环
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(i == j){
                    continue;
                }
                for(int k=0; k<nums.length; k++){
                    if(i == k || j == k){
                        continue;
                    }
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);

                        result.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * 两层循环+Map查询
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums == null || nums.length < 2){
            return Collections.EMPTY_LIST;
        }
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=i+1; j<nums.length; j++){
                int k = 0 - nums[i] - nums[j];
                if(map.get(k) != null){
                    List list = Arrays.asList(nums[i], nums[j], map.get(k));
                    Collections.sort(list);
                    result.add(list);
                    continue;
                }else{
                    map.put(nums[j], nums[j]);
                }

            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if(nums == null || nums.length < 2){
            return Collections.EMPTY_LIST;
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            int target = -nums[i];
            for(int j=i+1, p=nums.length-1; p>j;){

                if(target == nums[j] + nums[p]){
                    List list = Arrays.asList(nums[i], nums[j], nums[p]);
                    Collections.sort(list);
                    result.add(list);
                }
                if( target -(nums[j] + nums[p]) <= 0){
                    p--;
                }else {
                    j++;
                }

            }
        }

        return new ArrayList<>(result);
    }

    @Test
    public void test(){
        int[] arr = {3,0,-2,-1,1,2};
        System.out.println(JSON.toJSONString(threeSum2(arr)));
    }
}
