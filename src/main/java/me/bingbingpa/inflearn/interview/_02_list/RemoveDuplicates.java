package me.bingbingpa.inflearn.interview._02_list;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(4));

        list.print();
        list.removeDuplicates4();
        list.print();
    }

    /**
     * TODO 정렬된 연결 리스트에서 중복된 노드를 제거하는 함수를 구현하라.
     * 예) 1 -> 1 -> 1 -> 2 -> 3 -> 3   =>   1 -> 2 -> 3
     */
    private void removeDuplicates1() {
//        시간 복잡도 O(N)
//        공간 복잡도 O(1)
        LinkedNode current = this.head;
        while (current != null) {
            LinkedNode next = current;
            while (next != null && next.number == current.number) {
                next = next.next;
            }

            current.next = next;
            current = current.next;
        }
    }

    private void removeDuplicates2() {
//        시간 복잡도 O(N)
//        공간 복잡도 O(1)
        LinkedNode current = this.head;
        LinkedNode prev = this.head;

        while (current != null) {
            if (current.number != prev.number) {
                prev.next = current;
            }

            current = current.next;
        }

        if (prev != current) {
            prev.next = null;
        }
    }

    private void removeDuplicates3() {
//        시간 복잡도 O(N)
//        공간 복잡도 O(N)
        removeDuplicateRecursive(this.head);
    }

    private LinkedNode removeDuplicateRecursive(LinkedNode node) {
        if (node == null) {
            return null;
        }

        if (node.next != null && node.number == node.next.number) {
            node.next = node.next.next;
            removeDuplicateRecursive(node);
        } else {
            removeDuplicateRecursive(node.next);
        }

        return node;
    }

    private void removeDuplicates4() {
        Set<Integer> numberSet = new HashSet<>();

        LinkedNode current = this.head;
        LinkedNode prev = null;

        while (current != null) {
            int currentNumber = current.number;
            if (numberSet.contains(currentNumber)) {
                prev.next = current.next;
            } else {
                numberSet.add(currentNumber);
                prev = current;
            }

            current = current.next;
        }
    }

    private void print() {
        LinkedNode nodeToPrint = this.head;
        while (nodeToPrint != null) {
            System.out.println(nodeToPrint.number);
            nodeToPrint = nodeToPrint.next;
        }
    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }
}
