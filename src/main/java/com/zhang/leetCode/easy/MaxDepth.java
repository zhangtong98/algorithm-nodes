package com.zhang.leetCode.easy;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
     给定一个二叉树，找出其最大深度。
     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     说明: 叶子节点是指没有子节点的节点。
     示例：
     给定二叉树 [3,9,20,null,null,15,7]，
      3
     / \
    9  20
      /  \
     15   7
     返回它的最大深度 3 。
 */
public class MaxDepth {

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
        System.out.println(maxDepthV3(p1));
    }

    public static int maxDepthV3(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        //当层节点个数
        int preCount = 1;
        int pCount = 0;
        //层数
        int level = 0;
        while (!q.isEmpty()){
            TreeNode mark = q.poll();
            preCount--;
            if (mark.left != null){
                q.offer(mark.left);
                pCount++;
            }
            if (mark.right != null){
                q.offer(mark.right);
                pCount++;
            }
            if (preCount == 0){
                preCount = pCount;
                pCount = 0;
                level++;
            }
        }
        return level;
    }

    public static int maxDepthV2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<Pair<TreeNode, Integer>>();
        if (root != null) q.add(new Pair<TreeNode, Integer>(root, 1));

        int depth = 0;
        while (!q.isEmpty()){
            Pair<TreeNode, Integer> cur = q.poll();
            root = cur.getKey();
            int cur_depth = cur.getValue();
            if (root != null){
                depth = Math.max(depth, cur_depth);
                q.add(new Pair<TreeNode, Integer>(root.left, cur_depth+1));
                q.add(new Pair<TreeNode, Integer>(root.right, cur_depth+1));
            }
        }
        return depth;
    }

    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
