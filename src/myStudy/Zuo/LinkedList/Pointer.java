package myStudy.Zuo.LinkedList;

public class Pointer {
    public static void main(String[] args) {
        Node head1 = null;
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        Node head2 = null;
        head2 = new Node(1);
        head2.next = new Node(2);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        head2.next.next.next.next.next = new Node(6);

        System.out.println(middleOrUp(head1).value);
        System.out.println(middleOrUp(head2).value);

        System.out.println(middleOrDown(head1).value);
        System.out.println(middleOrDown(head2).value);

        System.out.println(preMidOrUp(head1).value);
        System.out.println(preMidOrUp(head2).value);

        System.out.println(preMidOrDown(head1).value);
        System.out.println(preMidOrDown(head2).value);
    }

    public static Node middleOrUp(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 链表有3个点或以上
        Node slow = head.next;//slow从第二个节点开始
        Node fast = head.next.next;//fast从第三个结点开始
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node middleOrDown(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //链表有两个点或以上
        Node slow = head.next;//slow从第二个点开始
        Node fast = head.next;//fast从第二个点开始，fast比第一种多跳一步（偶数），故slow处于下结点位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node preMidOrUp(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        //三个点以上
        Node slow = head;//从头节点开始，比第一种提前一个
        Node fast = head.next.next;//与第一种无区别
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node preMidOrDown(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //链表有两个点或以上
        Node slow = head;//slow从第一个点开始，比第二种提前一个
        Node fast = head.next;//fast从第二个点开始，fast比第一种多跳一步（偶数），故slow处于下结点位置
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
