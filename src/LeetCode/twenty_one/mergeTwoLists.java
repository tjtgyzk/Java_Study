package LeetCode.twenty_one;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        /*迭代算法
        ListNode newList = new ListNode(-1);
        ListNode head = new ListNode();
        head = newList;
        while (l1 != null && l2 != null) {
            if(l1.val< l2.val){
                newList.next = l1;
                l1 = l1.next;
            }else {
                newList.next = l2;
                l2 = l2.next;
            }
            newList = newList.next;
        }
        if(l1!=null){
            newList.next = l1;
        }if(l2!=null){
            newList.next = l2;
        }
        return head.next;
        */
        //递归算法
        if (l1 == null || l2 == null) {
            if (l1 == null) {
                return l2;
            }
            else {
                return l1;
            }
        } else {
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
