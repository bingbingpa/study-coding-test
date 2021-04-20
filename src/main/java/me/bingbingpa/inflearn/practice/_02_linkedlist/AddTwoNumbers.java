package me.bingbingpa.inflearn.practice._02_linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);
        ListNode node = addTwoNumbers.solution(l1, l2);
        while (node != null) {
            System.out.println("node =========== " + node.val);
            node = node.next;
        }
    }

    /**
     * TODO 주어진 두 ListNode 의 합을 구하라.
     * 예) input: ListNode1: 2->4->3, ListNode2: 5->6->9, output: 7->0->3->1
     */
    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = newHead;
        int carry = 0;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1) {
            p3.next = new ListNode(1);
        }

        return newHead.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }
}
