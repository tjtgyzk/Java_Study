package myStudy.Zuo.ShuaTi.Day02;

import java.util.ArrayList;
import java.util.HashMap;

public class ReceiveAndPrint {
    public static class MessageBox {
        public HashMap<Integer, Node> map;
        public int waitedPoint;

        public MessageBox() {
            map = new HashMap<>();
            waitedPoint = 1;
        }

        public void receive(int id, String message) {
            if (id < 1) {
                return;
            }
            Node cur = new Node(message);
            map.put(id, cur);
            if (map.containsKey(id - 1)) {
                map.get(id - 1).next = cur;
            }
            if (map.containsKey(id + 1)) {
                cur.next = map.get(id + 1);
            }
            if (id == waitedPoint) {
                print();
            }
        }

        private void print() {
            Node head = map.get(waitedPoint);
            while (head != null) {
                System.out.print(head.message + " ");
                map.remove(waitedPoint++);
                head = head.next;
            }
            System.out.println();
        }

        private class Node {
            String message;
            Node next;

            public Node(String message) {
                this.message = message;
            }
        }
    }

    public static void main(String[] args) {
        MessageBox messageBox = new MessageBox();
        messageBox.receive(2, "B");
        messageBox.receive(3, "C");
        messageBox.receive(4, "D");
        messageBox.receive(6, "F");
        messageBox.receive(7, "G");
        messageBox.receive(1, "A");
        messageBox.receive(5, "E");

    }
}
