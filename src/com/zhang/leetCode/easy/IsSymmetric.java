package com.zhang.leetCode.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
     给定一个二叉树，检查它是否是镜像对称的。
     例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
      1
     / \
    2   2
   / \ / \
  3  4 4  3
     但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
      1
     / \
    2   2
    \   \
    3    3
     说明:
     如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {
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
        System.out.println(isSymmetricV3(p1));
    }

    public static boolean isSymmetricV3(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()){
            TreeNode l = q.poll();
            TreeNode r = q.poll();
            if (l == null && r == null) continue;
            if (l == null || r == null || l.val != r.val) return false;
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }
        return true;
    }


    public static boolean isSymmetricV2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> lStack = new Stack<TreeNode>();
        Stack<TreeNode> rStack = new Stack<TreeNode>();
        TreeNode l = root.left, r = root.right;
        while (l != null || r != null || lStack.size() != 0 || rStack.size() != 0){
            while (l != null && r != null){
                lStack.push(l);
                l = l.left;
                rStack.push(r);
                r = r.right;
            }
            if (l != null || r != null) return false;
            l = lStack.pop();
            r = rStack.pop();
            if (l.val != r.val) return false;
            l = l.right;
            r = r.left;
        }
        return true;
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricUtil(root.left,root.right);
    }

    private static boolean isSymmetricUtil(TreeNode left, TreeNode right){
        return left == null && right == null || left != null && right != null && left.val == right.val
                && isSymmetricUtil(left.left, right.right) && isSymmetricUtil(left.right, right.left);
    }
}
