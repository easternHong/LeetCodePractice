package adt.list;

import utils.Utils;

/**
 * 1.判断两个链表是否相交
 * 2.判断一个链表是否有环,找出环的入口
 */
public class List {

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

}
