package myStudy.Zuo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class XuLieHua {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        Queue<String> code = levelEncoding(head);
        System.out.println(code);
        head = levelDecoding(code);
        System.out.println();
    }

    public static Queue<String> preEncode(TreeNode root) {
        Queue<String> ans = new LinkedList<>();
        if (root == null) {
            return null;
        }
        preen(root, ans);
        return ans;
    }

    public static void preen(TreeNode root, Queue<String> ans) {
        if (root == null) {
            ans.add(null);
            return;
        }
        ans.add(String.valueOf(root.value));
        preen(root.left, ans);
        preen(root.right, ans);
    }

    public static TreeNode preDecode(Queue<String> que) {
        if (que.size() == 0 || que == null) {
            return null;
        }
        return prede(que);
    }

    public static TreeNode prede(Queue<String> que) {
        String cur = que.poll();
        if (cur == null) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(cur));
        head.left = prede(que);
        head.right = prede(que);
        return head;
    }

    public static Queue<String> levelEncoding(TreeNode head) {
        if (head == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        Queue<TreeNode> que = new LinkedList<>();
        ans.add(String.valueOf(head.value));
        que.add(head);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.left != null) {
                que.add(cur.left);
                ans.add(String.valueOf(cur.left.value));
            } else {
                ans.add(null);
            }
            if (cur.right != null) {
                que.add(cur.right);
                ans.add(String.valueOf(cur.right.value));
            } else {
                ans.add(null);
            }
        }
        return ans;
    }

    public static TreeNode levelDecoding(Queue<String> ans) {
        TreeNode head = stringToNode(ans.poll());
        if (head == null) {
            return null;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(head);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            cur.left = stringToNode(ans.poll());
            cur.right = stringToNode(ans.poll());
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        return head;
    }

    public static TreeNode stringToNode(String s) {
        if (s == null) {
            return null;
        }
        return new TreeNode(Integer.valueOf(s));
    }
}
