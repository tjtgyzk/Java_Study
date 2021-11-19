package yu;

public class HouJi {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getnext(Node x) {
        if (x.right != null) {
            return getLeftMost(x.right);
        }
        //没有右子树
        Node parent = x.parent;
        while (parent != null) {
            if (parent.left == x) {
                return parent;
            }
            x = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public static Node getLeftMost(Node head) {
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

}
