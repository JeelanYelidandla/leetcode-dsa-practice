package com.leetcode.trees.bfs;

import java.io.IO;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBFSTree {

    private static class Node {
        int data;
        Node leftNode;
        Node rightNode;
        public Node(int data) {
            this.data = data;
        }
    }

    private static void levelOrderTravesal(Node node){
        if(node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        queue.add(null);
        while(!queue.isEmpty()){
          Node currentNode =  queue.remove();
          if(currentNode == null){
              IO.println();
                if(queue.isEmpty()){
                    break;
                }else {
                    queue.add(null);
                }
          }else{
              IO.print(currentNode.data+ " ");
              if( currentNode.leftNode!=null){
                 queue.add(currentNode.leftNode);
              }if(currentNode.rightNode!=null){
                  queue.add(currentNode.rightNode);
              }
          }
        }

    }
    static void main() {
        Node rootNode = new Node(1);
        rootNode.leftNode = new Node(2);
        rootNode.rightNode = new Node(3);
        rootNode.leftNode.leftNode = new Node(4);
        rootNode.leftNode.rightNode = new Node(5);
        rootNode.rightNode.leftNode = new Node(6);
        rootNode.rightNode.rightNode = new Node(7);
        IO.println("BFS Level Order Traversal ");
        LevelOrderBFSTree.levelOrderTravesal(rootNode);
    }

}
