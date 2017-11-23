package utils;

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

}
