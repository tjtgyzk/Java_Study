package myStudy.dataStructure.LinkedList.Single;

public class Demo {
    public static void main(String[] args) {
        List list = new List();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        list.show();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.show();
    }
}
