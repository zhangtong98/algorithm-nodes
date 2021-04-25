package com.zhang.leetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 计算给定二叉树的所有左叶子之和。
 示例：
    3
   / \
  9  20
    /  \
   15   7
 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(sumOfLeftLeaves(t1));
    }

    private static int sum = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root != null){
            if (root.left != null && root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
        }
        return sum;
    }

    public static int sumOfLeftLeavesV2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left != null){
                queue.offer(node.left);
                if (node.left.left == null && node.left.right == null) sum += node.left.val;
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return sum;
    }
}
