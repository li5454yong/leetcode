package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author li xin guang
 * @date 2020-09-19 16:00
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode header = new ListNode();
        ListNode p = header;
        int num = 0;
        while (l1 != null && l2 != null){
            p.next = new ListNode();
            p = p.next;
            p.val = (num + l1.val + l2.val) % 10;
            num = (num + l1.val + l2.val) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null){
            while (l1 != null){
                p.next = new ListNode();
                p = p.next;
                p.val = (num + l1.val) % 10;
                num = (num + l1.val) / 10;
                l1 = l1.next;
            }
        }
        if(l2 != null){
            while (l2 != null){
                p.next = new ListNode();
                p = p.next;
                p.val = (num + l2.val) % 10;
                num = (num + l2.val) / 10;
                l2 = l2.next;
            }
        }
        if(num > 0){
            p.next = new ListNode();
            p = p.next;
            p.val = num;
        }

        return header.next;
    }

    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(6);
        ListNode m4 = new ListNode(6);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        System.out.printf(JSON.toJSONString(addTwoNumbers(l1, m1)));
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
