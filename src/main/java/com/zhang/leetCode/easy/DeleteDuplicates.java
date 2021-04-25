package com.zhang.leetCode.easy;

/**
     给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     示例 1:
     输入: 1->1->2
     输出: 1->2
     示例 2:
     输入: 1->1->2->3->3
     输出: 1->2->3
 */
public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode _head = head;
        while (_head.next != null){
            if (_head.val == _head.next.val)
                _head.next = _head.next.next;
            else
                _head = _head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l1.val = 1;
        l2.val = 1;
        l3.val = 2;
        l4.val = 3;
        l5.val = 3;
        l6.val = 3;
        ListNode head = deleteDuplicates(l1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }



}




