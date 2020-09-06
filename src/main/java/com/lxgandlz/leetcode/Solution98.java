package com.lxgandlz.leetcode;


import com.alibaba.fastjson.JSON;
import org.junit.Test;

import javax.swing.tree.TreeNode;


/**
 * @author li xin guang
 * @date 2020/8/23 17:46
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution98 {
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        if(!isValidBST(root.left)){
            return false;
        }
        if(root.val <= pre){
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    @Test
    public void test(){
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        root.setLeft(left);
        root.setRight(right);

        TreeNode left1 = new TreeNode(3);
        TreeNode right1 = new TreeNode(6);
        right.setLeft(left1);
        right.setRight(right1);

        System.out.printf(JSON.toJSONString(isValidBST(root)));

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}

