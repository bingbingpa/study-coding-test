package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._06_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(14);
        root.left = new Node(42);
        root.right = new Node(35);
        root.left.left = new Node(33);
        root.left.right = new Node(31);
        root.right.left = new Node(19);
        root.right.right = new Node(27);

        print(root);
        solution2(root);
        print(root);
    }

    /**
     * TODO 이진 트리를 반전 하라.
     */
    public static Node solution1(Node root) {
        // 시간 복잡도: O(n)
        // 공간 복잡도: O(n)
        if (root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();

            Node left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return root;
    }

    public static Node solution2(Node root) {
        // 시간 복잡도: O(n)
        // 공간 복잡도: O(n)
        if (root == null) {
            return null;
        }
        Node left = root.left;
        root.left = root.right;
        root.right = left;

        solution2(root.left);
        solution2(root.right);

        return root;
    }

    public static void print(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        System.out.println("=====================================");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
