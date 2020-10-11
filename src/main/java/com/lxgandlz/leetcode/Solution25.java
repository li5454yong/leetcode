package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author li xin guang
 * @date 2020-09-19 22:09
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution25 {
    /**
     * 解题思路：
     * 将链表分为已翻转、待翻转、未翻转三个区域；
     * 使用4个指针，s作为哨兵永远指向链表头部；start指向待翻转区域的前一个节点；end作为一个活动的指针，初始时与start一样，指向待翻转区域的前一个节点
     * 随着i的增加，end逐渐向后移动，最终指向待翻转区域的最后一个节点；next始终指向未翻转区域的第一个节点。
     * while循环中做的事情就是改变start、end、next三个指针的指向；for循环中end指针向后移动
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode s = new ListNode(0);
        s.next = head;

        ListNode start = s, next = head, end = s;

        while (next != null){

            for (int i=0; i<k && end != null; i++){
                end = end.next;
            }
            if(end == null){
                break;
            }
            next = end.next;
            end.next = null;
            end = start.next;
            start.next = reverse(start.next);
            start = end;
            start.next = next;

        }


        return s.next;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head){
        ListNode prev = null,next;

        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    @Test
    public void test(){
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(4);
        ListNode m3 = new ListNode(5);
        ListNode l1 = new ListNode(6);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(8);

        m1.next = m2;
        m2.next = m3;
        m3.next = l1;
        l1.next = l2;
        l2.next = l3;

        System.out.println(JSON.toJSONString(reverseKGroup(m1,4)));
    }

}
