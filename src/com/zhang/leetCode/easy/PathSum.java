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
        t2.right = t5;
        t4.left = t7;
        t4.right = t8;
        t5.right = t9;
        System.out.println(pathSumV3(t1, 8));
    }

    static int s = 0;
    public static int pathSumV3(TreeNode root, int sum) {
        if (root == null) return 0;
        helperV3(root,sum,new int[1000],0);
        return s;
    }
    public static void helperV3(TreeNode node, int sum, int[] array, int p){
        int temp = 0;
        array[p] = node.val;
        for (int i = p; i >= 0; i--) {
            temp += array[i];
            if (temp == sum) s++;
        }
        array[p] = node.val;
        if (node.left != null) helperV3(node.left, sum, array, p+1);
        if (node.right != null) helperV3(node.right, sum, array, p+1);
    }

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root,sum,new int[1000],0);
    }
    public static int helper(TreeNode node, int sum, int[] array, int p){
        if (node == null) return 0;
        int temp = node.val;
        int n = node.val == sum ? 1 : 0;
        for (int i = p-1; i >= 0; i--) {
            temp += array[i];
            if (temp == sum) n++;
        }
        array[p] = node.val;
        int left = helper(node.left, sum, array, p+1);
        int right = helper(node.right, sum, array, p+1);
        return n+left+right;
    }

    public static int pathSumV2(TreeNode root, int sum) {
        if (root == null) return 0;
        return paths(root, sum)+ pathSumV2(root.left, sum)+ pathSumV2(root.right, sum);
    }

    private static int paths(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res += 1;

        res += paths(root.left, sum - root.val);
        res += paths(root.right, sum - root.val);

        return res;
    }

}
