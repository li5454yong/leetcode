package com.lxgandlz;

import org.junit.Test;

/**
 * @author li xin guang
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String str = strs[0];
        String result = "";
        for(int i=0; i<=str.length(); i++){
            String pre = str.substring(0,i);
            for(int j=1; j<strs.length; j++){
                if(!strs[j].startsWith(pre)){
                    return result;
                }

            }
            result = pre;
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new String[]{"cft","rfc"}));
    }
}
