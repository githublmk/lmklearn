package com.lmk.binarysorttree;

/**
 * 二叉排序树
 */
public class Node {


    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void add(Node node) {

        if(node==null){
            return;
        }
        //比当前值大放右边
        if(node.getValue()>this.value){
            //当前节点右子树为空，直接赋值给右子树
            if(this.right==null){
                this.right = node;
            }else{
                //右子树不为空，递归
                this.right.add(node);
            }
        }
        //小于等于当前值
        if(node.getValue()<=this.value){
            //当前节点左子树为空，直接赋值给左子树
            if(this.left==null){
                this.left=node;
            }else {
                //递归
                this.left.add(node);
            }

        }
    }
}
