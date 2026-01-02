package com.leetcode.trees.dfs;

import java.io.IO;

public class PreOrderInOrderPostOrderDFSTree {

    private static class Node{
        private int data;
        private Node leftTree;
        private Node rightTree;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void preOrder(Node rootNode){
        if(rootNode == null){
            return;
        }
        IO.print(rootNode.data+" ");
        preOrder(rootNode.leftTree);
        preOrder(rootNode.rightTree);
    }
    public static void inOrder(Node rootNode){
        if(rootNode == null){
            return;
        }
        inOrder(rootNode.leftTree);
        IO.print(rootNode.data+" ");
        inOrder(rootNode.rightTree);

    }
    public static void postOrder(Node rootNode){
        if(rootNode == null)
            return;
        postOrder(rootNode.leftTree);
        postOrder(rootNode.rightTree);
        IO.print(rootNode.data+" ");
    }

    static void main() {
        Node root = new Node(1);
        root.leftTree= new Node(2);
        root.leftTree.leftTree= new Node(4);
        root.rightTree= new Node(3);
        root.rightTree.rightTree= new Node(5);
        IO.print("Pre Order Travesal  ");
        preOrder(root);
        IO.println();
        IO.print("In Order Travesal ");
        inOrder(root);
        IO.println();
        IO.print("POSt Order Travesal ");
        postOrder(root);
    }
}
