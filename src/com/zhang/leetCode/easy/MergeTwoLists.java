package com.zhang.leetCode.easy;

/**
     将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     示例：
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l1.val = 1;
        l2.val = 2;
        l3.val = 4;

        ListNode l2_1 = new ListNode(0);
        ListNode l2_2 = new ListNode(1);
        ListNode l2_3 = new ListNode(2);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        l2_1.val = 1;
        l2_2.val = 3;
        l2_3.val = 4;

        ListNode result = mergeTwoLists(l1,l2_1);
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
        System.out.println(result.next.next.next.val);
        System.out.println(result.next.next.next.next.val);
        System.out.println(result.next.next.next.next.next.val);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        //输入：1->2->4, 1->3->4
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }else {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }
        }

        cur.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
