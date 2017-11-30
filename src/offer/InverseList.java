package offer;


import utils.Utils;

import java.util.Stack;

import static utils.Utils.traval;


public class InverseList {


    public static void main(String[] args) {
        Utils.Node<Integer> head = Utils.createList();
        traval(head);
        head = invertLinkedList_(head);
        traval(head);
    }

    /**
     * 单链表翻转
     *
     * @param head
     */
    public static <T> Utils.Node<T> invertLinkedList(Utils.Node<T> head) {
        if (head == null || head.next == null) return head;
        Utils.Node<T> current = head;
        Stack<Utils.Node<T>> stack = new Stack<>();
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (!stack.isEmpty()) {
            Utils.Node<T> node = stack.pop();
            System.out.print("," + node.data);
        }
        return current;
    }

    public static <T> Utils.Node<T> invertLinkedList_(Utils.Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Utils.Node<T> pre = head;
        Utils.Node<T> cur = head.next;

        while (cur != null) {
            Utils.Node<T> tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        head.next = null;
        return pre;
    }
}
