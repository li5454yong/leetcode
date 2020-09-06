package com.lxgandlz.leetcode;

import org.junit.Test;

/**
 * @author lixinguang
 * @date 2019-12-27 21:38
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class Solution67 {

    public String addBinary(String a, String b) {
        int z = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=a.length()-1,j=b.length()-1; i>=0 || j>=0; i--,j--){
            int sum = z;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum%2);
            z = sum/2;
        }
        if(z != 0){
            sb.append(z);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        System.out.println(addBinary("11","1"));
    }
}
