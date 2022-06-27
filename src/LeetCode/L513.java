package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class L513 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode cur = que.poll();
            if (cur.right != null) {
                que.add(cur.right);
            }
            if (cur.left != null) {
                que.add(cur.left);
            }
            if (que.isEmpty()) {
                return cur.val;
            }
        }
        return 0;
    }
}
