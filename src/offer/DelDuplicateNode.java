package offer;

import utils.Utils;

/**
 * 删除有序列表中，重复的节点
 */
public class DelDuplicateNode {

    public static void main(String[] args) {

        Utils.Node<Integer> list = Utils.createList(10);
        makeDuplicateNode(list, 5);
        list = removeDuplicate(list);
        Utils.printList(list);
    }

    private static void makeDuplicateNode(Utils.Node<Integer> head, int index) {
        int s = 0;
        while (head != null && s < index) {
            s++;
            head = head.next;
        }
        if (head != null) {
            System.out.println(head.data);
            Utils.Node<Integer> nNode = new Utils.Node<>(index);
            if (head.next == null) {
                head.next = nNode;
            } else {
                Utils.Node<Integer> next = head.next;
                head.next = nNode;
                nNode.next = next;
            }
        }
    }

    private static Utils.Node<Integer> removeDuplicate(Utils.Node<Integer> root) {
        Utils.Node<Integer> first = new Utils.Node<>(-1);
        first.next = root;
        Utils.Node<Integer> last = first;
        while (root != null && root.next != null) {
            if (root.data.equals(root.next.data)) {
                while (root == root.next) {
                    root = root.next;
                }
                last.next = root;
            } else {
                root = root.next;
                last = root;
            }
            //下一个不同的节点了
            //需要把上一个节点指向这个节点
        }
        return first.next;
    }

}
