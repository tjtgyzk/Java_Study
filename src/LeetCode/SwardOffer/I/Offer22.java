package LeetCode.SwardOffer.I;


import LeetCode.SwardOffer.ListNode;

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        //快指针先走k步
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }
        //当快指针为空时,慢指针即为倒数第k个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
