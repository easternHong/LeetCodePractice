package test;

import adt.tree.BTree;

import java.util.LinkedList;
import java.util.Stack;

import static adt.tree.BTree.tree;

public class Test {

    public static void main(String[] args) {

//        int[] array = {0, 30, 5, 40, 15, 20, 7};
//        qSort(array);
//        System.out.println(Arrays.toString(array));

        Node<Integer> head = createList();
        traval(head);
        head = invertLinkedList(head);
        traval(head);

        BTree.BNode root = tree();
        invertBT_(root);
        System.out.println(root);
    }


    public static void qSort(int[] array) {
        if (array == null) return;
        quickSort(0, array.length - 1, array);
    }

    public static void quickSort(int l, int h, int[] array) {
        if (l < h) {
            int p = partition(l, h, array);
            quickSort(l, p - 1, array);
            quickSort(p + 1, h, array);
        }
    }

    /**
     * 1.找一个target = array[array.length - 1]
     * 2.两头向中间偏移，交换 array[x]，array[y]
     * 3.array[x]和target比较，否则x++
     * 4.返回x
     *
     * @param l
     * @param h
     * @param array
     * @return
     */
    public static int partition(int l, int h, int[] array) {
        if (l < h) {
            int x = l, y = h;
            int target = array[h];
            while (x < y) {
                while (x < y && array[x] < target) x++;
                while (x < y && array[y] >= target) y--;
                swap(x, y, array);
            }
            if (array[x] >= target) {
                swap(x, h, array);
            } else x++;
            return x;
        }
        return -1;
    }

    private static void swap(int i, int j, int[] array) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static Node<Integer> createList() {
        int cont = 10;
        LinkedList<Node<Integer>> linkedList = new LinkedList<>();
        for (int i = 0; i < cont; i++) {
            Node<Integer> node = new Node<>();
            node.data = i;
            linkedList.add(node);
        }
        for (int i = 0; i < cont - 1; i++) {
            Node<Integer> node = linkedList.get(i);
            node.next = linkedList.get(i + 1);
        }
        return linkedList.get(0);
    }

    public static void traval(Node<Integer> head) {
        while (head != null) {
            System.out.print(head.data + ",");
            head = head.next;
        }
        System.out.println();
    }

    private static class Node<T> {
        public Node<T> next;
        public T data;
    }

    /**
     * 单链表翻转
     *
     * @param head
     */
    public static <T> Node<T> invertLinkedList(Node<T> head) {
        if (head == null || head.next == null) return head;
        Node<T> current = head;
        Stack<Node<T>> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            Node<T> node = stack.pop();
            System.out.print("," + node.data);
        }
        return current;
    }


    public static void reverseBT(BTree.BNode root) {
        if (root == null) {
            return;
        }
        BTree.BNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        reverseBT(root.left);
        reverseBT(root.right);
    }

    public static void invertBT_(BTree.BNode root) {
        if (root == null) {
            return;
        }
        Stack<BTree.BNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BTree.BNode tmpRoot = stack.pop();
            System.out.println("pop:" + tmpRoot.data);
            BTree.BNode tmp = tmpRoot.left;
            tmpRoot.left = tmpRoot.right;
            tmpRoot.right = tmp;
            if (tmpRoot.left != null) {
                stack.push(tmpRoot.left);
            }
            if (tmpRoot.right != null) {
                stack.push(tmpRoot.right);
            }
        }
    }


}
