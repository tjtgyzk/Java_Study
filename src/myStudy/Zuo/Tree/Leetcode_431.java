package myStudy.Zuo.Tree;

import java.util.LinkedList;
import java.util.List;

public class Leetcode_431 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = todo(root.children);
        return head;
    }

    public static TreeNode todo(List<Node> child) {
        TreeNode brother = null;
        TreeNode cur = null;
        for (Node boy : child) {
            if (brother == null) {
                brother = new TreeNode(boy.val);
                cur = brother;
            } else {
                cur.right = new TreeNode(boy.val);
                cur = cur.right;
            }
            cur.left = todo(boy.children);
        }
        return brother;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Node head = new Node(root.value);
        head.children = getChild(root.left);//第一个孩子是左子树!
        return head;
    }

    public List<Node> getChild(TreeNode node) {
//        if (node == null) { 返回可以是空的List但不能是null
//            return null;
//        }
        List<Node> child = new LinkedList<>();
        while (node != null) {
            Node asBrother = new Node(node.value);
            asBrother.children = getChild(node.left);
            child.add(asBrother);
            node = node.right;
        }
        return child;
    }
}
