package com.lmk.arraybinarytree;

public class ArrayBinaryTree {
    private int[] root;

    public ArrayBinaryTree() {
    }

    public ArrayBinaryTree(int[] root) {
        this.root = root;
    }

    public int[] getRoot() {
        return root;
    }

    public void setRoot(int[] root) {
        this.root = root;
    }

    public void before(){
        before(0);
    }

    /**
     * 先序遍历
     * @param index
     */
    public void before(int index) {
        if(index>this.root.length-1){
            return;
        }
        System.out.println(this.root[index]);

        if(2*index+1 <this.root.length){
            before(2*index +1);
        }
        if(2*index +2<this.root.length){
            before(2*index +2);
        }
    }

    public void middle(){
        middle(0);
    }
    /**
     * 中序遍历
     * @param index
     */
    public void middle(int index){
        if(index>this.root.length-1){
            return;
        }
        if(2*index +1<this.root.length){
            middle(2*index+1);
        }
        System.out.println(this.root[index]);
        if(2*index +2<this.root.length){
            middle(2*index+2);
        }
    }

    public void after(){
        after(0);
    }
    /**
     * 后序遍历
     * @param index
     */
     public void after(int index){
        if(index>this.root.length-1){
            return;
        }
        if(2*index+1<this.root.length){
            after(2*index+1);
        }
        if(2*index+2<this.root.length){
            after(2*index+2);
        }
         System.out.println(this.root[index]);
     }
}
