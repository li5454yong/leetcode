package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author li xin guang
 * @date 2020-09-06 22:30
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 *  
 *
 * 提示：
 *
 * intervals[i][0] <= intervals[i][1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution56 {
    public int[][] merge(int[][] intervals) {

        // 1、使用arr[i][0] 从小到大排序
        intervals = sort(intervals,0,intervals.length-1);

        // 2、使用贪心算法，假设当前temp中的最后一个元素就是最大的，依次从intervals取出元素与temp中的最后一个对比，判断是否合并
        int[][] temp = new int[intervals.length][2];
        int i = -1;
        for(int[] a : intervals){
            if(i == -1 || temp[i][1] < a[0]){
                temp[++i] = a;
            }else{
                temp[i][1] = Math.max(a[1],temp[i][1]);
            }
        }

        return Arrays.copyOf(temp,i+1);
    }

    /**
     * 使用快排进行排序
     * @param arr
     * @param p
     * @param r
     * @return
     */
    public int[][] sort(int[][] arr, int p, int r){

        if(p > r){
            return new int[][]{};
        }

        int q = partition(arr, p, r);
        sort(arr, p,q-1);
        sort(arr, q+1,r);

        return arr;
    }
    private int partition(int[][] arr, int p, int r){

        int pivot = arr[r][0];
        int i = p;
        for(int j=p; j<r; j++){
            if(arr[j][0] < pivot){
                int[] temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int[] temp = arr[r];
        arr[r] = arr[i];
        arr[i] = temp;
        return i;
    }
    @Test
    public void test(){
        int x = 5, y = 2;
        int[][] arr = new int[x][y];
        Random random = new Random();
        for(int i=0; i<x; i++){

            arr[i][0] = random.nextInt(100);
            arr[i][1] = (arr[i][0] + random.nextInt(100));
        }

        System.out.println(JSON.toJSONString(merge(arr)));

    }
}
