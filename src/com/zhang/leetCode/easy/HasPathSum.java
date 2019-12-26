package com.zhang.leetCode.easy;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 说明: 叶子节点是指没有子节点的节点。
 示例: 
 给定如下二叉树，以及目标和 sum = 22，
       5
      / \
     4   8
    /   / \
   11  13  4
  /  \      \
 7    2      1
 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class HasPathSum {


    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(5);
        TreeNode p2 = new TreeNode(4);
        TreeNode p3 = new TreeNode(8);
        TreeNode p4 = new TreeNode(11);
        TreeNode p5 = new TreeNode(13);
        TreeNode p6 = new TreeNode(4);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(2);
        TreeNode p9 = new TreeNode(1);
        p1.left = p2;
        p1.right = p3;
        p2.right = p4;
        p4.left = p7;
        p4.right = p8;
        p3.left = p5;
        p3.right = p6;
        p6.right = p9;
        System.out.println(hasPathSumV3(p1,13));
    }

    public static boolean hasPathSumV3(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        return hasPathSumV3(root.left, sum) || hasPathSumV3(root.right, sum);
    }

    public static boolean hasPathSumV2(TreeNode root, int sum) {
        if (root == null) return false;
        boolean res = false;
        if (sum == root.val && root.left == null && root.right == null) res = true;
        if (root.left != null) res = hasPathSumV2(root.left, sum-root.val);
        if (res) return res;
        if (root.right != null) res = hasPathSumV2(root.right, sum-root.val);
        if (res) return res;
        return res;
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<Pair<TreeNode, Integer>>();
        stack.offer(new Pair<TreeNode, Integer>(root, root.val));
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.poll();
            root = p.getKey();
            int num = p.getValue();
            if (root.left == null && root.right == null && num == sum) return true;
            if (root.left != null) stack.offer(new Pair<TreeNode, Integer>(root.left, num+root.left.val));
            if (root.right != null) stack.offer(new Pair<TreeNode, Integer>(root.right, num+root.right.val));
        }
        return false;
    }
}
