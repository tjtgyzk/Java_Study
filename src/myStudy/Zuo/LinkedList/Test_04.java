package myStudy.Zuo.LinkedList;

public class Test_04 {
    public static Node loop(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast) {//第一次相遇
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node findNodeNoCircle(Node head1, Node head2) {
        Node cur = head1;
        int n = 0;
        while (cur.next != null) {
            n++;
            cur = cur.next;
        }
        cur = head2;
        while (cur.next != null) {
            n--;
            cur = cur.next;
        }
        cur = n > 0 ? head1 : head2;//cur为长的那个链表的头部
        Node cur2 = cur == head1 ? head2 : head1;//cur2为短的那个链表的头部
        n = Math.abs(n);
        while (n-- > 0) {
            cur = cur.next;
        }
        while (cur != cur2) {
            cur = cur.next;
            cur2 = cur2.next;
        }
        return cur;
    }

    public static Node process(Node head1, Node head2) {
        Node loop1 = loop(head1);
        Node loop2 = loop(head2);
        if (loop1 == null && loop2 == null) {
            return findNodeNoCircle(head1, head2);
        }
        if ((loop1 == null && loop2 != null) || (loop1 != null) && loop2 == null) {
            return null;
        }
        //两个都有环
        if (loop1 == loop2) {
            loop1.next = null;
            return findNodeNoCircle(head1, head2);
        }
        //两个入环点不一样
        Node cur = loop1;
        do {
            cur = cur.next;
            if (cur == loop2) {//遇到了loop2
                return loop1;
            }
        } while (cur != loop1);
        return null;
    }
}
