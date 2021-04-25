package com.zhang.leetCode.easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
     给定一个链表，判断链表中是否有环。
     为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
     示例 1：
     输入：head = [3,2,0,-4], pos = 1
     输出：true
     解释：链表中有一个环，其尾部连接到第二个节点。
     示例 2：
     输入：head = [1,2], pos = 0
     输出：true
     解释：链表中有一个环，其尾部连接到第一个节点。
     示例 3：
     输入：head = [1], pos = -1
     输出：false
     解释：链表中没有环。
     进阶：
     你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class HasCycle {

    public static void main(String[] args) {
        ListNode02 l1 = new ListNode02(3);
        ListNode02 l2 = new ListNode02(2);
        ListNode02 l3 = new ListNode02(0);
        ListNode02 l4 = new ListNode02(-4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(hasCycleV4(l1));
    }

    public static boolean hasCycleV4(ListNode02 head) {
        while (head != null){
            if (head == head.next) return true;
            if (head.next != null) head.next = head.next.next;
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycleV3(ListNode02 head) {
        if (head == null || head.next == null) return false;

        ListNode02 slow = head;
        ListNode02 fast = head.next;
        while (slow != fast){
            if (slow == null || fast == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static boolean hasCycleV2(ListNode02 head) {
        Set<ListNode02> s = new HashSet<>();
        while (head != null){
            if (!s.add(head)){
                return true;
            }
            if (head.next == null) break;
            head = head.next;
        }
        return false;
    }
    public static boolean hasCycle(ListNode02 head) {
        if (head == null) return false;

        Set<ListNode02> s = new HashSet<>();
        boolean res = false;
        while (!res || head != null){
            if (!s.add(head)){
                res = true;
                break;
            }
            if (head.next == null) break;
            head = head.next;
        }
        return res;
    }
}

 class ListNode02 {
     int val;
     ListNode02 next;
     ListNode02(int x) {
         val = x;
         next = null;
    }
}
