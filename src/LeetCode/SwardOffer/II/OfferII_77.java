package LeetCode.SwardOffer.II;

public class OfferII_77 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        int step = 1;
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        //指向头节点的前一个节点
        ListNode last = new ListNode(0, head);
        while (step < n) {
            //前一组的最后一个节点和当前组的第一个节点
            ListNode prev = last, curr = prev.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < step && cur != null && curr.next != null; i++) {
                    //找到该组中第一个链表的结尾
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                //断开链表
                curr.next = null;
                curr = head2;
                for (int i = 1; i < step && cur != null && curr.next != null; i++) {
                    //找到该组中第二个链表的结尾
                    curr = curr.next;
                }
                //下一组的头节点
                ListNode next = null;
                //断开第二个链表
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                //merge该组两个链表
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                //找到排序后该组的最后一个节点
                while (prev.next != null) {
                    prev = prev.next;
                }
                //下一组的第一个节点
                curr = next;
            }
            step *= 2;
        }
        return last.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        OfferII_77 offerII_77 = new OfferII_77();

    }
}
