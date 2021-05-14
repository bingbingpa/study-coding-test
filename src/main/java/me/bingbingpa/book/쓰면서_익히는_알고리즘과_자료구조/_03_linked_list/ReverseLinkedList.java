package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._03_linked_list;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.next = new Node(11);
        root.next.next = new Node(12);
        root.next.next.next = new Node(13);
        print(root);
//        print(solution1(root));
//        print(solution2(root));
        print(solution3(root));
    }

    /**
     * TODO 주어진 단일 연결 리스트를 역순으로 리턴하라.
     * 예) input: 10->11->12->13->null, output: 13->12->11->10
     */
    public static Node solution1(Node head) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public static Node solution2(Node head) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N),스택에 모든 노드를 저장
        if (head == null) {
            return head;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = head;

        while (curr.next != null) {
            stack.push(curr);
            curr = curr.next;
        }
        Node first = curr;

        while (!stack.isEmpty()) {
            curr.next = stack.pop();
            curr = curr.next;
        }
        curr.next = null;

        return first;
    }

    public static Node solution3(Node head) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N), 재귀도 스택을 사용
        if (head == null || head.next == null) {
            return head;
        }
        Node reversNode = solution3(head.next);
        head.next.next = head;
        head.next = null;

        return reversNode;
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}
