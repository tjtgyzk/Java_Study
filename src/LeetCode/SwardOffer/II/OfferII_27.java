package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_27 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        //后半部分逆序
        ListNode mid = findMid(head);
        //将后半部分逆序
        ListNode pre = mid;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur == null ? null : cur.next;
        }
        mid.next = null;
        ListNode head1 = head;
        ListNode head2 = pre;
        while (head2 != null && head1 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
