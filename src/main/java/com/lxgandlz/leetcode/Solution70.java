package com.lxgandlz.leetcode;

import org.junit.Test;

/**
 * @author li xin guang
 * @date 2020/1/15 17:42
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 输入：4=1+3+1
 * 输出：5
 * 1. 1+1+1+1
 * 2. 1+2+1
 * 3. 1+1+2
 * 4. 2+1+1
 * 5. 2+2
 * <p>
 * 5=1+4+3
 * 1. 1+1+1+1+1
 * 2. 2+1+1+1
 * 3. 1+2+1+1
 * 4. 1+1+2+1
 * 5. 1+1+1+2
 * 6. 2+2+1
 * 7. 1+2+2
 * 8. 2+1+2
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 */
public class Solution70 {
    public int climbStairs(int n) {

        int q = 0;
        int p = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = q + p;
        }


        return r;
    }

    @Test
    public void test() {
        System.out.println(climbStairs(5));
    }
}
