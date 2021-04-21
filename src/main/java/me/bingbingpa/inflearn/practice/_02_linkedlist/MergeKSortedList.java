package me.bingbingpa.inflearn.practice._02_linkedlist;

import java.util.Collections;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public static void main(String[] args) {
        MergeKSortedList mergeKSortedList = new MergeKSortedList();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] list = new ListNode[3];
        list[0] = l1;
        list[1] = l2;
        list[2] = l3;
        ListNode result = mergeKSortedList.solution(list);
        System.out.println("====");
        while(result !=null) {
            System.out.println(result.val);
            result= result.next;
        }

    }

    /**
     * TODO k 개의 정렬된 연결 목록을 병합하고 하나의 정렬된 목록으로 리턴하라.
     * input: [1->4->5, 1->3->4, 2->6] output: 1->1->2->3->4->4->5->6
     * - PriorityQueue 를 오름차순으로 만든다.
     * - ListNode 를 순회해 본다.
     * - ListNode 를 순회하며 PriorityQueue 에 넣고 리턴한다.
     */
    public ListNode solution(ListNode[] current) {
//        testPriorityQueue();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : current) {
            while (listNode != null) {
                int value = listNode.val;
                listNode = listNode.next;
                queue.offer(value);
            }
        }

        return convertQueueToListNode(queue);
    }

    private ListNode convertQueueToListNode(PriorityQueue<Integer> queue) {
        ListNode node = new ListNode(0);
        ListNode p1 = node;
        while (!queue.isEmpty()) {
            p1.next = new ListNode(queue.poll());
            p1 = p1.next;
        }

        return node.next;
    }

    private void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reverseQueue = new PriorityQueue<>(Collections.reverseOrder());

        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(1);

        reverseQueue.offer(3);
        reverseQueue.offer(1);
        reverseQueue.offer(2);

        System.out.println("queue ============== " + queue.poll());
        System.out.println("queue ============== " + queue.poll());
        System.out.println("queue ============== " + queue.poll());
        System.out.println("queue ============== " + queue.poll());
        System.out.println("reverseQueue ============== " + reverseQueue.poll());
        System.out.println("reverseQueue ============== " + reverseQueue.poll());
        System.out.println("reverseQueue ============== " + reverseQueue.poll());
    }

    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }
}
