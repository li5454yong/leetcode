package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author li xin guang
 * @date 2020/9/25 16:19
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
 * 
 *  k 是一个正整数，它的值小于或等于链表的长度。 
 * 
 *  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
 * 
 *  
 * 
 *  示例： 
 * 
 *  给你这个链表：1->2->3->4->5 
 * 
 *  当 k = 2 时，应当返回: 2->1->4->3->5 
 * 
 *  当 k = 3 时，应当返回: 3->2->1->4->5 
 * 
 *  
 * 
 *  说明： 
 * 
 *  
 *  你的算法只能使用常数的额外空间。 
 *  你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode NHead = new ListNode(0);
        NHead.next = head;
        ListNode right = head, left = NHead;
        int n = 0;
        while (right != null){
            if(n == k){

            }
            right = right.next;
            n++;
        }
        return NHead.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        return null;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode m1 = new ListNode(7);
        ListNode m2 = new ListNode(9);
        ListNode m3 = new ListNode(11);
        l3.next = m1;
        m1.next = m2;
        m2.next = m3;

        System.out.println(JSON.toJSONString(reverseKGroup(l1,3)));

    }
}
