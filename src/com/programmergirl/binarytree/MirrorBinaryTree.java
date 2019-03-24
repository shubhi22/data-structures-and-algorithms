package com.programmergirl.binarytree;

public class MirrorBinaryTree {

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

        root.traverseInorder();
        mirror(root).traverseInorder();
    }

    public static TreeNode mirror(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = mirror(node.getLeft());
        TreeNode right = mirror(node.getRight());
        //Swap left and right
        node.setLeft(right);
        node.setRight(left);
        return node;
    }
}
