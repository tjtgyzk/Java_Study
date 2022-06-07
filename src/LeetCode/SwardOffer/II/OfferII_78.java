package LeetCode.SwardOffer.II;

public class OfferII_78 {
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

    public ListNode mergeKLists(ListNode[] lists) {
        //分治思想,两两组合
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode p1 = mergeSort(lists, l, mid);
        ListNode p2 = mergeSort(lists, mid + 1, r);
        return merge(p1, p2);
    }

    public ListNode merge(ListNode p1, ListNode p2) {
        ListNode temp = new ListNode(0);
        ListNode cur = new ListNode();
        cur = temp;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return temp.next;
    }
}
