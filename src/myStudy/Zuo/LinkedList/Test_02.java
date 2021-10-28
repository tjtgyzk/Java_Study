package myStudy.Zuo.LinkedList;

import java.util.ArrayList;

public class Test_02 {
    public static void main(String[] args) {
        Node head1 = new Node(6);
        head1.next = new Node(7);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(7);
        head1.next.next.next.next.next = new Node(3);
        head1.next.next.next.next.next.next = new Node(2);
        printLinkedList(head1);
        head1 = withOutArray(head1, 5);
        printLinkedList(head1);

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static Node useArray(Node head, int target) {
        //将链表放入数组中
        Node cur = head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        Node[] arr = new Node[size];
        cur = head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cur;
            cur = cur.next;
        }
        //partition过程
        partition(arr, target);
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1].next = arr[i];
        }
        arr[arr.length - 1].next = null;
        return arr[0];

    }

    public static void partition(Node[] arr, int target) {
        int less = -1;
        int more = arr.length;
        int i = 0;
        while (i < more) {
            if (arr[i].value < target) {
                swap(arr, i++, ++less);
            } else if (arr[i].value > target) {
                swap(arr, i, --more);
            } else {
                i++;
            }
        }
    }

    public static void swap(Node[] arr, int i, int j) {
        Node temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static Node withOutArray(Node head, int target) {
        Node smallHead = null;
        Node smallLast = null;
        Node equalHead = null;
        Node equalLast = null;
        Node bigHead = null;
        Node bigLast = null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = null;
            if (cur.value < target) {
                if (smallHead == null) {
                    smallHead = cur;
                    smallLast = cur;
                } else {
                    smallLast.next = cur;
                    smallLast = smallLast.next;
                }
            } else if (cur.value == target) {
                if (equalHead == null) {
                    equalHead = cur;
                    equalLast = cur;
                } else {
                    equalLast.next = cur;
                    equalLast = equalLast.next;
                }
            } else {
                if (bigHead == null) {
                    bigHead = cur;
                    bigLast = cur;
                } else {
                    bigLast.next = cur;
                    bigLast = bigLast.next;
                }
            }
            cur = next;
        }
        if (smallHead != null) {
            smallLast.next = equalHead;
            if (equalHead != null) {
                equalLast.next = bigHead;
            } else {
                smallLast.next = bigHead;
            }
            return smallHead;
        } else {
            if (equalHead != null) {
                equalLast.next = bigHead;
                return equalHead;
            } else {
                return bigHead;
            }
            //另一种连接判断
//            if (sT != null) { // 如果有小于区域
//                sT.next = eH;
//                eT = eT == null ? sT : eT; // 下一步，谁去连大于区域的头，谁就变成eT
//            }
//            // 下一步，一定是需要用eT 去接 大于区域的头
//            // 有等于区域，eT -> 等于区域的尾结点
//            // 无等于区域，eT -> 小于区域的尾结点
//            // eT 尽量不为空的尾巴节点
//            if (eT != null) { // 如果小于区域和等于区域，不是都没有
//                eT.next = mH;
//            }
//            return sH != null ? sH : (eH != null ? eH : mH);
        }

    }


}
