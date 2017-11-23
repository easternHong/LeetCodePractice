package misc;


import utils.Utils;

public class Yosefu {


    public static void main(String[] args) {

        Utils.Node<Integer> circle = Utils.createCircle(10);

        System.out.println(Yo(circle, 3));
    }

    /**
     * 1.构建回环
     * 2.按照step删除节点，直到剩下一个。
     *
     * @param head
     * @param step
     * @return
     */
    private static int Yo(Utils.Node<Integer> head, int step) {
        if (head == null) return -1;
        Utils.Node<Integer> current = head;
        while (current != current.next) {
            System.out.print("");
            for (int i = 1; i < step - 1; i++) {
                current = current.next;
            }
            Utils.Node<Integer> next = current.next;
            current.next = next.next;
            current = current.next;
            next = null;//删除节点
        }
        return current.data;
    }

    private static void print(Utils.Node<Integer> head) {
        int data = head.data;
        while (head != head.next) {
            Utils.Node<Integer> node = head;

        }
    }

}
