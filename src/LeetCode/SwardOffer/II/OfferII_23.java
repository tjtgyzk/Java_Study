package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_23 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            n--;
            cur = cur.next;
        }
        ListNode longHead = n >= 0 ? headA : headB;
        ListNode shortHead = longHead == headA ? headB : headA;
        n = Math.abs(n);
        while (n > 0) {
            longHead = longHead.next;
            n--;
        }
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }
}
