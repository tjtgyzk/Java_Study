package myStudy.Zuo.LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test_01 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        boolean f1 = useStack(head);
        boolean f2 = usePointer(head);
        System.out.println(f1 + "" + f2);
    }

    public static boolean useStack(Node head) {
        Node temp = head;
        Deque<Node> stack = new ArrayDeque<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (!stack.isEmpty()) {
            if (stack.pop().value != temp.value) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public static boolean usePointer(Node head) {
        //找到中点
        Node mid = Pointer.middleOrUp(head);
        //中点后半部分逆序
        Node cur = mid.next;//中点下一个结点
        Node next = cur.next;//保存下一个结点
        mid.next = null;//中点指向null
        Node pre = mid;//pre结点为要指向的结点
        while (cur.next != null) {//cur 最后指向最后一个
            cur.next = pre;//当前节点指向前一结点
            //pre cur temp各自后移一位
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        //最后一个和第一个比较，然后依次向前，直到null
        Node first = head;
        Node last = cur;
        while (first != null && last != null) {
            if (first.value != last.value) {
                return false;
            }
            first = first.next;
            last = last.next;
        }
        //复原链表
        pre = null;
        next = cur.next;
        while (cur.next != mid) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        mid.next = cur;
        return true;


    }
}
