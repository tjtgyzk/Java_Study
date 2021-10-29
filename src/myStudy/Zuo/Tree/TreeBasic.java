package myStudy.Zuo.Tree;

import myStudy.Zuo.Trie.Trie;

import java.util.Deque;
import java.util.LinkedList;

public class TreeBasic {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        pre1(head);
        System.out.println();
        in1(head);
        System.out.println();
        pos1(head);
    }

    //递归版前序中序后序遍历
    public static void pre(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        pre(head.left);
        pre(head.right);
    }

    public static void in(TreeNode head) {
        if (head == null) {
            return;
        }
        in(head.left);
        System.out.print(head.value + " ");
        in(head.right);
    }

    public static void pos(TreeNode head) {
        if (head == null) {
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.print(head.value + " ");
    }

    //非递归版前序中序后序遍历
    public static void pre1(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            System.out.print(cur.value + " ");
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    public static void in1(TreeNode head) {
        TreeNode cur = head;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.print(cur.value + " ");
                cur = cur.right;
            }
        }
    }

    public static void pos1(TreeNode head) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> res = new LinkedList<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!res.isEmpty()) {
            System.out.print(res.pop().value + " ");
        }
    }
}
