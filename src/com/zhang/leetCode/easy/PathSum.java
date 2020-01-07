package com.zhang.leetCode.easy;

/**
     给定一个二叉树，它的每个结点都存放着一个整数值。
     找出路径和等于给定数值的路径总数。
     路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     示例：
     root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
           10
          /  \
         5   -3
        / \    \
       3   2   11
      / \   \
     3  -2   1
     返回 3。和等于 8 的路径有:
     1.  5 -> 3
     2.  5 -> 2 -> 1
     3.  -3 -> 11
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-2);
        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t3.right = t6;
        t2.left = t4;
        t3.right = t5;
        t4.left = t7;
        t4.right = t8;
        t5.right = t9;
        System.out.println(pathSum(t1, 8));
    }

    public static int pathSum(TreeNode root, int sum) {

    }
}
