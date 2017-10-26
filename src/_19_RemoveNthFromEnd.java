/**
 * Created by hds on 17-10-26.
 */
public class _19_RemoveNthFromEnd {

    private static final int CNT = 10;

    private static class Node {
        Node next;
        int data;
    }

    /**
     * 1. n 是一个有效值,倒数第n个节点
     * 2. 只能循环一遍
     * 解答思路：纯属技巧类型吧。
     * 一：用两个指针，从开始移动n次
     * 二：第一个指针继续移动到最后，此时第二个指针也参与移动(从0开始移动)，直到第一个指针停止移动，
     * 那么第二个指针的位置就是目标位置。
     *
     * @param head
     * @param n
     */
    private static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;
        Node slow = head;
        Node newHead = slow.next;
        for (int i = 0; i < n; i++) {
            newHead = newHead.next;
        }
        if (newHead == null) {
            head = head.next;
            return head;
        }
        System.out.println("newHead;" + newHead.data);
        while (newHead.next != null) {
            newHead = newHead.next;
            slow = slow.next;
        }
        System.out.println("slow:" + slow.data);
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Node head = createList();
            traversal("i:" + i, removeNthFromEnd(head, i));
        }
    }

    private static void traversal(String tag, Node node) {
        if (node == null) {
            System.out.println("node is null return");
            return;
        }
        System.out.print(tag + ":");
        while (node != null) {
            System.out.print(node.data + ",");
            node = node.next;
        }
        System.out.println();
    }

    private static Node createList() {
        Node node = new Node();
        Node head = node;
        for (int i = 1; i < CNT; i++) {
            Node next = new Node();
            next.data = i;
            node.next = next;
            node = node.next;
        }
        return head;
    }

}
