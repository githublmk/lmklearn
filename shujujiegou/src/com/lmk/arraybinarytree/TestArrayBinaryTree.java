package com.lmk.arraybinarytree;

public class TestArrayBinaryTree {

    /**
     * 顺序存储二叉树
     * 左子子节点  2n +1
     * 右子节点   2n +2
     * 父节点  （n-1）/2
     *          1
     *        2   3
     *      4  5  6 7
      * @param args
     */

    public static void main(String[] args) {
        ArrayBinaryTree tree =new ArrayBinaryTree();
        int[] array =new int[]{1,2,3,4,5,6,7};
        tree.setRoot(array);
        System.out.println("------先序--------");
        tree.before();
        System.out.println("------中序-------");
        tree.middle();
        System.out.println("-------后序--------");
        tree.after();
    }
}
