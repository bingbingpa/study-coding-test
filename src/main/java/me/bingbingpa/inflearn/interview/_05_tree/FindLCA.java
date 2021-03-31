package me.bingbingpa.inflearn.interview._05_tree;

public class FindLCA {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        FindLCA findLCA = new FindLCA();
        System.out.println(findLCA.solution(root, 4, 5)); // 2
        System.out.println(findLCA.solution(root, 2, 5)); // 2
        System.out.println(findLCA.solution(root, 3, 4)); // 1
        System.out.println(findLCA.solution(root, 3, 7)); // 3
        System.out.println(findLCA.solution(root, 3, 8)); // null

    }

    /**
     * TODO 주어진 이진 트리 (node) 에서 두 노드 n1, n2의 가장 가까운 공통 조상(Lowest Common Ancestor)을 찾는 코드를 작성하라.
     */
    private Node solution(Node root, int n1, int n2) {
        return null;
    }

    private static class Node {
        int value;
        Node left;
        Node right;

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
