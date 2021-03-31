package me.bingbingpa.inflearn.interview._05_tree;

public class ValidateBST {

    private Node prevNode;

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(5);

        ValidateBST validateBST = new ValidateBST();
        System.out.println(validateBST.solution2(root));
    }

    /**
     * TODO 주어진 이진 트리가 BST 인지 확인하는 코드를 작성하라.
     */
    private boolean solution1(Node node) {
        return isValid(node, null, null);
    }

    private boolean isValid(Node node, Node left, Node right) {
        if (node == null) {
            return true;
        }

        if (left != null && node.value <= left.value) {
            return false;
        }

        if (right != null && node.value >= right.value) {
            return false;
        }

        return isValid(node.left, left, node) &&
                isValid(node.right, node, right);
    }

    private boolean solution2(Node node) {
        if (node != null) {
            if (!solution2(node.left)) {
                return false;
            }

            if (prevNode != null && node.value <= prevNode.value) {
                return false;
            }

            prevNode = node;
            return solution2(node.right);
        }

        return true;
    }

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }
}
