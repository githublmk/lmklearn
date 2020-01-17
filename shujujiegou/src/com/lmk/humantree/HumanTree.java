package com.lmk.humantree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HumanTree {

    public static void main(String[] args) {
        int[] arr = new int[]{3,7,4,9,2,9,19};
        Node humantree = humantree(arr);
        System.out.println(humantree);
        before(humantree);
    }

    public static Node humantree(int[] arr){
        //生成单个节点的二叉树，并放在集合中
        List<Node> list =new ArrayList<>();

        for(int value:arr){
            list.add(new Node(value));
        }
        //当集合中只有一个树时，他就是最优二叉树
        while(list.size()>1){
            System.out.println(list.size());
            //排序
            list.sort(Node::compareTo);
            //去除最小的两个节点 最小的为左节点
            Node left = list.get(0);
            Node right = list.get(1);
            //创建一个新的二叉树
            Node newNode = new Node(left.getValue()+right.getValue());
            newNode.setLeftNode(left);
            newNode.setRightNode(right);
            //移除两个最小的节点
            list.remove(0);
            list.remove(0);
            //将新树添加到集合中
            list.add(newNode);
        }
        return list.get(0);
    }

    public static void before(Node node){
        node.before(node);
    }
}
