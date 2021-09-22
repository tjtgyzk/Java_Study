package myStudy.dataStructure.LinkedList.Josephu;

public class CircleList {
    Node first = new Node(-1);
    Node cur = first;

    public void addNode(Node n) {
        if (first.getNo() == -1) {
            first = n;
            first.setNext(first);
        }
        Node temp = cur;
        cur = n;
        temp.setNext(n);
        n.setNext(first);
    }

    public void addList(int num) {
        if (num < 1) {
            System.out.println("num值不正确");
        }
        for (int i = 1; i <= num; i++) {
            //根据编号创建节点
            Node node = new Node(i);
            if (i == 1) {
                first = node;
                first.setNext(first);
                cur = first;
            } else {
                Node temp = cur;
                cur = node;
                temp.setNext(node);
                node.setNext(first);
            }
        }
    }

    public void play(int num) {
        Node play = cur;
        while (first != null) {
            for (int i = 0; i < num - 1; i++) {
                play = play.getNext();
            }
            Node temp = play.getNext();
            play.setNext(play.getNext().getNext());
            temp.setNext(null);
            first = play.getNext();
            System.out.println(temp.getNo());
        }
    }


}
