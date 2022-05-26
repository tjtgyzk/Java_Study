package LeetCode.SwardOffer.II;

public class OfferII_29 {
    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node ans = new Node(insertVal);
            ans.next = ans;
            return ans;
        }
        if (head.next == head) {
            Node in = new Node(insertVal, head);
            head.next = in;
            return head;
        }
        Node cur = head;
        boolean round = false;
        Node biggest = cur;
        while (true) {
            if (cur.val > cur.next.val) {
                biggest = cur;
            }
            if ((insertVal >= cur.val && insertVal <= cur.next.val)) {
                Node node = new Node(insertVal);
                Node next = cur.next;
                cur.next = node;
                node.next = next;
                break;
            }
            //如果找一圈都没有,说明要加入的数大于所有已有数或者小于所有已有数,找到原链表最大的点,插入,如3-5-1 插0,或3,5,1 插6
            if (round) {
                Node node = new Node(insertVal);
                Node next = biggest.next;
                biggest.next = node;
                node.next = next;
                break;
            }
            if (cur.next == head) {
                round = true;
            }
            cur = cur.next;
        }
        return head;
    }
}
