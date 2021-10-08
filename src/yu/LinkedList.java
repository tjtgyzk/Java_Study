package yu;

public class LinkedList {
    public static Node head = new Node(0, null);
    private Node cur = head;
    static int size = 0;

    public Node getCur() {
        return cur;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public void Destroy(LinkedList l) {
        l.head = null;
        cur = head;
    }

    public static int findSize(LinkedList l) {
        return l.size;
    }

    public void add(Node n) {
        cur.next = n;
        cur = cur.next;
        size++;
    }

    public int serch(int n) {
        int index = 1;
        Node temp = head.next;
        while (temp != null) {
            if (temp.data == n) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return 0;
    }

    public void delete(int data) {
        while (head.data == data) {
            head = head.next;
            size--;
        }//头节点不是要删除的数据
        Node temp = head;
        while (temp.next != null) {
            Node cur = temp.next;
            while (cur.data == data) {//找到不需要删除的节点
                cur = cur.next;
                size--;
            }
            temp.next = cur;
            temp = temp.next;
        }
    }

    public void print(LinkedList l) {
        Node temp = head.next;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.printf("\n");
    }

    public static void reverse() {
        if (isEmpty()) {
            System.out.println("SB");
            return;
        }
        Node newHead = null;
        Node pre = null;
        Node cur = head;
        Node next = cur.next;

        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        Node temp = cur;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = null;
        head.next = cur;

    }

}
