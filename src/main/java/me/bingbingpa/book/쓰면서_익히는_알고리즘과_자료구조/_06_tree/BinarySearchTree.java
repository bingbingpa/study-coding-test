package me.bingbingpa.book.쓰면서_익히는_알고리즘과_자료구조._06_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertIter(20);
        bst.insertIter(25);
        bst.insertIter(14);
        bst.insertIter(30);
        bst.insertIter(23);
        bst.insertIter(18);
        bst.insertIter(11);
        bst.insertIter(21);
        bst.insertIter(15);
        System.out.println("inorder ========= " + bst.inorderTraverse());
        System.out.println("find ============= " + bst.find(25)); // true
        System.out.println("find ============= " + bst.find(13)); // false
        bst.delete(14);
        System.out.println("inorder ========= " + bst.inorderTraverse());
    }

    public List<Integer> inorderTraverse() {
        List<Integer> result = new ArrayList<>();
        inorderRec(this.root, result);

        return result;
    }

    public void insertIter(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            return;
        }
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        while (curr != null) {
            parent = curr;
            if (curr.data > data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (parent.data > data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    public boolean find(int data) {
        return findData(this.root, data);
    }

    public void delete(int data) {
        deleteData(this.root, data);
    }

    private void deleteData(Node node, int data) {
        Node parent = null;
        Node curr = node;

        // data 에 해당하는 노드 찾기, parent 추적
        while (curr != null && curr.data != data) {
            parent = curr;
            if (curr.data > data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) {
            return;
        }

        // 자식 노드가 없는 노드의 삭제
        if (curr.left == null && curr.right == null) {
            if (curr != node) {
                if (parent.left == curr) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else {
                node = null;
            }
            // 오른쪽 왼쪽에 모든 자식이 있는 경우
        } else if (curr.left != null && curr.right != null) {
            Node minNode = findMinNode(curr.right);
            int minData = minNode.data;
            // 오른쪽 하위 트리에서 가장 작은 노드는 항상 잎새(leaf) 노드이므로 그냥 삭제한다.
            deleteData(node, minData);
            curr.data = minData;
        } else {
            Node child;
            // 오른쪽 혹은 왼쪽 노드가 하나만 있는 경우
            if (curr.left != null) {
                child = curr.left;
            } else {
                child = curr.right;
            }
            if (curr != node) {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                node = child;
            }
        }


    }

    private Node findMinNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node insertRec(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (node.data > data) {
                node.left = insertRec(node.left, data);
            } else {
                node.right = insertRec(node.right, data);
            }
        }
        return node;
    }

    private boolean findData(Node node, int data) {
        if (node == null) {
            return false;
        } else if (node.data == data) {
            return true;
        } else if (node.data > data) {
            return findData(node.left, data);
        } else {
            return findData(node.right, data);
        }
    }


    private void inorderRec(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorderRec(node.left, result);
        result.add(node.data);
        inorderRec(node.right, result);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
}
