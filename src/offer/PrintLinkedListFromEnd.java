package offer;

import utils.Utils;

/**
 * 从尾到头打印链表
 * 1.翻转链表
 * 2.使用栈机构
 */
public class PrintLinkedListFromEnd {

    public static void main(String[] args) {
        Utils.Node<Integer> list = Utils.createList(10);
        Utils.Node<Integer> nHead = printInvert(list);
        print(nHead);
    }

    private static void printStackWay(Utils.Node<Integer> head) {
    }

    private static Utils.Node<Integer> printInvert(Utils.Node<Integer> head) {
        if (head == null || head.next == null) {
            System.out.println("list is empty");
            return null;
        }
//        Utils.Node<Integer> pre = null;
//        Utils.Node<Integer> next = null;
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
        Utils.Node<Integer> pre = null;
        Utils.Node<Integer> next = null;

        while (head != null) {
            //1.拿到下一个节点。
            next = head.next;
            //2.修改这个节点指向的节点
            head.next = pre;
            //3.新的节点指向当前的节点
            pre = head;
            //4.处理下一个节点
            head = next;
        }
        return pre;
    }

    private static void print(Utils.Node<Integer> root) {
        while (root != null) {
            System.out.print("," + root.data);
            root = root.next;
        }
        System.out.println("完成");
    }
}
