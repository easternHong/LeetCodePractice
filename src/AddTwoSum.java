/**
 * Created by hds on 17-9-28.
 */
public class AddTwoSum {


    private static class Node {
        public int digit;
        public Node next;

        public Node(int digit) {
            this.digit = digit;
        }
    }

    public Node addSum(Node n1, Node n2) {
        Node head = new Node(0);
        Node p = n1, q = n2, curr = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null ? 0 : p.digit;
            int y = q == null ? 0 : q.digit;
            int sum = carry + x + y;
            carry = sum / 10;
            //创建Node
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            //再进位
            curr.next = new Node(carry);
        }
        return head.next;
    }

}
