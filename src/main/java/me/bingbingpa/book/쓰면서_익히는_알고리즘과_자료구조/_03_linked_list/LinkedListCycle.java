package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._03_linked_list;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        Node root = new Node(11);
        Node node13 = new Node(13);
        root.next = new Node(12);
        root.next.next = node13;
        root.next.next.next = new Node(14);
        root.next.next.next.next = new Node(15);
        root.next.next.next.next.next = node13;
        System.out.println("result ==================== " + solution3(root));
    }

    /**
     * TODO 주어진 연결 리스트가 순환(Cycle)을 가지는지 판단하라.
     */
    public static boolean solution1(Node head) {
        // 시간 복잡도: O(N^2)
        // 공간 복잡도: O(1)
        Node outer = head;
        int nodeCnt = 0;

        while (outer != null && outer.next != null) {
            outer = outer.next;
            nodeCnt++;
            int visit = nodeCnt;
            Node inner = head;
            int matched = 0;

            while (visit > 0) {
                if (outer != inner) {
                    inner = inner.next;
                }
                if (outer == inner) {
                    matched++;
                }
                if (matched == 2) {
                    return true;
                }
                visit--;
            }
        }
        return false;
    }

    public static boolean solution2(Node head) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(N)
        Node curr = head;
        Set<Node> nodeSet = new HashSet<>();

        while (curr != null) {
            if (nodeSet.contains(curr)) {
                return true;
            }
            nodeSet.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static boolean solution3(Node head) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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
