package me.bingbingpa.inflearn.interview._02_list;

import java.util.HashMap;
import java.util.Map;

public class FindFromLast {
    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        FindFromLast list = new FindFromLast();
        list.add(new LinkedNode(1));
        list.add(new LinkedNode(2));
        list.add(new LinkedNode(3));
        list.add(new LinkedNode(4));
        list.add(new LinkedNode(5));
        list.add(new LinkedNode(6));

        list.print();
        LinkedNode node = list.findFromLast3(3);
        System.out.println(node.number);
    }

    /**
     * TODO 단일 연결 리스트의 끝에서 n 번째에 위치한 노드를 찾는 함수를 구현하라.
     * 예) findFromLast(1 -> 4 -> 2 -> 3, 2), 끝에서 2번째에 위치한 2를 리턴한다.
     *
     * @param n
     * @return
     */
    private LinkedNode findFromLast1(int n) {
//        시간 복잡도 O(N)
//        공간 복잡도 O(N)
        Map<Integer, LinkedNode> nodeMap = new HashMap<>();
        int index = 0;
        LinkedNode current = this.head;
        while (current != null) {
            nodeMap.put(index++, current);
            current = current.next;
        }

        return nodeMap.get(nodeMap.size() - n);
    }

    private LinkedNode findFromLast2(int n) {
//        시간 복잡도 O(N)
//        공간 복잡도 O(1)
        LinkedNode current = this.head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        int targetIndex = length - n;
        LinkedNode target = this.head;
        while (targetIndex > 0) {
            targetIndex--;
            target = target.next;
        }

        return target;
    }

    private LinkedNode findFromLast3(int n) {
//        시간 복잡도 O(N)
//        공간 복잡도 O(1)
        LinkedNode left = this.head;
        LinkedNode right = this.head;
        int count = 1;
        while (right.next != null) {
            if (count == n) {
                left = left.next;
                right = right.next;
            } else if (count < n) {
                count++;
                right = right.next;
            }
        }

        return left;
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
