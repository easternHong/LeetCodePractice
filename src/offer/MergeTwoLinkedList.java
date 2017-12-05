package offer;

import utils.Utils;

public class MergeTwoLinkedList {

    public static void main(String[] args) {

    }

    //合并
    //1.找出头结点
    //2.遍历两个链表，对比
    private Utils.Node<Integer> merge(Utils.Node<Integer> left, Utils.Node<Integer> right) {

        if (left == null) return right;
        if (right == null) return left;

        Utils.Node<Integer> head = null;
        //确定头结点
        if (left.data > right.data) {
            head = right;
        } else {
            head = left;
            left = left.next;
        }

        //借助一个中间的数据，把相关结点连起来。
        Utils.Node<Integer> cur = head;
        while (left != null && right != null) {
            if (left.data > right.data) {
                //遍历right
                cur.next = right;
                cur = right.next;
                right = right.next;
            } else {
                //遍历left
                cur.next = left;
                cur = left.next;
                left = left.next;
            }
        }
        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }
        return head;
    }


}
