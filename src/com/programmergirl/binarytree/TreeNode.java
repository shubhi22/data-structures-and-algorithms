package com.programmergirl.binarytree;

public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void traverseInorder() {
        inOrder();
        System.out.println();
    }

    private void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.print(this.data + " ");
        if (right != null) {
            right.inOrder();
        }
    }
}
