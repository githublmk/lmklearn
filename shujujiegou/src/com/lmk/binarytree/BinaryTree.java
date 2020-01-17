package com.lmk.binarytree;

public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){}

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    //先序查找
    public TreeNode beforeSearch(int value){
       if(this.root ==null){
           return  null;
       }else{
           return this.root.beforeSearch(value);
       }
    }
    /**
     * 中序查找
     */
    public TreeNode middleSearch(int value){
        if(this.root==null){
            return null;
        }else{
           return  this.root.middleSearch(value);
        }

    }

    public TreeNode afterSearch(int value){
        if(this.root == null){
            return null;
        }else {
            return this.root.afterSearch(value);
        }

    }

    /**
     * 删除值为i的节点
     * @param i
     */
    public void delete(int i) {
        /*
        判断根节点的值是否等于i，等于i根节点置空
         */
        if(root !=null&&root.getValue() ==i){
            root =null;
        }else{
            root.delete(i);
        }


    }

    public void middle() {

        if(root==null){
            return;
        }
        root.middle();

    }
}
