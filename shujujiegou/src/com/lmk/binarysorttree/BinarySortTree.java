package com.lmk.binarysorttree;

public class BinarySortTree {

   private Node root;


   public void add(Node node){


       if(this.root==null){
           root = node;
       }else {
           root.add(node);
       }


   }

}
