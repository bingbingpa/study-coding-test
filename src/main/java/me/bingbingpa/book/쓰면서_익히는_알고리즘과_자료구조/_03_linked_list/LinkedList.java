package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._03_linked_list;

public class LinkedList<T> {

    Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
//        Node<Integer> node1 = new Node<>(11);
//        linkedList.head = node1;
//
//        Node<Integer> node2 = new Node<>(12);
//        Node<Integer> node3 = new Node<>(13);

//        node1.next = node2;
//        node2.next = node3;

        linkedList.pushBack(11);
        linkedList.pushBack(12);
        linkedList.pushBack(13);
        linkedList.push(10);

        linkedList.remove(12);

        linkedList.traverse();
    }

    public void traverse() {
        Node<T> temp = this.head;

        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public void pushBack(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node<T> last = this.head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node<T> temp = this.head;
        this.head = newNode;
        newNode.next = temp;
    }

    public void remove(T data) {
        Node<T> curr = this.head;
        Node<T> prev = null;

        if (curr != null) {
            if (curr.data == data) {
                this.head = curr.next;
                curr = null;
                return;
            }
        }

        while (curr != null) {
            if (curr.data == data) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        prev.next = curr.next;

        curr = null;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

