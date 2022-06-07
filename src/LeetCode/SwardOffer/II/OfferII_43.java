package LeetCode.SwardOffer.II;

import java.util.LinkedList;
import java.util.Queue;

public class OfferII_43 {
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

    class CBTInserter {
        Queue<TreeNode> que;
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            que = new LinkedList<>();
            que.add(root);
        }

        public boolean isFull(TreeNode root) {
            return root.left != null && root.right != null;
        }

        public int insert(int v) {
            while (!que.isEmpty()) {
                if (que.peek().left == null) {
                    que.peek().left = new TreeNode(v);
                    return que.peek().val;
                } else if (que.peek().right == null) {
                    que.peek().right = new TreeNode(v);
                    TreeNode cur = que.poll();
                    que.add(cur.left);
                    que.add(cur.right);
                    return cur.val;
                } else {
                    TreeNode cur = que.poll();
                    que.add(cur.left);
                    que.add(cur.right);
                }
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
