package me.bingbingpa.inflearn.interview._05_tree;

import java.util.ArrayList;
import java.util.List;

public class FindLCASolution1 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        FindLCASolution1 findLCA = new FindLCASolution1();
        System.out.println(findLCA.solution(root, 4, 5));
        System.out.println(findLCA.solution(root, 2, 5));
        System.out.println(findLCA.solution(root, 3, 4));
        System.out.println(findLCA.solution(root, 3, 7));
        System.out.println(findLCA.solution(root, 3, 8));
    }

    private Node solution(Node root, int n1, int n2) {
        List<Node> n1Path = new ArrayList<>();
        List<Node> n2Path = new ArrayList<>();
        if (!findPath(root, n1, n1Path) || !findPath(root, n2, n2Path)) {
            return null;
        }

        int index = 0;
        for (; index < n1Path.size() && index < n2Path.size(); index++) {
            if (!n1Path.get(index).equals(n2Path.get(index))) {
                break;
            }
        }

        return n1Path.get(index - 1);
    }

    private boolean findPath(Node root, int n, List<Node> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.value == n) {
            return true;
        }

        if (findPath(root.left, n, path)) {
            return true;
        }

        if (findPath(root.right, n, path)) {
            return true;
        }

        path.remove(root);
        return false;
    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
