package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        boolean higher = false;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            higher = higher ? x + y + 1 >= 10 : x + y >= 10;
            cur.val += (x + y);
            cur.val %= 10;
            cur.next = higher ? new ListNode(1) : new ListNode(0);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            cur = cur.next;
        }
        head = reverseList(head);
        return head.val == 0 ? head.next : head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur == null ? null : cur.next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        new OfferII_25().addTwoNumbers(l1, l2);

    }
}
