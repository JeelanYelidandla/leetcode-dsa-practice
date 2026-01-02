package com.leetcode.trees.dfs;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MaxDepthPostOrderDFSBinaryTree {

    // DFS Recursive Approach
    /*
        1
       / \
      2   3
     / \
    4   5

     */
    public static int maxDepthDFS(TreeNode root) {
//        if(root !=null)
//        IO.println("root " + root.val);
//        if(root !=null && root.left !=null)
//        IO.println("root.lef" + root.left.val);
//        if(root !=null &&  root.right !=null)
//        IO.println("root.right"+root.right.val);
        if (root == null)
            return 0;
        int left = maxDepthDFS(root.left);
//        IO.println("left"+left);
        int right = maxDepthDFS(root.right);
//        IO.println("right"+right);
//        IO.println( 1 + Math.max(left, right)+ "MAX");
        return 1 + Math.max(left, right);

    }

    // BFS Iterative Approach
    public static int maxDepthBFS(TreeNode root) {
        if (root == null)
            return 0;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        // Build the tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Max Depth (DFS): " + maxDepthDFS(root));
        System.out.println("Max Depth (BFS): " + maxDepthBFS(root));
    }
}
