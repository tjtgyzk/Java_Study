package LeetCode.twenty_four;

public class Demo {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        reverseNodeList r1 = new reverseNodeList();
        ListNode re = r1.reverseList(n1);
        System.out.println("   ");
    }



}
