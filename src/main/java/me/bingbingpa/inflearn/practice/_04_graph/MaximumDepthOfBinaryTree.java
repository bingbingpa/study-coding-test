package me.bingbingpa.inflearn.practice._04_graph;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(5);
        tree.left.right = new TreeNode(8);
        tree.left.left.left = new TreeNode(7);
        System.out.println("result ================= " + maximumDepthOfBinaryTree.solution(tree));
    }

    /**
     * TODO 주어진 이진트리의 높이를 구하라.
     */
    public int solution(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        int leftMax = solution(tree.left);
        int rightMax = solution(tree.right);
        return Math.max(leftMax, rightMax) + 1;
    }



    private static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            this.val = x;
        }
    }
}
