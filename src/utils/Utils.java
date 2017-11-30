package utils;

import java.util.LinkedList;

public class Utils {

    public static void main(String[] args) {
        Node<Integer> head = createList(10);
        Node<Integer> circle = createCircle(10);
        System.out.println(head);
        System.out.println(circle);
    }

    public static class Node<T> {
        public Node<T> next, pre;
        public T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", data=" + data +
                    '}';
        }
    }

    public static Node<Integer> createList(int cnt) {
        Node<Integer> root = new Node<>(0);
        Node<Integer> next = root;
        for (int i = 1; i < cnt; i++) {
            Node<Integer> nNode = makeNode(i);
            next.next = nNode;
            next = nNode;
        }
        return root;
    }

    public static <T> void printList(Node<T> head) {
        while (head != null) {
            System.out.print("," + head.data);
            head = head.next;
        }
        System.out.println("");
    }

    public static Node<Integer> createCircle(int cnt) {
        Node<Integer> root = new Node<>(0);
        Node<Integer> next = root;
        for (int i = 1; i < cnt; i++) {
            Node<Integer> nNode = makeNode(i);
            next.next = nNode;
            next = nNode;
        }
        next.next = root;
        return root;
    }

    private static <T> Node<T> makeNode(T data) {
        return new Node<>(data);
    }

    public static void traval(Utils.Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
        System.out.println();
    }

    public static Node<Integer> createList() {
        int cont = 10;
        LinkedList<Node<Integer>> linkedList = new LinkedList<>();
        for (int i = 0; i < cont; i++) {
            Node<Integer> node = new Node<>(i);
            node.data = i;
            linkedList.add(node);
        }
        for (int i = 0; i < cont - 1; i++) {
            Node<Integer> node = linkedList.get(i);
            node.next = linkedList.get(i + 1);
        }
        return linkedList.get(0);
    }
}
