package com.lxgandlz.leetcode;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author li xin guang
 * @date 2020-09-19 18:10
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow =  head, prev = head;

        int i = 0;
        while (fast != null){
            fast = fast.next;
            if(i >= n){
                prev = slow;
                slow = slow.next;
            }
            i++;
        }
        if(prev == slow){
            return head.next;
        }else {
            prev.next = slow.next;
        }
        return head;

    }

    @Test
    public void test(){
        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(6);
        ListNode m4 = new ListNode(5);
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;

        System.out.println(JSON.toJSONString(removeNthFromEnd(m1, 4)));
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
