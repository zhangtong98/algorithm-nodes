package com.zhang.leetCode.easy;

import javafx.util.Pair;

import java.util.LinkedList;

/**
     给定一个二叉树，找出其最小深度。
     最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     说明: 叶子节点是指没有子节点的节点。
     示例:
     给定二叉树 [3,9,20,null,null,15,7],
      3
     / \
    9  20
      /  \
     15   7
     返回它的最小深度  2.
 */
public class MinDepth {

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
        System.out.println(minDepthV5(p1));
    }

    /**
     * 深度优先搜索方法的缺陷是所有节点都必须访问到，以保证能够找到最小深度。因此复杂度是 O(N)O(N)。
     一个优化的方法是利用宽度优先搜索，我们按照树的层次去迭代，第一个访问到的叶子就是最小深度的节点，这样就不要遍历所有的节点了
     */
    public static int minDepthV5(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<Pair<TreeNode, Integer>>();
        if (root == null) {
            return 0;
        }else {
            stack.offer(new Pair<TreeNode, Integer>(root, 1));
        }
        int min_depth = 0;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.poll();
            root = p.getKey();
            min_depth = p.getValue();
            if (root.left == null && root.right == null) break;
            if (root.left != null) stack.offer(new Pair<TreeNode, Integer>(root.left, min_depth+1));
            if (root.right != null) stack.offer(new Pair<TreeNode, Integer>(root.right, min_depth+1));
        }
        return min_depth;
    }
    /**
        我们可以利用栈将上述解法中的递归变成迭代。
        想法是对于每个节点，按照深度优先搜索的策略访问，同时在访问到叶子节点时更新最小深度。
        我们从一个包含根节点的栈开始，当前深度为 1 。
        然后开始迭代：弹出当前栈顶元素，将它的孩子节点压入栈中。当遇到叶子节点时更新最小深度。
     */
    public static int minDepthV4(TreeNode root) {
        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<Pair<TreeNode, Integer>>();
        if (root == null) {
            return 0;
        }else {
            stack.offer(new Pair<TreeNode, Integer>(root, 1));
        }
        int min_depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.pollLast();
            root = p.getKey();
            int c_depth = p.getValue();
            if (root.left == null && root.right == null) min_depth = Math.min(c_depth, min_depth);
            if (root.left != null) stack.offer(new Pair<TreeNode, Integer>(root.left, c_depth+1));
            if (root.right != null) stack.offer(new Pair<TreeNode, Integer>(root.right, c_depth+1));
        }
        return min_depth;
    }

    public static int minDepthV3(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) min_depth = Math.min(minDepthV3(root.left), min_depth);
        if (root.right != null) min_depth = Math.min(minDepthV3(root.right), min_depth);
        return 1 + min_depth;
    }

    public static int minDepthV2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right != null) return 1 + minDepthV2(root.right);
        if (root.right == null && root.left != null) return 1 + minDepthV2(root.left);
        return 1 + Math.min(minDepthV2(root.left), minDepthV2(root.right));
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left+right == left || left+right == right) return left+right+1;
        return Math.min(left+1, right+1);
    }
}
