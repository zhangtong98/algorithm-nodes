package com.zhang.leetCode.easy;


/**
     给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     示例 1:
     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     输出: 6
     解释: 节点 2 和节点 8 的最近公共祖先是 6。
     示例 2:
     输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     输出: 2
     解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     说明:
     所有节点的值都是唯一的。
     p、q 为不同节点且均存在于给定的二叉搜索树中。
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(0);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(9);
        TreeNode t8 = new TreeNode(3);
        TreeNode t9 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t8;
        t5.right = t9;
        t3.right = t7;
        t3.left = t6;
        System.out.println(lowestCommonAncestorV2(t1,t2,t3).val);
    }

    public static TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorV2(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestorV2(root.right, p, q);
        else return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;
        while (node != null){
            int parentVal = node.val;
            if (pVal > parentVal && qVal > parentVal) node = node.right;
            else if (pVal < parentVal && qVal < parentVal) node = node.left;
            else return node;
        }
        return null;
    }
}
