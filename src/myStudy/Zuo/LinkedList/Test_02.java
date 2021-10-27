package myStudy.Zuo.LinkedList;

import java.util.ArrayList;

public class Test_02 {
    public static void useArray(Node head, int target) {
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


    }
}
