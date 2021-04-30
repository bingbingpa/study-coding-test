package me.bingbingpa.inflearn.practice._04_graph;


import java.util.Stack;

public class MaximumDepthOfBinaryTreeDFS {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTreeDFS dfs = new MaximumDepthOfBinaryTreeDFS();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(6);

        System.out.println("result ===================== " + dfs.solution(node));
    }

    /**
     * TODO 주어진 이진트리의 높이를 구하라(DFS).
     */
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        valueStack.push(1);
        int max = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int count = valueStack.pop();
            max = Math.max(max, count);
            if (node.left != null) {
                stack.push(node.left);
                valueStack.push(1 + count);
            }

            if (node.right != null) {
                stack.push(node.right);
                valueStack.push(1 + count);
            }
        }

        return max;
    }

    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
