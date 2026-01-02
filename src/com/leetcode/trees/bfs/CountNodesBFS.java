package com.leetcode.trees.bfs;

import java.io.IO;

public class CountNodesBFS {

    private static class Node {
        int data;
        Node leftNode;
        Node rightNode;

        public Node(int data) {
            this.data = data;
        }
    }

    private static int countNodesInTree(Node rootNode){
        if(rootNode == null)
            return 0;
        int leftNodeCount =  countNodesInTree(rootNode.leftNode);
        int rightNodeCount =  countNodesInTree(rootNode.rightNode);
        return leftNodeCount+ 1+rightNodeCount;
    }

    static void main() {

        Node node = new Node(1);
        node.leftNode = new Node(2);
        node.rightNode = new Node(3);
        node.leftNode.leftNode = new Node(4);
        node.leftNode.rightNode = new Node(5);
//        node.leftNode.rightNode.leftNode = new Node(6);
//        node.leftNode.rightNode.rightNode = new Node(7);
        IO.println("No of Nodes in tree ");
        IO.println(CountNodesBFS.countNodesInTree(node));
    }
}
