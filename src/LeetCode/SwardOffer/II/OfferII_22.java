package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_22 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
