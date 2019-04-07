package com.programmergirl.binarytree;

public class PrintAncestors {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);

        node2.setLeft(node3);
        node2.setRight(node4);

        node3.setLeft(node5);
        node5.setLeft(node6);

        root.setLeft(node1);
        root.setRight(node2);

        printAncestor(root, 7);

    }

    public static boolean printAncestor(TreeNode node, int number) {
        if(node == null) {
            return false;
        }
        if(node.getData() == number) {
            return true;
        }
        if(printAncestor(node.getLeft(), number) || printAncestor(node.getRight(), number)) {
            System.out.print(node.getData() + " ");
            return true;
        }
        return false;
    }
}
