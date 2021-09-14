package LeetCode.twenty_four;

public class reverseNodeList {
    public ListNode reverseList(ListNode head) {
        ListNode temp1 = null;
        ListNode temp2 = head;//要转换的节点
        while (temp2 != null) {
            ListNode temp3 = temp2.next;//t3 = 第二个节点
            temp2.next = temp1;//第一个节点指向null
            temp1 = temp2;//t1为转向后的第一个节点
            temp2 = temp3;//t2去第二个节点
        }
        return temp1;
    }

}

