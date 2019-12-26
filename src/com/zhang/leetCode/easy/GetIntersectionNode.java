package com.zhang.leetCode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 编写一个程序，找到两个单链表相交的起始节点。
 如下面的两个链表：
 在节点 c1 开始相交。
 示例 1：
 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 输出：Reference of the node with value = 8
 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 示例 2：
 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 输出：Reference of the node with value = 2
 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 示例 3：
 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 输出：null
 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 解释：这两个链表不相交，因此返回 null。
 注意：
 如果两个链表没有交点，返回 null.
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(0);
        ListNode l5 = new ListNode(1);
        ListNode l6 = new ListNode(8);
        ListNode l7 = new ListNode(4);
        ListNode l8 = new ListNode(5);
        l1.next = l2;
        l2.next = l6;
        l6.next = l7;
        l7.next = l8;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        System.out.println(getIntersectionNodeV4(l1, l3).val);
    }

    public static ListNode getIntersectionNodeV4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode _headA = headA;
        ListNode _headB = headB;
        while (_headA != _headB){
            _headA = _headA.next;
            _headB = _headB.next;
            if (_headA == null && _headB == null) return null;
            if (_headA == null) _headA = headB;
            if (_headB == null) _headB = headA;
        }
        return _headA;
    }

    public static ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode _headA = new ListNode(0);
        _headA.next = headA;
        ListNode _headB = new ListNode(0);
        _headB.next = headB;
        while (headA != null || headB != null){
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
            if (headA == null && headB == null) break;
            if (headA == null) headA = _headB.next;
            if (headB == null) headB = _headA.next;
        }
        return null;
    }

    public static ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Set<ListNode> s = new HashSet<>();
        while (headA != null){
            s.add(headA);
            headA = headA.next;
        }
        while (headB != null){
            if (!s.add(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode _headB = new ListNode(0);
        _headB.next = headB;
        while (headA != null) {
            ListNode res = headA;
            while (headB != null){
                if (res == headB) return res;
                headB = headB.next;
            }
            headA = headA.next;
            headB = _headB.next;
        }
        return null;
    }
}
