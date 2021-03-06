package com.programmergirl.binarytree;

public class MaxDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(8);

        node2.setLeft(node3);
        node2.setRight(node4);

        root.setLeft(node1);
        root.setRight(node2);

       System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode node) {
        if(node == null) {
            return -1;
        }
        return 1 + Math.max(maxDepth(node.getLeft()), maxDepth(node.getRight()));
    }
}
