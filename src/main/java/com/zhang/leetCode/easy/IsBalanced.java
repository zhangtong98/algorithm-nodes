package com.zhang.leetCode.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
     给定一个二叉树，判断它是否是高度平衡的二叉树。
     本题中，一棵高度平衡二叉树定义为：
     一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
     示例 1:
     给定二叉树 [3,9,20,null,null,15,7]
      3
     / \
    9  20
      /  \
     15   7
     返回 true 。
     示例 2:
     给定二叉树 [1,2,2,3,3,null,null,4,4]
      1
     / \
    2   2
   / \
  3   3
 / \
4   4
     返回 false 。
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(2);
        TreeNode p4 = new TreeNode(3);
        TreeNode p5 = new TreeNode(4);
        TreeNode p6 = new TreeNode(4);
        TreeNode p7 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p4.left = p6;
        p4.right = p7;
        System.out.println(isBalancedV2(p1));
    }

    public static boolean isBalancedV2(TreeNode root) {
        return isBalancedHelpV2(root) != -1;
    }
    private static int isBalancedHelpV2(TreeNode root){
        if (root == null) return 0;
        int left = isBalancedHelpV2(root.left);
        if (left == -1) return -1;
        int right = isBalancedHelpV2(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right)+1 : -1;
    }

    private static boolean flag = true;
    public static boolean isBalanced(TreeNode root) {
        isBalancedHelp(root);
        return flag;
    }
    private static int isBalancedHelp(TreeNode root){
        if (root == null || !flag) return 0;
        int left = isBalancedHelp(root.left);
        int right = isBalancedHelp(root.right);
        if (Math.abs(left - right) > 1) flag = false;
        return Math.max(left, right)+1;
    }
}
