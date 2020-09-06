package com.lxgandlz.leetcode;

import org.junit.Test;

/**
 * @author li xin guang
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {

        int result = 0;
        int length = s.length();
        for(int i=length-1; i>=0; i-- ){
            if(s.charAt(i) != ' '){
                result++;
            }
            if(result != 0 && s.charAt(i) == ' '){
                return result;
            }
        }

        return result;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord(" a   "));
    }
}
