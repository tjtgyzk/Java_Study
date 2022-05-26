package LeetCode.SwardOffer.II;

public class OfferII_28 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                cur.next = cur.child;
                cur.child.prev = cur;
                Node last = findLast(cur.child);
                last.next = next;
                if (next != null) {
                    next.prev = last;
                }
                cur.child = null;
            }
            cur = cur.next;
        }
        return head;
    }

    public Node findLast(Node head) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }
}
