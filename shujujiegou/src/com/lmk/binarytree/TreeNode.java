package com.lmk.binarytree;

public class TreeNode {

    private int value;

    private TreeNode leftNode;

    private TreeNode rightNode;

    public TreeNode(){

    }

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode beforeSearch(int value) {
        if(this.value == value){
            return this;
        }
        if(this.leftNode !=null){
           TreeNode temp = leftNode.beforeSearch(value);
            if(temp!=null){
                return temp;
            }

        }
        if(this.rightNode !=null) {
            TreeNode temp =rightNode.beforeSearch(value);
            if(temp !=null){
                return temp;
            }

        }
        return null;
    }

    public TreeNode middleSearch(int value) {

        if(leftNode !=null){
            TreeNode temp = leftNode.middleSearch(value);
            if(temp !=null){
                return temp;
            }
        }
        if(this.value == value ){
            return this;
        }
        if(rightNode !=null){
            TreeNode temp = rightNode.middleSearch(value);
            if(temp !=null){
                return temp;
            }
        }
        return null;
    }

    /**
     * 后序查找
     * @param value
     * @return
     */
    public TreeNode afterSearch(int value) {
        TreeNode temp =null;
        if(this.leftNode !=null){
            temp =leftNode.afterSearch(value);
            if(temp !=null){
                return temp;
            }
        }

        if(this.rightNode !=null){
            temp = rightNode.afterSearch(value);
            if(temp !=null){
                return temp;
            }
        }
        if(this.value == value){
            return this;
        }
        return temp;
    }

    public void delete(int i) {


        if(leftNode!=null&&leftNode.getValue()==i){
            leftNode =null;
        }
        if(rightNode!=null&&rightNode.getValue()==i){
            rightNode=null;
        }
        if(leftNode!=null){
            leftNode.delete(i);
        }
        if(rightNode !=null){
            rightNode.delete(i);
        }
    }

    public void middle() {

        System.out.println(this.value);

        if(this.leftNode!=null){
            leftNode.middle();
        }
        if(this.rightNode!=null){
            rightNode.middle();
        }
    }
}
