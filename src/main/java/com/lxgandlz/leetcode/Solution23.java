package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author li xin guang
 * @date 2020-09-19 19:08
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists,0);
    }


    public ListNode merge(ListNode[] lists, int n){

        if(n == lists.length - 1){
            return lists[n];
        }
        ListNode mergeResult = merge(lists,n+1);
        ListNode first = lists[n];

        ListNode head = new ListNode();
        ListNode temp = head;

        while (first != null && mergeResult != null){

            if(first.val < mergeResult.val){
                temp.next = first;
                first = first.next;
            }else {
                temp.next = mergeResult;
                mergeResult = mergeResult.next;
            }
            temp = temp.next;

        }

        if(first != null){
            temp.next = first;
        }
        if(mergeResult != null){
            temp.next = mergeResult;
        }
        return head.next;
    }



    @Test
    public void test(){
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(5);
        m1.next = m2;
        m2.next = m3;

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        System.out.println(JSON.toJSONString(mergeKLists(new ListNode[]{m1,l1})));
    }
    public class ListNode {
        int val;
        ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }
}
