package com.zhang.leetCode.easy;

import java.util.Stack;

/**
     反转一个单链表。
     示例:
     输入: 1->2->3->4->5->NULL
     输出: 5->4->3->2->1->NULL
     进阶:
     你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode re = reverseListV3(l1);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode reverseListV3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListV3(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    public static ListNode reverseListV2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode _head = stack.pop();
        ListNode curr = _head;
        while (!stack.empty()){
            curr.next = stack.pop();
            curr = curr.next;
            curr.next = null;
        }
        return _head;
    }

}
