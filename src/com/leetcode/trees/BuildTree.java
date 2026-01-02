package com.leetcode.trees;

import java.io.IO;

public class BuildTree {
    static int index= -1;
    private static class Node{
        int data;
        Node leftNode;
        Node rightNode;
        public Node(int data){
            this.data = data;
//            this.leftNode = null;
//            this.rightNode = null;
        }
    }
    public static Node buildBinaryTree(int[] nodes){
         index++;
        if(nodes[index] == -1)
            return null;
        Node node = new Node(nodes[index]);
        node.leftNode = buildBinaryTree(nodes);
        node.rightNode = buildBinaryTree(nodes);
        return node;
    }

    static void main() {
      Node node =  BuildTree.buildBinaryTree(new int[]{1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1});
        IO.println("Node Data "+ node.data);
    }
}
