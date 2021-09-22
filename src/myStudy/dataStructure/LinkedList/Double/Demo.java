package myStudy.dataStructure.LinkedList.Double;

public class Demo {
    public static void main(String[] args) {
        Node n1 = new Node(1,10);
        Node n2 = new Node(2,11);
        Node n3 = new Node(3,12);
        Node n4 = new Node(4,13);
        List list = new List();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        list.add(n4);
        list.showList();
        list.delete(3);
        list.showList();

    }
}
