package com.zhang.leetCode.easy;

/**
     删除链表中等于给定值 val 的所有节点。
     示例:
     输入: 1->2->6->3->4->5->6, val = 6
     输出: 1->2->3->4->5
 */
public class RemoveElements {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(5);
        ListNode l7 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode re = removeElementsV3(l1,5);
        while (re != null){
            System.out.println(re.val);
            re = re.next;
        }
    }

    public static ListNode removeElementsV3(ListNode head, int val) {
        if (head == null)return null;
        head.next = removeElementsV3(head.next,val);
        if (head.val == val){
            return head.next;
        }
        else return head;
    }

    public static ListNode removeElementsV2(ListNode head, int val) {
        while (head != null && head.val == val){
            head = head.next;
        }
        ListNode prev = head;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static ListNode removeElements(ListNode head, int val) {
        /*定义一个哑节点*/
        ListNode _head = new ListNode(0);
        /*定义一个节点赋值为哑节点*/
        _head.next = head;
        /*定义一个遍历节点*/
        ListNode iter = _head;
         /*当下个节点不为null时继续遍历*/
        while (iter.next != null){
            ListNode curr = iter.next;
            /*如果下个节点等于val值，则下个节点替换为下下个节点并立即进行下次迭代*/
            if (curr.val == val){
                iter.next = curr.next;
                continue;
            }
            /*如果不相等，迭代节点向后移动一个*/
            iter = iter.next;
        }
        return _head.next;
    }
}
