package me.bingbingpa.inflearn.practice._04_graph;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTreeBFS {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeBFS bfs = new MaximumDepthOfBinaryTreeBFS();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        System.out.println("result ================= " + bfs.solution(tree));
    }

    /**
     * TODO 주어진 이진트리의 높이를 구하라(BFS).
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }

        return count;
    }

    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
