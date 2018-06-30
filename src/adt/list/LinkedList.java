package adt.list;

import utils.Utils;

/**
 * 1.判断两个链表是否相交
 * 2.判断一个链表是否有环,找出环的入口
 * <p>
 * 单链表是否有环：一个慢指针，一个快指针，终有相遇。
 */
public class LinkedList {

    public static void main(String[] args) {

        //1.创建相交链表
        Utils.Node<Integer> list0 = Utils.createList(11);


        //2.创建有环链表
        Utils.Node<Integer> circleList = Utils.createList(11);
        Utils.Node<Integer> last = circleList;
        Utils.Node<Integer> tmp = null;
        int count = 0;
        while (last.next != null) {
            last = last.next;
            count++;
            if (count == 6) {
                tmp = last;
            }
        }
        System.out.println("last:" + last);
        System.out.println("tmp:" + tmp);
        last.next = tmp;
        boolean has = hasCircle(circleList);
        System.out.println("入口:" + findEntrance(circleList));


        //翻转链表
        Utils.Node head = null;
        for (int i = 0; i < 10; i++) {
            head = createList(head, new Utils.Node<>(i));
        }
        Utils.printList(head);
        head = revertLinkedList(head);
        Utils.printList(head);
    }

    private static Utils.Node createList(Utils.Node head, Utils.Node node) {
        if (head == null) {
            return node;
        }
        Utils.Node oldHead = head;
        while (head != null) {
            if (head.next == null) {
                head.next = node;
                break;
            }
            head = head.next;
        }
        return oldHead;
    }

    private static boolean hasCircle(Utils.Node<Integer> head) {

        if (head == null || head.next == null) return false;
        //2.1 判断是否相交
        Utils.Node<Integer> slow = head;
        Utils.Node<Integer> fast = head.next.next;

        while (slow != null && fast.next != null && slow != fast) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("有环？" + (slow == fast) + "," + slow);
        return slow == fast;
    }

    /**
     * 找出环的入口
     *
     * @param head
     * @return
     */
    private static Utils.Node<Integer> findEntrance(Utils.Node<Integer> head) {
//        //1.找到相遇点，
//        if (head == null || head.next == null) return head;
//        //2.设定起始点 非常重要
//        Utils.Node<Integer> slow = head, fast = head;
//        while (fast != null && slow != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {
//                break;
//            }
//        }
//        //2.
//        fast = head;
//        while (slow != null && fast != null && slow != fast) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;

        if (head == null || head.next == null) return null;

        Utils.Node<Integer> slow = head, fast = head;

        //找出相遇点
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //
        fast = head;

        while (slow != null && fast != null && fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    static Utils.Node revertLinkedList(Utils.Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Utils.Node pre = null;
//        //1.把头部缓存下来
//        Utils.Node next = head;
//        while (next != null) {
//            //2.把头部的下一个节点缓存下来
//            Utils.Node node = next.next;
//            //3.把头部方向调转
//            next.next = pre;
//            //4.调转之后，临时节点均向后移动。
//            pre = next;
//            next = node;
//        }
//        head = pre;
//        return head;
        if (head == null || head.next == null) {
            return head;
        }

        Utils.Node pre = null;
        //1.把头部缓存下来
        Utils.Node next = head;

        while (next != null) {
            //2.把头部的下一个节点缓存下来
            Utils.Node node = next.next;
            //3.调转头部的方向
            next.next = pre;
            //4.临时节点向后移动
            pre = next;
            next = node;
        }
        head = pre;
        return head;
    }

}
