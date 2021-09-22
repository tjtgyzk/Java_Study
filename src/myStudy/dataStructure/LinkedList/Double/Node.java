package myStudy.dataStructure.LinkedList.Double;

public class Node {
    int no = 0;
    int data = 0;
    Node next = null;
    Node pre = null;

    public Node() {
    }

    public Node(int no, int data) {
        this.no = no;
        this.data = data;
    }

    public Node(int no, int data, Node next, Node pre) {
        this.no = no;
        this.data = data;
        this.next = next;
        this.pre = pre;
    }
}
