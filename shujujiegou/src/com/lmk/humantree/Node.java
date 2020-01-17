package com.lmk.humantree;

public class Node implements Comparable {

    //值
    private int value;

    //左节点
    private Node leftNode;

    //右节点
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int compareTo(Object o) {
        return this.value - ((Node)o).value;
    }

    public void before(Node node) {
        if(node!=null){
            System.out.println(node.getValue());

            if(node.leftNode!=null){
                before(node.leftNode);
            }

            if(node.rightNode!=null){
                before(node.rightNode);
            }
        }

    }
}
