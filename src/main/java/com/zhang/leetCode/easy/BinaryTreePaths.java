package com.zhang.leetCode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
     给定一个二叉树，返回所有从根节点到叶子节点的路径。
     说明: 叶子节点是指没有子节点的节点。
     示例:
     输入:
       1
     /   \
    2     3
     \
      5
     输出: ["1->2->5", "1->3"]
     解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        for (String s : binaryTreePathsV2(t1)) {
            System.out.println(s);
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root,"",paths);
        return paths;
    }

    private static void constructPaths(TreeNode root, String path, List<String> paths){
        if (root != null){
            path += Integer.toString(root.val);
            if (root.left == null && root.right == null) {
                paths.add(path);
            }else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }

    public static List<String> binaryTreePathsV2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        LinkedList<TreeNode> nodeList = new LinkedList<>();
        LinkedList<String> pathList = new LinkedList<>();
        nodeList.add(root);
        pathList.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!nodeList.isEmpty()){
            node = nodeList.pollLast();
            path = pathList.pollLast();
            if (node.left == null && node.right == null){
                paths.add(path);
            }
            if (node.left != null){
                nodeList.add(node.left);
                pathList.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null){
                nodeList.add(node.right);
                pathList.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }
}
