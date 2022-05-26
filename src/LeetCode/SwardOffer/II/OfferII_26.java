package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_26 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //先找到中点or上中点
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
            ListNode next1 = head1.next;
            ListNode next2 = head2.next;
            head1.next = head2;
            head2.next = next1;
            head1 = next1;
            head2 = next2;
        }
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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new OfferII_26().reorderList(head);
    }
}
