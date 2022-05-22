package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.ListNode;

public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        ListNode cur = headA;
        while (cur != null) {
            l1++;
            cur = cur.next;
        }
        cur = headB;
        while (cur != null) {
            l1--;
            cur = cur.next;
        }
        ListNode longHead = l1 >= 0 ? headA : headB;
        ListNode shortHead = longHead == headA ? headB : headA;
        l1 = Math.abs(l1);
        while (l1 > 0) {
            longHead = longHead.next;
            l1--;
        }
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;

    }
}
