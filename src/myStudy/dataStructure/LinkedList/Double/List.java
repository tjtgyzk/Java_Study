package myStudy.dataStructure.LinkedList.Double;

public class List {
    Node head = new Node(0, 0, null, null);

    private Node findLast(Node head) {
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    //添加节点
    public void add(Node n) {
        Node cur = findLast(this.head);
        cur.next = n;
        n.pre = cur;
    }

    //删除节点
    public void delete(int n) {
        Node cur = head.next;
        boolean flag = false;
        while (cur != null) {
            if (cur.no == n) {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                flag = true;
                System.out.println("删除成功");
                break;
            } else {
                cur = cur.next;
            }
        }
        if (flag == false) {
            System.out.println("未找到该节点");
        }
    }

    public void showList() {
        Node cur = head.next;
        while (cur != null) {
            System.out.print("no:" + cur.no + " " + "data:" + cur.data + " ");
            cur = cur.next;
        }
        System.out.println(" ");
    }
}
