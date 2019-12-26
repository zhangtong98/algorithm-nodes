package com.zhang.leetCode.easy;

import java.util.*;

/**
 * 二叉树：
    前序遍历首先访问根节点，然后遍历左子树，最后遍历右子树。
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(9);
        TreeNode p3 = new TreeNode(20);
        TreeNode p4 = new TreeNode(15);
        TreeNode p5 = new TreeNode(7);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(8);
        p1.left = p2;
        p2.left = p6;
        p2.right = p7;
        p1.right = p3;
        p3.left = p4;
        p3.right = p5;
        p1 = null;
        List<Integer> l = preorderTraversalV2(p1);
        for (Integer i: l) {
            System.out.println(i);
        }
    }

    private static List<Integer> res = new ArrayList<Integer>();
    public static List<Integer> preorderTraversalV2(TreeNode root) {
        preorderTraversalHelp(root);
        return res;
    }
    private static void preorderTraversalHelp(TreeNode root) {
        if (root != null){
            res.add(root.val);
            preorderTraversalHelp(root.left);
            preorderTraversalHelp(root.right);
        }
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop().right;
            }
        }
        return res;
    }
}
