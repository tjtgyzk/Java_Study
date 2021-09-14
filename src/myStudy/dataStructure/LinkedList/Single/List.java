package myStudy.dataStructure.LinkedList.Single;

public class List {
    Node head = new Node();

    public List() {
    }

    //寻找表尾
    private Node findLast() {
        Node temp = new Node();
        temp = head;
        while (true) {
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
        }
        return temp;
    }

    //添加数据
    public void add(Node n) {
        findLast().setNext(n);
    }

    //打印链表
    public void show() {
        Node temp = new Node();
        temp = head.getNext();
        if(head.getNext()==null){
            System.out.println("链表为空");
            return;
        }
        while(temp!=null){
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
    }
}

