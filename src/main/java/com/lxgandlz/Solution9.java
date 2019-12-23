package com.lxgandlz;

import org.junit.Test;

/**
 * @author li xin guang
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution9 {
    public boolean isPalindrome(int x) {

        if(x < 0 || (x%10 == 0 && x != 0)){
            return false;
        }
        int rev = 0;
        while (x > rev){
            rev = rev* 10 + x%10;
            x = x/10;
        }
        return rev == x || x == rev/10;
    }

    @Test
    public void test(){
        System.out.println(isPalindrome(0));
    }
}
