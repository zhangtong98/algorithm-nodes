package com.zhang.leetCode.easy;

import java.util.*;

/**
     给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     例如：
     给定二叉树 [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
     返回其自底向上的层次遍历为：
     [
     [15,7],
     [9,20],
     [3]
     ]
 */
public class LevelOrderBottom {

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
        p3.left = p6;
        p3.right = p7;

        List<List<Integer>> l = levelOrderBottomV2(p1);
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.println(l.get(i).get(j));
            }
        }

    }

    public static List<List<Integer>> levelOrderBottomV2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        levelOrderBottomHelp(root, 0, res);
        Collections.reverse(res);
        return res;
    }
    private static void levelOrderBottomHelp(TreeNode head, int level, List<List<Integer>> res){
        if (head == null) return;
        if (level+1 > res.size()) res.add(new ArrayList<Integer>());
        res.get(level).add(head.val);
        if (head.left != null) levelOrderBottomHelp(head.left, level+1, res);
        if (head.right != null) levelOrderBottomHelp(head.right, level+1, res);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> levels = new ArrayList<Integer>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode t = q.poll();
                levels.add(t.val);
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
            res.add(0,levels);
        }
        return res;
    }
}
