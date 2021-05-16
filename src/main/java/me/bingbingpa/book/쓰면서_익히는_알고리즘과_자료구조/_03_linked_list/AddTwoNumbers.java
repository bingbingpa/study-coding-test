package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._03_linked_list;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node l1 = new Node(7);
        l1.next = new Node(8);
        l1.next.next = new Node(2);
        Node l2 = new Node(2);
        l2.next = new Node(1);
        print(solution3(l1, l2));
    }

    /**
     * TODO 주어진 2개의 연결 리스트로 표현되는 양의 정수의 합의 결과를 연결 리스트로 반환하라.
     */
    public static Node solution1(Node l1, Node l2) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(2N)
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        Node l1Curr = l1;
        Node l2Curr = l2;
        Node head = null;

        while (l1Curr != null) {
            st1.push(l1Curr.val);
            l1Curr = l1Curr.next;
        }

        while (l2Curr != null) {
            st2.push(l2Curr.val);
            l2Curr = l2Curr.next;
        }

        int carry = 0;
        while (!st1.isEmpty() || !st2.isEmpty()) {
            int num1 = !st1.isEmpty() ? st1.pop() : 0;
            int num2 = !st2.isEmpty() ? st2.pop() : 0;
            int sum = num1 + num2 + carry;

            carry = sum / 10;
            int num = sum % 10;
            Node node = new Node(num);

            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                head = node;
                node.next = temp;
            }
        }
        if (carry != 0) {
            Node node = new Node(carry);
            Node temp = head;
            head = node;
            node.next = temp;
        }

        return head;
    }

    public static Node solution2(Node l1, Node l2) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(1)
        Node reverseNode1 = reverse(l1);
        Node reverseNode2 = reverse(l2);
        Node head = null;
        int carry = 0;

        while (reverseNode1 != null || reverseNode2 != null) {
            int num1 = 0;
            int num2 = 0;

            if (reverseNode1 != null) {
                num1 = reverseNode1.val;
                reverseNode1 = reverseNode1.next;
            }
            if (reverseNode2 != null) {
                num2 = reverseNode2.val;
                reverseNode2 = reverseNode2.next;
            }

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            int num = sum % 10;
            Node node = new Node(num);
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                head = node;
                node.next = temp;
            }
        }
        if (carry != 0) {
            Node node = new Node(carry);
            Node temp = head;
            head = node;
            node.next = temp;
        }

        return head;
    }

    private static Node reverse(Node head) {
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

    public static Node solution3(Node l1, Node l2) {
        // 시간 복잡도: O(N)
        // 공간 복잡도: O(L+M), 변환된 문자열 저장
        StringBuilder num1Str = new StringBuilder();
        StringBuilder num2Str = new StringBuilder();

        Node l1Curr = l1;
        Node l2Curr = l2;

        while (l1Curr != null) {
            num1Str.append(l1Curr.val);
            l1Curr = l1Curr.next;
        }
        while (l2Curr != null) {
            num2Str.append(l2Curr.val);
            l2Curr = l2Curr.next;
        }

        int resNum = Integer.parseInt(num1Str.toString()) + Integer.parseInt(num2Str.toString());

        Node head = new Node(-1);
        Node curr = head;
        for (char numCh : String.valueOf(resNum).toCharArray()) {
            curr.next = new Node(numCh - '0');
            curr = curr.next;
        }
        curr.next = null;

        return head.next;
    }

    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static class Node {
        int val;
        Node next;

        public Node(int data) {
            this.val = data;
            this.next = null;
        }
    }
}
