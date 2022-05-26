package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_24 {
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
}
