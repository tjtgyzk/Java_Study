package LeetCode;

import LeetCode.SwardOffer.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class L965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        int target = root.val;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.val != target) {
                return false;
            }
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (cur.right != null) {
                que.add(cur.right);
            }
        }
        return true;
    }
}
