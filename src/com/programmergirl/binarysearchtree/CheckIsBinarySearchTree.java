package com.programmergirl.binarysearchtree;

import com.programmergirl.binarytree.TreeNode;

public class CheckIsBinarySearchTree {

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

        System.out.println(isBST(root));

        root = new TreeNode(2);
        node1 = new TreeNode(1);
        node2 = new TreeNode(4);
        node3 = new TreeNode(3);
        node4 = new TreeNode(8);

        node2.setLeft(node3);
        node1.setRight(node4);
        root.setLeft(node1);
        root.setRight(node2);

        System.out.println(isBST(root));


    }

    public static boolean isBST(TreeNode node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.getData() < min || node.getData() > max) {
            return false;
        }
        return isBST(node.getLeft(), min, node.getData() - 1) && isBST(node.getRight(), node.getData() + 1, max);
    }
}
