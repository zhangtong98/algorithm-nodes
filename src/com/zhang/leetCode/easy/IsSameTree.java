package com.zhang.leetCode.easy;

/**
     给定两个二叉树，编写一个函数来检验它们是否相同。
     如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     示例 1:
     输入:       1         1
                 / \       / \
                 2   3     2   3
     [1,2,3],   [1,2,3]
     输出: true
     示例 2:
     输入:      1          1
                 /           \
                 2             2
     [1,2],     [1,null,2]
     输出: false
     示例 3:
     输入:       1         1
                 / \       / \
                 2   1     1   2
     [1,2,1],   [1,1,2]
     输出: false
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(0);
        TreeNode p2 = new TreeNode(1);
        TreeNode p3 = new TreeNode(2);
        TreeNode q1 = new TreeNode(0);
        TreeNode q2 = new TreeNode(1);
        TreeNode q3 = new TreeNode(2);
        p1.left = p2;
        p1.right = p3;
        q1.left = q2;
        q1.right = q3;
        System.out.println(isSameTreeV2(p1,q1));
    }

    public static boolean isSameTreeV2(TreeNode p, TreeNode q) {
        return p == null && q == null || p != null && q != null && p.val == q.val
                && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p != null && q != null && p.val == q.val)
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else
            return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

