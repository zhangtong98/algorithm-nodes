package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.List;

/**
     请判断一个链表是否为回文链表。
     示例 1:
     输入: 1->2
     输出: false
     示例 2:
     输入: 1->2->2->1
     输出: true
     进阶：
     你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome03 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(isPalindromeV2(l1));
    }

    public static boolean isPalindromeV2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) slow = slow.next;
        while (pre != null && slow != null){
            if (pre.val != slow.val) return false;
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        List<ListNode> listNodes = new ArrayList<>();
        while (head != null){
            listNodes.add(head);
            head = head.next;
        }
        int size = listNodes.size();
        for (int i = 0, j = size - 1; i < size/2; i++, j--) {
            if (listNodes.get(i).val != listNodes.get(j).val){
                return false;
            }
        }
        return true;
    }
}
