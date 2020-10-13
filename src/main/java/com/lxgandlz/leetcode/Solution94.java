package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * Related Topics
 * 栈
 * 树
 * 哈希表
 * @author li xin guang
 * @date 2020/10/13 16:43
 */
public class Solution94 {
    /**
     * 递归法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        return middleTraversal(root, result);

    }

    private List<Integer> middleTraversal(TreeNode root, List<Integer> result){

        if(root == null){
            return null;
        }
        middleTraversal(root.left,result);
        result.add(root.val);

        middleTraversal(root.right,result);

        return result;
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode tow = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right = tow;
        tow.left = three;

        System.out.println(JSON.toJSONString(inorderTraversal(root)));
    }
}

