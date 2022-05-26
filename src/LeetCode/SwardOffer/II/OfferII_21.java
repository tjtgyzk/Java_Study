package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.ListNode;

public class OfferII_21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先找到链表倒数第k+1个节点,删除下一个节点
        //快指针先走k+1步,如果已经是null,说明要删除的是头节点
        ListNode fast = head;
        ListNode slow = head;
        while (n >= 0) {
            if (fast == null) {
                return head.next;
            }
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        new OfferII_21().removeNthFromEnd(head, 2);
    }
}
