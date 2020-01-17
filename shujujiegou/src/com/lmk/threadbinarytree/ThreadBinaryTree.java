package com.lmk.threadbinarytree;



/**
 * 线索二叉树
 *
 */
public class ThreadBinaryTree {

    TreeNode root;
    //存储前一个结点
    TreeNode preNode;

    public void threadBinaryTree(){
        if(root!=null){
            threadBinaryTree(root);
        }

    }
    //中序线索二叉树
    public void threadBinaryTree( TreeNode node){
        //左节点
        if(node.leftNode!=null){
            threadBinaryTree(node.leftNode);
        }

        //根
        //左节点为空，指向前一个节点，flag变为1
        if(node.leftNode==null){
            node.leftNode = preNode;
            node.leftFlag=1;
        }
        //如果前一个节点为空，使其指向本节点（即右节点指向后一个节点）
         if(preNode!=null&&preNode.rightNode==null){
             preNode.rightNode=node;
             preNode.rightFlag=1;
         }

        preNode = node;
        //右节点
        if(node.rightNode!=null){
            threadBinaryTree(node.rightNode);
        }
    }






}
