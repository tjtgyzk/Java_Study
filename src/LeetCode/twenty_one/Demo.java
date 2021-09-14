package LeetCode.twenty_one;

public class Demo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        mergeTwoLists d1 = new mergeTwoLists();
        ListNode re = d1.mergeTwoLists(n1,l1);
        System.out.println("");
    }



}
