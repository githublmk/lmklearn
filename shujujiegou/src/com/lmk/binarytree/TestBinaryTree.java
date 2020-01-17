package com.lmk.binarytree;

public class TestBinaryTree {

    /**
     *
     * @param args
     *                          1
     *                       2    3
     *                    4   5  6  7
     */
    public static void main(String[] args) {



        TreeNode root =new TreeNode(1);
        BinaryTree tree =new BinaryTree(root);

        TreeNode left1 = new TreeNode(2);
        root.setLeftNode(left1);

        TreeNode right1 = new TreeNode(3);
        root.setRightNode(right1);

        TreeNode left21 = new TreeNode(4);
        left1.setLeftNode(left21);

        TreeNode right21 = new TreeNode(5);
        left1.setRightNode(right21);

        TreeNode left22 = new TreeNode(6);
        right1.setLeftNode(left22);

        TreeNode right22 =new TreeNode(7);
        right1.setRightNode(right22);
        System.out.println("------------删除节点-------------");
        tree.delete(1);
        tree.middle();

        System.out.println("------先序--------");
        TreeNode beforeResult = tree.beforeSearch(6);
        if(beforeResult !=null){
            System.out.println(beforeResult.getValue());
        }
        System.out.println(beforeResult);
        System.out.println(left22==beforeResult);
        System.out.println("-----中序--------");
        TreeNode restltMiddle = tree.middleSearch(4);
        System.out.println(restltMiddle!=null?restltMiddle.getValue()+"|"+restltMiddle:restltMiddle);
        System.out.println(left21==restltMiddle);

        System.out.println("----后序---------");
        TreeNode resultAfter = tree.afterSearch(6);
        System.out.println(resultAfter!=null?resultAfter.getValue()+"|"+resultAfter:resultAfter);
        System.out.println(left22==resultAfter);
    }

}
