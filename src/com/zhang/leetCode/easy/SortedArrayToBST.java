package com.zhang.leetCode.easy;

import java.util.List;

/**
     将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     示例:
     给定有序数组: [-10,-3,0,5,9],
     一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     0
    / \
   -3  9
   /   /
 -10  5
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        List<List<Integer>> l = LevelOrderBottom.levelOrderBottom(sortedArrayToBST(arr));
        for (int i = 0; i < l.size(); i++) {
            for (int j = 0; j < l.get(i).size(); j++) {
                System.out.println(l.get(i).get(j));
            }
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelp(0, nums.length, nums);
    }

    private static TreeNode sortedArrayToBSTHelp(int low, int high, int[] nums){
        if (low == high) return null;
        int middle = (low + high) >>> 1;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBSTHelp(low, middle, nums);
        root.right = sortedArrayToBSTHelp(middle+1, high, nums);
        return root;
    }
}
