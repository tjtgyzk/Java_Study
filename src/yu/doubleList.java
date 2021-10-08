package yu;

public class doubleList {
    public static doubleNode addHead(doubleNode head, doubleNode n) {
        if (head == null) {
            head = n;
            return n;
        } else {
            head.pre = n;
            n.next = head;
            return n;
        }
    }

    public static void addLast(doubleNode head, doubleNode n) {
        doubleNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = n;
        n.pre = last;
    }

    public static doubleNode reverse(doubleNode head) {
        doubleNode pre = null;
        doubleNode cur = head;
        doubleNode next = cur.next;

        while (next != null) {
            cur.next = pre;
            cur.pre = next;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        cur.pre = next;
        return cur;
    }
}
