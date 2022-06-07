package LeetCode.SwardOffer.II;

import LeetCode.SwardOffer.TreeNode;

public class OfferII_47 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        return dfs(root) ? null : root;

    }

    public boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) {
            root.left = null;
        }
        if (right) {
            root.right = null;
        }
        if (root.val == 0 && left && right) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        new OfferII_47().pruneTree(root);
    }
}
