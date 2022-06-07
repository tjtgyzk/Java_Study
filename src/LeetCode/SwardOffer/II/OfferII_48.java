package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class OfferII_48 {
    Queue<TreeNode> que;
    StringBuilder sb;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        que = new LinkedList<>();
        que.add(root);
        sb = new StringBuilder();
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur == null) {
                sb.append("#").append(",");
            } else {
                sb.append(cur.val).append(",");
                que.add(cur.left);
                que.add(cur.right);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] strs = data.split(",");
        int index = 0;
        TreeNode root = strs[index].equals("#") ? null : new TreeNode(Integer.parseInt(strs[index]));
        index++;
        que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            cur.left = strs[index].equals("#") ? null : new TreeNode(Integer.parseInt(strs[index]));
            index++;
            cur.right = strs[index].equals("#") ? null : new TreeNode(Integer.parseInt(strs[index]));
            index++;
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new OfferII_48().serialize(root));
        String serialize = new OfferII_48().serialize(root);
        root = new OfferII_48().deserialize(serialize);
    }
}
