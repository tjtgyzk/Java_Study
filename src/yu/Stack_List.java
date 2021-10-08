package yu;

public class Stack_List {
    doubleNode head = null;//指针，指向栈顶
    int size = 0;

    public void push(int n) {
        doubleNode node = new doubleNode(n);
        head = doubleList.addHead(head, node);
        size++;
    }

    public int pop() {
        int ans = head.data;
        head = head.next;
        size--;
        return ans;
    }

    public void show() {
        doubleNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

    }

}
