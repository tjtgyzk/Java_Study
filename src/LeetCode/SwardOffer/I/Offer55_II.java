package LeetCode.SwardOffer.I;

import LeetCode.SwardOffer.TreeNode;

public class Offer55_II {
    public class Info {
        int height;
        boolean isBST;

        public Info(int height, boolean isBST) {
            this.height = height;
            this.isBST = isBST;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBST;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);
        return new Info(Math.max(leftInfo.height, rightInfo.height) + 1, leftInfo.isBST && rightInfo.isBST && Math.abs(leftInfo.height - rightInfo.height) <= 1);
    }
}
