package myStudy.Zuo.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Test_03 {
    public static void main(String[] args) {
        NodeR head = new NodeR(1);
        NodeR n2 = new NodeR(2);
        NodeR n3 = new NodeR(3);
        head.next = n2;
        n2.next = n3;
        n3.next = null;
        head.random = n3;
        n2.random = head;
        n3.random = n3;
        NodeR newHead1 = useMap(head);
        NodeR newHead2 = withoutMap(head);
        System.out.println();
    }

    public static NodeR useMap(NodeR head) {
        Map<NodeR, NodeR> map = new HashMap<>();
        NodeR cur = head;
        while (cur != null) {//遍历链表生成对应的克隆节点
            map.put(cur, new NodeR(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static NodeR withoutMap(NodeR head) {
        NodeR cur = head;
        while (cur != null) {//新节点在旧节点后
            NodeR next = cur.next;
            NodeR newN = new NodeR(cur.value);
            cur.next = newN;
            newN.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {//设置好random
            NodeR newN = cur.next;
            newN.random = cur.random.next;
            cur = newN.next;
        }
        cur = head;
        NodeR newHead = cur.next;
        while (cur.next.next != null) {
            NodeR newN = cur.next;
            cur.next = cur.next.next;
            newN.next = newN.next.next;
            cur = cur.next;
            newN = newN.next;
        }
        cur.next = null;
        return newHead;
    }

}
