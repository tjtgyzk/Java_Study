package LeetCode.SwardOffer.I;

import java.util.ArrayList;
import java.util.List;

public class Offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    List<Node> list = new ArrayList<Node>();

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        in(root, list);
        if (list.size() == 1) {
            list.get(0).left = list.get(0);
            list.get(0).right = list.get(0);
            return list.get(0);
        }
        list.get(0).left = list.get(list.size() - 1);
        list.get(0).right = list.get(1);
        list.get(list.size() - 1).right = list.get(0);
        list.get(list.size() - 1).left = list.get(list.size() - 2);
        for (int i = 1; i <= list.size() - 2; i++) {
            list.get(i).left = list.get(i - 1);
            list.get(i).right = list.get(i + 1);
        }
        return list.get(0);
    }

    public void in(Node root, List<Node> list) {
        if (root == null) {
            return;
        }
        in(root.left, list);
        list.add(root);
        in(root.right, list);
    }
}
