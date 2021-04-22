package me.bingbingpa.inflearn.practice._02_linkedlist;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        reverseLinkedList.printNode(l1);
        ListNode head = reverseLinkedList.solution(l1);
        reverseLinkedList.printNode(head);
    }

    /**
     * TODO 입력으로 주어지는 LinkedList 를 뒤집어서 리턴하라.
     * input: 1->2->3->4->5->NULL, output: 5->4->3->2->1->NULL
     */
    public ListNode solution(ListNode current) {
        ListNode prev = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    private void printNode(ListNode head) {
        System.out.println("printNOde: ");
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println();
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
