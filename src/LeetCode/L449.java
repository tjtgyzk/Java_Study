package LeetCode;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return new String();
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                sb.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            } else {
                sb.append("n" + ",");
            }
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] s = data.split(",");
        TreeNode root = s[0].equals("n") ? null : new TreeNode(Integer.parseInt(s[0]));
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index != s.length) {
            TreeNode cur = queue.poll();
            cur.left = s[index].equals("n") ? null : (new TreeNode(Integer.parseInt(s[index])));
            index++;
            cur.right = s[index].equals("n") ? null : new TreeNode(Integer.parseInt(s[index]));
            index++;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        L449 l449 = new L449();
        String s = l449.serialize(root);
        System.out.println(l449.deserialize("3,1,4,x,2"));
    }
}
