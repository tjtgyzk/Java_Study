package myStudy.Zuo.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_JianZhi048 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        String s = serialize(head);
        head = deserialize(s);
    }

    public static String encode(TreeNode root, String ans) {
        if (root == null) {
            ans = ans + "#" + ",";
            return ans;
        }
        ans = ans + root.value + ",";
        ans = encode(root.left, ans);
        ans = encode(root.right, ans);
        return ans;
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        String ans = new String();
        return encode(root, ans);
    }

    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        String[] arr = data.split(",");
        for (String s : arr) {
            ans.add(s);
        }
        return decode(ans);

    }

    public static TreeNode decode(Queue<String> ans) {
        if (ans.size() == 0) {
            return null;
        }
        String cur = ans.poll();
        if (cur.equals("#")) {
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(cur));
        head.left = decode(ans);
        head.right = decode(ans);
        return head;
    }
}
