package com.lmk.threadbinarytree;

public class TestThreadBinaryTree {
    public static void main(String[] args) {
        ThreadBinaryTree threadBinaryTree =new ThreadBinaryTree();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        threadBinaryTree.root = node1;
        node1.leftNode=node2;
        node1.rightNode = node3;
        node2.leftNode = node4;
        node2.rightNode = node5;
        node3.leftNode  =node6;
        node3.rightNode = node7;
        threadBinaryTree.threadBinaryTree();
        System.out.println(node4.rightNode.value);
        System.out.println(node5.leftNode.value);
    }
}
