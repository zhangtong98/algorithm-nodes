package com.zhang.leetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
     翻转一棵二叉树。
     示例：
     输入：
       4
     /   \
    2     7
   / \   / \
  1   3 6   9
     输出：
       4
     /   \
    7     2
   / \   / \
  9   6 3   1
     备注:
     这个问题是受到 Max Howell 的 原问题 启发的 ：
     谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        TreeNode r = invertTreeV2(t1);
        TreeNode l = r;
    }

    public static TreeNode invertTreeV2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode curr = q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }
}
